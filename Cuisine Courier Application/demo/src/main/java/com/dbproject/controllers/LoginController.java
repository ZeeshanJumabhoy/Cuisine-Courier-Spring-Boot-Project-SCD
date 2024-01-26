package com.dbproject.controllers;


import com.dbproject.Models.Credentials;
import com.dbproject.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//controller class used for routing calls

@Controller
public class LoginController {
    private final LoginService loginService;
    public String name;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String login_func(Model model)
    {
//        Credentials credentials=loginService.getCredentialsByUsername("user1");
////        List<Credentials> credlist= loginService.getAllCredentials();
//        Creds creds=new Creds();
//            model.addAttribute("LoginRequest",new Creds());
        return  "login";

  //      return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body("{}");
    }

//    @PostMapping("/login")
//    public String loginSubmit(Credentials credentials, Model model) {
//        // Perform authentication or database validation here
//        // You can access the username and password using credential.getUsername() and credential.getPassword()
//
//        // For example, assuming a simple check
//        if ("admin".equals(credentials.getUsername()) && "password".equals(credentials.getPassword())) {
//            // Successful login, redirect to index page
//            return "redirect:/index";
//        } else {
//            // Failed login, add an error message to the model
//            model.addAttribute("error", "Invalid username or password");
//            return "login";
//        }
//    }



    @PostMapping("/login")
        public String login( @RequestParam String username,@RequestParam String password,Model model) {

        Credentials user = loginService.authenticate(username, password);

        if (user != null) {
            // Successful login
            model.addAttribute("user", user);
            model.addAttribute("name", "Welcome Back, "+ user.getUsername());
            name=user.getUsername();
            return "dashboard"; // Redirect to a dashboard page
        } else {
            // Failed login
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Redirect back to the login page with an error message
        }


    }
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("name", "Welcome Back, "+ name);
        return "dashboard"; // Assuming "dashboard" is the Thymeleaf template for the dashboard
    }

}







