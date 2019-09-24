package com.hotel.reservationsystem.controllers;

import com.hotel.reservationsystem.exceptions.NotFoundException;
import com.hotel.reservationsystem.models.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/hello/")
public class HelloController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String gutentag() {
        return "GUTENTAG DIE GANZE WELT";
    }

    @RequestMapping(value = "book", method = RequestMethod.GET)
    public Book printBook () {
        Book book = new Book(9001, "What is this power level?");
        return book;
    }

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public ArrayList<Book> printBooks () {
        Book book = new Book(9001, "What is this power level?");
        Book book1 = new Book(420, "Remembering the fallen: AREA 51 raid");
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        books.add(book1);
        return books;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addBook (@RequestBody Book newBook) {
        return newBook.getTitle();
    }

    @RequestMapping(value = "test/{number}", method = RequestMethod.GET)
    public String yay (@PathVariable int number) {
        return "iets" + number;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public String deleted(@PathVariable int id) {
        return "OK";
    }

    @RequestMapping(value = "guusgeluk/{getal}", method = RequestMethod.POST)
    public String guusGeluk (@PathVariable int getal) throws NotFoundException {
        if (getal % 3 == 0) {
            if (getal % 5 == 0) {
                return "Guus Geluk";
            }
            return "Guus";
        } else if (getal % 5 == 0) {
            return "Geluk";
        } else {
            throw new NotFoundException();
        }
    }
}
