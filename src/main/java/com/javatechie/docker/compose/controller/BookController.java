package com.javatechie.docker.compose.controller;

import com.javatechie.docker.compose.dao.BookRepository;
import com.javatechie.docker.compose.model.Book;
import com.javatechie.docker.compose.util.DebugInfoUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {

    public final BookRepository bookRepository;

    @GetMapping("/getAllBook")
    List<Book> getAllBook(){
        return  bookRepository.findAll();
    }

    @PostMapping("/writeBook")
    void writeBook(@RequestBody Book book){
        try {
            bookRepository.save(book);
        }catch (Exception e){
            DebugInfoUtil.logExceptionDetails(e);
        }
    }

    @PostMapping("/writeAllBook")
    void writeAllBook(@RequestBody List<Book> books){
        try {
            bookRepository.saveAll(books);
        }catch (Exception e){
            DebugInfoUtil.logExceptionDetails(e);
        }
    }
}
