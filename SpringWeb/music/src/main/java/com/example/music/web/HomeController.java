package com.example.music.web;

import com.example.music.model.enums.ArtistEnum;
import com.example.music.model.helper.CurrentUser;
import com.example.music.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class HomeController {

    private CurrentUser currentUser;

    private AlbumService albumService;





    public HomeController(CurrentUser currentUser, AlbumService albumService) {
        this.currentUser = currentUser;
        this.albumService = albumService;
    }

    @GetMapping("/")
    public String index(Model model){
        if (currentUser.getId() == null){
            return "index";
        }


        model.addAttribute("totalCopies",albumService.getAllCopies());
        model.addAttribute("total",albumService.getCopies());

        return "home";
    }


}
