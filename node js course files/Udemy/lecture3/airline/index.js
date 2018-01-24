var http = require('http');
var express = require('express');

var app = express();

app.get('/',function (req,res) {
    res.end('Airline');
});

http.createServer(app).listen(3000,'localhost');
//you create a server here by passing app
//the app executes app.get and finally we put server
//to listen to port 3000