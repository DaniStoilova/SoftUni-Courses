package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.util.CurrentUser;
import com.example.spotifyplaylistapp.model.binding.SongAddBindingModel;
import com.example.spotifyplaylistapp.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    private final CurrentUser currentUser;

    public SongController(SongService songService, CurrentUser currentUser) {
        this.songService = songService;
        this.currentUser = currentUser;
    }


    @GetMapping("/add")
    public String add(){

        return "song-add";
    }

    @PostMapping("/add")
    public String confirmAdd(@Valid SongAddBindingModel songAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("songAddBindingModel",songAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.songAddBindingModel",bindingResult);


            return "redirect:add";

        }

       songService.add(songAddBindingModel);


        return "redirect:/";

    }


    @ModelAttribute
    public SongAddBindingModel songAddBindingModel(){
        return new SongAddBindingModel();
    }
}
