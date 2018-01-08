/**
 * Created by rishabh on 14-07-2017.
 */
var express = require('express');
var app = express();
var http = require('http');
var server = http.createServer(app);

var socket = require('socket.io');
var io = socket(server);
var chat = [];
var users = [];
app.use('/', express.static('public_static'));
//io means root and hey here referes to person who is sending you the message only
io.on('connection', function (hey) {
    console.log('connection is on');
    /*hey.on('start',function (data) {
        var x = {id:hey.id, user:data.username, connect: true};
       status.push(x);
    });*/
   hey.on('message', function (data) {
        console.log(data);
    });
   io.emit('all',chat);
    hey.on('disconnect', function () {
        console.log('disconnected');
        delete users[hey.id];
        console.log('user disconnected'+hey.id);
        /*
        status.forEach(client=>{
            if(hey.id===client.id){
                client.connect = false;
            }
        })*/
        //console.log(status);
    })
    hey.on('rec_message', function (data) {
        //hey.emit will send message to that person
        chat.push(data);
        io.emit('get',data);
        console.log(data);
    })
    hey.on('users',function (data) {
        users[hey.id] =data;
        console.log(data,hey.id);
    });
    io.emit()
});

server.listen(5000, function () {
    console.log("server is running at 5000")
});