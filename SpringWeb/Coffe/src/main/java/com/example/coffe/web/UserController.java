package com.example.coffe.web;

import com.example.coffe.model.binding.LoginUserBindingModel;
import com.example.coffe.model.binding.UserRegisterBindingModel;
import com.example.coffe.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String confirmRegister(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() ||
                !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:register";

        }

        userService.register(userRegisterBindingModel);


        return "redirect:login";

    }

    @GetMapping("/login")
    public String login(Model model){

        if(!model.containsAttribute("isFound")){
            model.addAttribute("isFound",true);
        }
        return "login";
    }


    @PostMapping("/login")
    public String confirmLogin(@Valid LoginUserBindingModel loginUserBindingModel,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes){


        if (bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("loginUserBindingModel",loginUserBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.loginUserBindingModel", bindingResult);

            return "redirect:login";


        }

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("loginUserBindingModel", loginUserBindingModel)
                    .addFlashAttribute("isFound", false);

            return "redirect:login";
        }

        userService.login(loginUserBindingModel);

        return "redirect:/";
    }


    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();

        return "redirect:/";

    }


    @ModelAttribute
    public LoginUserBindingModel loginUserBindingModel(){
        return new LoginUserBindingModel();

    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }
}
