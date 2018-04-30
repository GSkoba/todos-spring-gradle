package com.todos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String text;
    private String userId;
    private boolean state;

    public Todo() {

    }


    public Todo(String text, boolean state, String userId) {
        this.text = text;
        this.state = state;
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

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
