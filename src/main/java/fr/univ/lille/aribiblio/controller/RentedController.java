package fr.univ.lille.aribiblio.controller;

import fr.univ.lille.aribiblio.dto.RentDto;
import fr.univ.lille.aribiblio.model.Rented;
import fr.univ.lille.aribiblio.service.BookService;
import fr.univ.lille.aribiblio.service.RentedService;
import fr.univ.lille.aribiblio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rented")
public class RentedController {

    private RentedService rentedService;

    private BookService bookService;

    private UserService userService;

    @Autowired
    public RentedController(RentedService rentedService, BookService bookService, UserService userService) {
        this.rentedService = rentedService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView getRentedPage(){
        List<RentDto> rentDtoList = new ArrayList<>();
        List<Rented> rentedList = this.rentedService.getAll();

        for (Rented rented: rentedList) {
            rentDtoList.add(RentDto.builder().bookId(rented.getBookId())
                    .bookName(bookService.getById(rented.getBookId()).getTitle())
                    .userName(userService.getUserById(rented.getUserId()).getName()).build());
        }

        /*rentedList.stream().map(rented ->
                );*/

        ModelAndView modelAndView = new ModelAndView("rented");
        modelAndView.addObject("renteds", rentDtoList);
        return modelAndView;
    }

    @PostMapping
    public String rentedBook(Integer bookId) {
        rentedService.rentedBook(bookId);
        return "redirect:/rented";
    }

}
