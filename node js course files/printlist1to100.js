/**
 * Created by rishabh on 27-06-2017.
 */
var input1 = document.getElementById('input1');
var b = document.getElementById('get');
var v = document.getElementById('list');
var t = document.getElementById('timeteller');
window.onload = function () {
    b.onclick = function () {
        var inp = input1.value;
        var start = Date.now();
        for (var i = 1; i <= inp; i++) {
            if (i % 3 === 0 && i % 5 !== 0) {
                v.innerHTML += '<li>' + 'fizz' + '</li>';
            }
            else if (i % 5 === 0 && i % 3 !== 0) {
                v.innerHTML += '<li>' + 'buzz' + '</li>';
            }
            else if (i % 3 === 0 && i % 5 === 0) {
                v.innerHTML += '<li>' + 'fizz buzz' + '</li>';
            }
            else {
                v.innerHTML += '<li>' + i + '</li>';
            }
        }
        t.innerHTML = Date.now() - start;
    }
};