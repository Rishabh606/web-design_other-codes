/**
 * Created by rishabh on 05-07-2017.
 */
var a = process.argv.slice(2);
var wtc = 0;
if(parseInt(a[0])>=15){
     wtc = (parseInt(a[0])-15)*1;
}
var kmc = 0;
if(parseInt(a[1])<2){
    kmc = 25;
}else {
   kmc= (parseInt(a[1]) - 2) * 25 + 25;
}
console.log(kmc+wtc);