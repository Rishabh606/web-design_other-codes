/**
 * Created by rishabh on 12-07-2017.
 */
$(function () {
    $('#table').click(function () {
        $.get({url:'/todos/all',success: function (data) {
            console.log(data);
        }})
    })
    $('#delete').click(function () {
        $.post('/todos/delete',{id: $('#ID').val()},function (data) {
            console.log(data);
        })
    })
    $('#update').click(function () {
        $.post('/todos/update',{id: $('#ID').val(), done: $('#Done').val()},function (data) {
            console.log(data);
        })
    })
    $('#insert').click(function () {
        $.post('/todos/insert',{task: $('#Task').val()},function (data) {
            console.log(data);
        })
    })
});