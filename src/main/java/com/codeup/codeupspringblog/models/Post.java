package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Post {


//    ****** Properties ********
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 150, nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT NOT NULL")
    private String body;

//    ***** Constructor *********

    public Post() {
    }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

//    ******* Getters and Setters ********


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
