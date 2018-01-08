/**
 * Created by rishabh on 07-07-2017.
 */
$(function () {
    $('#btn').click(function () {
        var value = $("#inp").val();
        $.get('/getData?todo='+value, function (data) {
            console.log(data);
            $('#output').append(value+'<br>');
        });
        //console.log("response is not recieved");
    })
});