package com.crp.chatroomproject.controllers;

import com.crp.chatroomproject.models.User;
import com.crp.chatroomproject.models.UserLogin;
import com.crp.chatroomproject.services.PageDataService;
import com.crp.chatroomproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {


    PageDataService pageDataService;
    UserService userService;
@Autowired
    public UserController(PageDataService pageDataService, UserService userService) {
        this.pageDataService = pageDataService;
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model){
        model.addAttribute("appTitle", pageDataService.getAppTitle());
        model.addAttribute("pageInfo", pageDataService.getPage("register"));
        model.addAttribute("availablePages", pageDataService.getPages());
        return "register";
    }
    @PostMapping("/register")
    public String handleUserRegister(User user){
    try {
        userService.createUser(user);
        return "redirect:login?status=signup_success";
    }catch (Exception e){
        return "redirect:register?status=signup_failed&message=" + e.getMessage();
    }
    }

    @GetMapping("/login")
    public String showLoginPage(
            @RequestParam(name = "status", required = false) String status,
            @RequestParam(name = "message", required = false) String message,
            Model model){
        model.addAttribute("appTitle", pageDataService.getAppTitle());
        model.addAttribute("pageInfo", pageDataService.getPage("login"));
        model.addAttribute("availablePages", pageDataService.getPages());
        model.addAttribute("status", status);
        model.addAttribute("message", message);
        return "login";
    }
    @PostMapping("/login")
    public String handleUserLogin(UserLogin userLogin){
    try {
       User user = userService.verifyUser(userLogin);
        return "redirect:chatRoom/" + user.getId();
    }catch (Exception e){
        return "redirect:login?status=login_failed&message=" + e.getMessage();
    }

    }


}
