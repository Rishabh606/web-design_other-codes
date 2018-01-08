/**
 * Created by rishabh on 24-07-2017.
 */
$("btn").click(function(){
    var URL = "https://loklak.org/api/search.json?timezoneOffset=-330&q=Amitabh+Bachchan&count=1";
    $.ajax({url: URL, success: function(result){
        console.log(result);
    }});
});
