package com.codeup.springblog;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL UNIQUE")
    private String username;

    @Column(columnDefinition = "VARCHAR(100) NOT NULL UNIQUE")
    private String email;

    @Column(columnDefinition = "VARCHAR(180) NOT NULL")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentUser")
    private List<Post> posts;

    public User() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(long id, String username, String email, String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
