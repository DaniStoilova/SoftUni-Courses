package com.example.music.web;

import com.example.music.model.binding.AddAlbumBindingModel;
import com.example.music.service.AlbumService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AlbumController {

    private AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }


    @GetMapping("/add")
    public String add(){
        return "add-album";
    }

    @PostMapping("/add")
    public String confirm(@Valid AddAlbumBindingModel addAlbumBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addAlbumBindingModel",addAlbumBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addAlbumBindingModel", bindingResult);

            return "redirect:add";
        }

        albumService.addAlbum(addAlbumBindingModel);


        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String del(@PathVariable Long id){

        albumService.remove(id);

        return "redirect:/";
    }

    @ModelAttribute
    public AddAlbumBindingModel addAlbumBindingModel(){
        return  new AddAlbumBindingModel();
    }


}
