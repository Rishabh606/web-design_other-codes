/**
 * Created by rishabh on 09-07-2017.
 */
var mysql = require('mysql');
var dbconfig={
host : 'localhost',
    user: 'newuser',
    password: 'newpassword',
    database: 'newdb'
};

function getTodos(cb){
    var connection = mysql.createConnection(dbconfig);
    console.log("sqlDB connected");
    connection.connect();
    connection.query('SELECT * FROM todos', function (error,rows,fields) {
        if(error) throw error;
        //console.log(rows);
        cb(rows);
    })

}
function updatetodos(id,cb) {
    var connection = mysql.createConnection(dbconfig);
    connection.connect();
    connection.query('UPDATE todos SET done=10 WHERE id='+id, function (error,row,fields) {
        console.log("ashish");
        console.log(row);
        /*connection.query('SELECT * FROM todos', function (error,rows,fields) {
            if(error) throw error;
            //console.log(rows);
            cb(rows);
        })*/
        cb(row);
    })
}

    module.exports = {
        get: getTodos,
        update : updatetodos
    }