package fr.univ.lille.aribiblio.controller;

import fr.univ.lille.aribiblio.model.Book;
import fr.univ.lille.aribiblio.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/books")
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ModelAndView getBookPage(){
        ModelAndView modelAndView = new ModelAndView("bookPage");
        modelAndView.addObject("books", this.bookService.getAllBook());
        return modelAndView;
    }

    @PostMapping
    public String createBook(Book book){
        this.bookService.createBook(book);
        return "redirect:/books";
    }

    @PostMapping("/delete")
    public String deleteAuthor(Book book){
        this.bookService.deleteBook(book);
        return "redirect:/books";
    }

}
