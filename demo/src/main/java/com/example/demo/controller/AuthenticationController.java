package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Isso deve corresponder ao nome da sua página de login HTML
    }

    @GetMapping("/login-success")
    public String loginSuccess() {
        return "redirect:/dashboard"; // Redireciona para a página de dashboard após o login bem-sucedido
    }

    @GetMapping("/logout-success")
    public String logoutSuccess() {
        return "redirect:/login"; // Redireciona para a página de login após o logout
    }
}
