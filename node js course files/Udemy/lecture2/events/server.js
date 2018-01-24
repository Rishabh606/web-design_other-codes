/**
 * Created by rishabh on 22-01-2018.
 */
var http = require('http');
//we require http as it is the set the set of rules to make server
var handleRequest= function(req,res){
    res.writeHead(200,{'Content-Type': 'text/plain'});
    //head has different kinds of server 200, 404 etc we set one of it here
    //then we decide type of content. When you run the server you
    //will see Welcome to Node etc in plain text
    //this statement is not necessary
    res.end("Welcome to Node Training and Fundamentals\n");
    //this response is to end it.
};
// we make a function which has 2 variable request and respond
var server = http.createServer(handleRequest);
//running this handleRequest we are able to start the server. Now we
//just need to set our server to listen to a specific port to receive
//requests
server.listen(3000,'localhost');
//and with this we have set our server to listen to a port