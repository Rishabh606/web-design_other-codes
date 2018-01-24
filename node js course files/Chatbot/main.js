/**
 * Created by rishabh on 16-01-2018.
 */
var express = require('express');
var parser = require('body-parser');
var request = require('request');

var app = express();

app.set('port', (process.env.PORT || 1337))
/*
 Okay, contrary to what I previously thought, further research shows that extended: true and app.use(bodyParser.json()) can be used together. So it is not only extended: false that uses it. The statement app.use(bodyParser.json()) is to be used independently, whether you set extended as true or false.

 app.use(bodyParser.json()) basically tells the system that you want json to be used.

 bodyParser.urlencoded({extended: ...}) basically tells the system whether you want to use a simple algorithm for shallow parsing (i.e. false) or complex algorithm for deep parsing that can deal with nested objects (i.e. true).*/
app.use(parser.urlencoded({extended: false}))
app.use(parser.json())
//Routes
app.get('/', function (req, res) {
    res.send("Hi i am a chatbot")
})
//facebook
app.get('/webhook/', function () {
    if (req.query['hub.verify_token'] === "adityameghna_in_a_resort") {
        res.send(req.query['hub.challenge'])
    }
    res.send("Wrog token");
})
app.listen()(app.get('port'))