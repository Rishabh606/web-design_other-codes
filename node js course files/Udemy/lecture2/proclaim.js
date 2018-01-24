/**
 * Created by rishabh on 22-01-2018.
 */
var whisper= function (msg) {
    console.log('Proclaiming: '+ msg);
};
exports.softly = whisper; //example3

exports.loudly = function (msg) {
    console.log('PROCLAIMING: '+ msg);
};

/*
please notice that it is exports.loudly etc and not module.exports.
This allows function to be acccessible by '.' in the example3 by say.loudly
*/
