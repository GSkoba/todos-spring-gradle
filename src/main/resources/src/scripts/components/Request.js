newTodoRequest = function (method, url, data) {
    var xhr = new XMLHttpRequest();

    var json = JSON.stringify({
        itemText: data.text
    });

    xhr.open(method, url, true);
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');

    xhr.send(json);
};

delTodoRequest = function (data) {
    var xhr = new XMLHttpRequest();

    var json = JSON.stringify({
        itemText: data.text
    });

    xhr.open("POST", "/delTodo", true);
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);

};

changeItemStateRequest = function (data) {

    var xhr = new XMLHttpRequest();

    var json = JSON.stringify({
        itemText: data.text,
        itemState: data.isReady
    });

    xhr.open("POST", "/changeItemState", true);
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send(json);

};

markAsReadyAllRequest = function () {

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/markAllLikeDone", true);
    xhr.send();
};

getAllElementFromServer = function (todoList) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            var res = JSON.parse(this.responseText);
            res.forEach(function (todoData) {
                todoList.createItem(todoData);
            });
        }
    };

    xhr.open("GET", '/getAll', true);
    xhr.send();
};