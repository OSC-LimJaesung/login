package com.osckorea.login.controller;

import com.osckorea.login.controller.request.LoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm(Model model) {

        model.addAttribute("member", new LoginRequest());
        return "login";
    }
}
