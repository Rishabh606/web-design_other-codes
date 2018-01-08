/**
 * Created by rishabh on 12-07-2017.
 */
/**
 * Created by rishabh on 12-07-2017.
 */
var express = require('express');
var app = express();
var path = require('path')
var port = 5000||process.env.port;
var sql = require('./public_new/sql');
var bodyparser = require('body-parser');
app.use(bodyparser.urlencoded({ extended: true }));
app.use(bodyparser.json());
app.set('view engine','hbs');
 app.set('views',path.join(__dirname,'public_new'));
// console.log(__dirname);
console.log(path.join(__dirname,'public_new'));
// app.use('/', express.static(path.join(__dirname,'public_new')));
app.get('/todos/all',function (req,res) {
    var query = "SELECT * FROM todos";
    sql.TodoList(query,function (data) {
        res.send(data);
    });
});
app.post('/todos/insert',function (req,res) {
    var query = 'INSERT into todos (task,done) VALUES ('+req.body.todo+',false)';
    sql.TodoList(query,function (data) {
        console.log(data);
        res.send(data)
    });
    //res.send("Insert todo")
});
app.post('/todos/update',function (req,res) {
    var query = "UPDATE todos SET done="+req.body.done+ " where id="+req.body.id;
    sql.TodoList(query,function (data) {
        console.log(data);
        res.send(data)
    });
});
app.post('/todos/delete',function (req,res) {
    var query = "DELETE from todos where id="+req.body.id;
    sql.TodoList(query,function (data) {
        console.log(data);
        res.render('index',{todo: data});
    });
});
app.listen(port,function () {
    console.log("server is running");
});