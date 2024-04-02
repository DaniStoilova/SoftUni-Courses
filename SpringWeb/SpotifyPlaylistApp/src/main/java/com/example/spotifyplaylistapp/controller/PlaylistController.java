package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.UserService;
import com.example.spotifyplaylistapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PlaylistController {

    private final UserService userService;

    private final CurrentUser currentUser;


    public PlaylistController(UserService userService, CurrentUser currentUser) {
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @GetMapping("/create/{id}")
    public String addToPlaylist(@PathVariable Long id) {

        this.userService.addToPlaylist(id);

        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {

        userService.remove(currentUser.getId());

        return "redirect:/home";
    }

    @GetMapping("/removeAll")
    public String removeAll() {

        userService.removeAll();

        return "redirect:/";
    }
}
