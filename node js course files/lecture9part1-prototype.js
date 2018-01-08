/**
 * Created by rishabh on 28-06-2017.
 */
function Person(name, school) {
    this.name = name;
    this.school = school;
}
Person.prototype.setClass = function (class) {
    console.log("the name is "+ this.name);
    this.class = class;
}
Person.prototype.getClass = function() {
    console.log(this.name);
    console.log(this.class);
}
