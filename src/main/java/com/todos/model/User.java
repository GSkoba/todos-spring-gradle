package com.todos.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String login;

    private String hash;

    @OneToOne(optional = false, mappedBy = "userId")
    private Session sessionid;

    @OneToMany(mappedBy = "id", fetch = FetchType.EAGER)
    private Collection<Todo> todos;


    public User() {
    }

    public User(String login, String hash) {
        this.login = login;
        this.hash = hash;
    }

    public void setTodos(Collection<Todo> todos) {
        this.todos = todos;
    }

    public Collection<Todo> getTodos() {
        return todos;
    }

    public void setSessionid(Session sessionid) {
        this.sessionid = sessionid;
    }

    public Session getSessionid() {
        return sessionid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
