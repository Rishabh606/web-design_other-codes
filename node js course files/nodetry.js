/**
 * Created by rishabh on 05-07-2017.
 */
/*var a = process.argv.slice(2);
a.sort(function (a,b) {
    return a- b;
});

var b = a.map(function (x) {
    return parseInt(x);
});*/
console.log(process.argv.slice(2).sort((a,b)=>a-b).map((x) => parseInt(x)));
//console.log(b);