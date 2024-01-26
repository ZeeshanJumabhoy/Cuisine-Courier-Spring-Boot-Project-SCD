package com.dbproject.controllers;


import com.dbproject.Models.Credentials;
import com.dbproject.dto.Creds;
import com.dbproject.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//controller class used for routing calls

@Controller
public class RegisterController {
    private final LoginService loginService;

    @Autowired
    public RegisterController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/register")
    public String register(Model model)
    {
//        Credentials credentials=loginService.getCredentialsByUsername("user1");
////        List<Credentials> credlist= loginService.getAllCredentials();
//        Creds creds=new Creds();
            model.addAttribute("register",new Creds());
        return  "login";

        //      return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body("{}");
    }


    @PostMapping("/register")
    public String registerUser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email, Model model) {

        Credentials registeredUser = loginService.registerUser(username,password,email);

        if (registeredUser != null) {
            // Registration successful
            model.addAttribute("message", "Registration successful. You can now log in.");
            return "login"; // You can redirect to the login page or show a success message
        } else {
            // Registration failed
            model.addAttribute("error1", "Registration failed. Please try again.");
            return "login"; // Return to the registration page with an error message
        }
    }

}







