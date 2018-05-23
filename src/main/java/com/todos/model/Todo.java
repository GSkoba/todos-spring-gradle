package com.todos.model;

import javax.persistence.*;


@Entity
@Table(name = "Todo")
public class Todo {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "judgements_id_seq")
    @SequenceGenerator(name = "judgements_id_seq", sequenceName = "judgements_id_seq", allocationSize = 1)
    private Integer id;
    private String text;

    @ManyToOne(optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "userId_id")
    private User userId;

    private boolean done;

    public Todo() {

    }


    public Todo(String text, boolean done, User userId) {
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
