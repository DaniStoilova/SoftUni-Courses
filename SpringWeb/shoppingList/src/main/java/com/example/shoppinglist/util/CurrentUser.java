package com.example.shoppinglist.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private Long id;

    private String username;

    public CurrentUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
//    public boolean isLoggedIn(){
//        return this.id != null;
//    }
//
//    public void setLoggedIn(boolean isLoggedIn){
//        this.id = null;
//    }
}
