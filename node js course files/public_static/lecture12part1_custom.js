/**
 * Created by rishabh on 09-07-2017.
 */
$(function () {
    $('#btn').click(function () {
        $.get({url:'/todo/get',success: function (data) {
            console.log(data);
        }})
    })
});