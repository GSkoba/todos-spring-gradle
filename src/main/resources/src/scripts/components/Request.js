newTodoRequest = function(method,url,data) {
    var xhr = new XMLHttpRequest();

    var json = JSON.stringify({
        itemText: data.text
    });

    xhr.open(method, url, true);
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');

    xhr.send(json);
};