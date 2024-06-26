package com.likebookapp.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class User extends BaseEntity {

    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    @Column(unique = true,nullable = false)
    private String email;

    @ManyToMany(mappedBy = "userLikes",fetch = FetchType.EAGER)
    private Set<Post> likedPost;

    @OneToMany(mappedBy = "creator")
    private Set<Post> posts;


    public Set<Post> getLikedPost() {
        return likedPost;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public void setLikedPost(Set<Post> likedPost) {
        this.likedPost = likedPost;
    }

    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
