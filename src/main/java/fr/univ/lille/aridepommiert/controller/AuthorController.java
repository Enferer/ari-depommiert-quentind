package fr.univ.lille.aridepommiert.controller;

import fr.univ.lille.aridepommiert.model.Author;
import fr.univ.lille.aridepommiert.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ModelAndView getAuthorPage(){
        ModelAndView modelAndView = new ModelAndView("authorPage");
        modelAndView.addObject("authors",authorService.getAllAuthor());
        return modelAndView;
    }

    @PostMapping
    public String createAuthor(Author author){
        this.authorService.createAuthor(author);
        return "redirect:/authors";
    }

    @PostMapping("/delete")
    public String deleteAuthor(Author author){
        this.authorService.deleteAuthor(author);
        return "redirect:/authors";
    }



}
