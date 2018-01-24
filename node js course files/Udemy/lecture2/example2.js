/**
 * Created by rishabh on 22-01-2018.
 */
var relay = require('./exp2');
prefix = "Attention: ";
// var prefix = "Attention: ";
relay('Box office closes at 10');

//Notice that only index.js will searched and executed when you put
//directory name. The var prefix here acted as global variable whose
//value has been changed to attention from relaying
//Note that if a var has been put before prefix, prefix will now
//become local variable and the prefix in index file will not be
//changed