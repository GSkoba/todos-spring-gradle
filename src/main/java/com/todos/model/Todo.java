package com.todos.model;

import javax.persistence.*;


@Entity
@Table(name = "Todo")
public class Todo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String text;
    private String userId;
    private boolean done;

    public Todo() {

    }


    public Todo(String text, boolean done, String userId) {
        this.text = text;
        this.done = done;
        this.userId = userId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
