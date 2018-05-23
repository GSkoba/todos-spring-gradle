package com.todos.model;

import javax.persistence.*;

@Entity
@Table (name = "Session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne (optional = false, cascade = CascadeType.ALL)
    @JoinColumn (name = "userId_id")
    private User userId;
    private String token;

    public Session() {
    }

    public Session(User userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
