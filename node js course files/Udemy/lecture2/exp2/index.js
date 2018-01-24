/**
 * Created by rishabh on 22-01-2018.
 */
prefix = "Relaying: ";
// var prefix = "Relaying: ";
module.exports = function (message) { //exports to example2.js
    console.log(prefix+message);
 //   console.log(this.prefix+message);
};
//1. it is to be noted that putting variable prefix without var means we have
//created a local variable. Now prefix can be changed in any file connected
//to index.js.
//2. But if we had created var prefix and not prefix the console will show
//Relaying instead of Attention as js will look for local varable first
//instead of global one
//3. But even if keep var and want to see the global prefix then use
//'this.prefix' as it return global variable, if and only if prefix present
//in example 2 is without var. If it is with var then it will give
//undefined.