/**
 * Created by rishabh on 07-07-2017.
 */
var express = require('express');
console.log(typeof (express));
var app = express();
var todolist = [];

// app.use will always work even if backslash is not given
//keep in mind to send the folder containing html file named as index and file of css, js which are attached to it should be in it.
//app.use('/', express.static('form coding blocks'));

/*app.use(express.static('index.html'));*/
app.use('/', express.static('public_static'));
// path localhost4000 is respresented by \ the further path needs to handeled differently
app.get('/',function (req,res) {
    res.send("index");
});
app.get('/getData',function (req,res) {
    todolist.push(req.query.todo);
    //res.send("updated");
    res.send(todolist);
});
// path after localhost4000/greet is given by this
//if res.send is not written in app.get it will run an infinte loop
app.get('/greet',function (req,res) {
    res.send("hey!");
});
app.get('/upload',function (req,res) {

});
//in front of checker type '?todo=ovan' this types ovan in front of hey.
app.get('/checker',function (req,res) {
    res.send("hey!"+ req.query.todo);
});
app.get('/tasks',function (req,res) {
    todolist.push(req.query.todo);
    res.send('')
});
app.get('/showcase',function (req,res) {
    res.send(todolist);
});
//process.env.port checks for other ports if 4000 or givenport is not free
app.listen(4000||process.env.port,function (response,err) {
    if(err) throw err; //throws error if port not available
    console.log("server is running port 4000");
});