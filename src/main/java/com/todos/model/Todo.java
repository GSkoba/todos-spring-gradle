package com.todos.model;

import javax.persistence.*;


@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @Column(name = "todo_id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "task")
    private  String task;

    @Column(name = "done")
    private boolean done;

    public Todo(){}

    public Todo(Integer id, String task, boolean done, Integer userId) {
        this.id = id;
        this.task = task;
        this.done = done;
        this.userId = userId;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTask() {
        return task;
    }

    public boolean isDone() {
        return done;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}

