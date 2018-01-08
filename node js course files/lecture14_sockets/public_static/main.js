/**
 * Created by rishabh on 14-07-2017.
 */
//var socket = io();
$(function () {
   // var arr = [];
    var socket = io();
   var username = prompt('user name');
    socket.emit('message', new Date().getTime());
    socket.on('start',{user: username});
    //$('#message').append(arr);
    $('.btn').click(function () {
        var inp = $('#inp').val();
        console.log(inp);
        /*socket.on('get',function (data) {
            arr = data;
            console.log(arr);
        });*/
        //console.log(arr);
       // arr.push({user:username, input: inp});
        socket.emit('rec_message',{user:username, input: inp});
       // socket.emit('rec_message',arr);
    });
    /*socket.on('get', function (data) {
        console.log(data);
    });*/
    socket.on('get', function (data) {
        var msg = '';
        msg+='<li>'+data.user+': '+data.input+'</li>';
        $('#message').append(msg);
    });

    /*socket.on('get', function (data) {
        var msg = '';
        $('#message').html('');
        for(let i = 0; i<data.length;i++) {
            msg += '<li>' + data[i].user + ': ' + data[i].input + '</li>';
            $('#message').append(msg);
        }
    });*/
    socket.on('all', function (data) {
        var msg = '';
        $('#message').html('');
        data.forEach(client=>{
            msg='<li>'+client.user+': '+client.input+'</li>';
            $('#message').append(msg);
        });
    });
});