package fr.univ.lille.aribiblio.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public ModelAndView getHomePage(){
        if("anonymousUser".equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
            return new ModelAndView("signup");
        }
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("name",SecurityContextHolder.getContext().getAuthentication().getName());
        return modelAndView;
    }

}
