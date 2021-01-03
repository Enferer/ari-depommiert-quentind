package fr.univ.lille.aribiblio.controller;

import fr.univ.lille.aribiblio.model.User;
import fr.univ.lille.aribiblio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/auth")
public class AuthController {

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public String signup(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userService.createUser(user);
        return "redirect:/";
    }

}
