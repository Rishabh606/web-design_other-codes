/**
 * Created by rishabh on 07-07-2017.
 */
var filesystem = require('fs');
/*filesystem.writeFile('text',"HelloWorld", function (err) {
    if (err) throw err;
    console.log("successful written");
})*/
filesystem.readFile('text', function (err,data) {
    if(err) throw err;
    console.log(data.toString());
})