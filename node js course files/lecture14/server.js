/**
 * Created by rishabh on 14-07-2017.
 */
var express = require('express');
var app = express();
var path = require('path');
var port = 5000||process.env.port;
var sql = require('./public_static/sql');
var bodyparser = require('body-parser');
app.use(bodyparser.urlencoded({ extended: true }));
app.use(bodyparser.json());
app.set('view engine','hbs');
app.set('views',path.join(__dirname,'public_static/views'));
app.get('/', function (req,res) {
    var query = 'SELECT * FROM todos';
    sql.TodoList(query,function (data) {
        res.render('index',{todo:data});
    });
});
app.post('/todos/insert', function (req,res) {
    var query = 'INSERT INTO todos (task,done) VALUES ("'+req.body.task+'",1)';
    sql.TodoList(query,function (data) {
        console.log(data);
        res.redirect('http://localhost:5000/');
    });
});
app.listen(port,function () {
    console.log("server is running"+port);
})