/**
 * Created by rishabh on 07-07-2017.
 */
var http = require('http');
var port=5000;
function requsethandler (req,res) {
    res.end("Hello World");
}
var server = http.createServer(requsethandler);
server.listen(port,function (err) {
    if (err) throw err;
    console.log("server is running " + port)
});