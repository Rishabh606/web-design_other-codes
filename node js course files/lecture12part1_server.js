/**
 * Created by rishabh on 09-07-2017.
 */
var express = require('express');
var sql = require('./public_static/sql.js');
var app = express();
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended: true }));
// parse application/json
app.use(bodyParser.json());
app.use('/', express.static('public_static'));
var todolist = [{"task":1},{"task": 2},{"task": 3}];
app.get('/todo/get',function (req,res) {
    sql.get(function (data) {
        console.log(data);
        res.send(data);
    });
  //  res.send(todolist);

});
app.post('/todo/post',function (req,res){
   sql.update(req.body.id,function (data) {
       res.send(data);
   });
   //res.send("Done POST" );
});
app.listen(5000,function () {
    console.log("server is running");
});