var l10n = require('./modules/l10n');

var TodoMain = require('./components/TodoMain');
var AddTodos = require('./components/AddTodos');
var TodoList = require('./components/TodoList');
var TodoActionsBar = require('./components/TodoActionsBar');
var Request = require('./components/Request');

function init() {
    var rusDictionary = {
        'todosCountLabel': ['task', 'tasks', 'tasks']
    };
    l10n.provideDict('ru', rusDictionary);

    var todoMain = new TodoMain();
    var addTodos = new AddTodos();
    var todoList = new TodoList();
    var todoActionsBar = new TodoActionsBar();

    getAllElementFromServer(todoList);

    addTodos
        .on('newTodo',
            function (todoData) {
            newTodoRequest('POST','/newTodo',todoData);
            todoList.createItem(todoData);
        }
        )
        .on('markAsReadyAll',
            function () { todoList.markAsReadyAll();}
        );

    function itemsCountWatcher () {
        var itemsCount = todoList.getItemsCount();

        if (itemsCount !== 0) {
            todoMain.showFullInterface();
        }

        todoActionsBar.setItemsCount(itemsCount);
    }

    todoList.on('itemAdd', itemsCountWatcher)
        .on('itemDelete', function () {

            itemsCountWatcher;
        });

    todoActionsBar.on(
        'clearCompleted',
        function () { todoList.removeCompletedItems(); }
    );

    todoActionsBar.on('filterSelected', function (filterId) {
        todoList.setFilter(filterId);
    });

}

document.addEventListener('DOMContentLoaded', init);