package com.example.streamingdienst.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIgnoreProperties(value = "comments")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;

    private String password;

    private Boolean admin;

    @OneToMany(mappedBy="user")
    private Set<Comment> comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

    public String getUserName() {return userName;}

    public void setUserName(String userName) {this.userName = userName;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public Boolean getAdmin() {return admin;}

    public void setAdmin(Boolean admin) {this.admin = admin;}

    public Set<Comment> getComments() {return comments;}

    public void setComments(Set<Comment> comments) {this.comments = comments;}
}
