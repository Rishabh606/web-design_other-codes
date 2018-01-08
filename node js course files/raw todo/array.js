/**
 * Created by rishabh on 23-06-2017.
 */
if(JSON.parse(localStorage.getItem('todo'))=== null){
    var todoList = new Array;
}
if(JSON.parse(localStorage.getItem('todo'))!== null){
    var todoList =JSON.parse(localStorage.getItem('todo'));
}
window.onload = function () {
    var inputValue = document.getElementById('getValue');
    var addTodo = document.getElementById('done');
    var outputValue = document.getElementById('output');

    addTodo.onclick = function () {
        var value = inputValue.value;
        outputValue.innerHTML = '';
        todoList.push({
            "task": value,
            "done": false
        });
        localStorage.setItem("todo",JSON.stringify(todoList));
        console.log(todoList);
        for(var i = 0; i<todoList.length;i++){
            // outputValue.innerHTML+= todoList[i].task + '</br>';
            if(todoList[i].done===false){
                outputValue.innerHTML+='<li onclick = "isstrikeThrough(this)"'+ 'id=' + i+'>'+todoList[i].task+'</li>';
            }else{
                outputValue.innerHTML+='<li onclick = "isstrikeThrough(this)" style="text-decoration: line-through;" '+ 'id=' + i+'>'+todoList[i].task+'</li>';
            }
         //   outputValue.innerHTML+='<li onclick = "isstrikeThrough(this)"'+ 'id=' + i+'>'+todoList[i].task+'</li>';
        }
    }
};
/*function strikeThrough(el) {

     console.log(el.id);
     console.log(todoList[el.id].done);
     console.log("st");
    todoList[el.id].done = true;
    el.style.textDecoration = 'line-through';
    localStorage.setItem("todo",JSON.stringify(todoList));
}
function unstrikeThrough(el) {

     console.log(el.id);
     console.log(todoList[el.id].done);
     console.log("unst");
    todoList[el.id].done = false;
    el.style.textDecoration = 'none';
    localStorage.setItem("todo",JSON.stringify(todoList));
}*/
function isstrikeThrough(el) {

    console.log(el.id);
    console.log(todoList[el.id].done);
    console.log("st");
    if(todoList[el.id].done===false){
        todoList[el.id].done = true;
        el.style.transition = 'opacity 250ms ease-in';
        el.style.textDecoration = 'line-through';
    }else{
        todoList[el.id].done = false;
        el.style.animationName
        el.style.textDecoration = 'none';
    }
    localStorage.setItem("todo",JSON.stringify(todoList));
}
