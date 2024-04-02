package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.util.CurrentUser;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.enums.StyleEnum;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class HomeController {

    private CurrentUser currentUser;

    private SongService songService;

    private UserService userService;




    public HomeController(CurrentUser currentUser, SongService songService, UserService userService) {
        this.currentUser = currentUser;
        this.songService = songService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }

        model.addAttribute("pop",songService.findAllSongsByStyleName(StyleEnum.POP));
        model.addAttribute("rock",songService.findAllSongsByStyleName(StyleEnum.ROCK));
        model.addAttribute("jazz",songService.findAllSongsByStyleName(StyleEnum.JAZZ));
        model.addAttribute("sum", songService.findTotal());


        List<Song> userSongs = this.userService.getUserSongs();

        model.addAttribute("userSongs", userSongs);


        return "home";
    }

}
