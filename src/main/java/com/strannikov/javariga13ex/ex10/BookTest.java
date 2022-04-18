package com.strannikov.javariga13ex.ex10;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class BookTest implements CommandLineRunner {

    private final BookRepository bookRepository;
    @Override
    public void run(String... args) throws Exception {
        bookRepository.saveAll(List.of(
                Book.builder().author("Me").isbn("a").pagesNum(12).title("Jit").build(),
                Book.builder().author("You").isbn("bv").pagesNum(101).title("Kit").build(),
                Book.builder().author("He").isbn("c").pagesNum(104).title("Bit").build(),
                Book.builder().author("She").isbn("d").pagesNum(310).title("WHit").build()));
        log.info(bookRepository.findAllByPagesNumBetween(101,200).toString());
        log.info(bookRepository.findAllByTitleStartingWith("Ki").toString());
        log.info(bookRepository.findTop3ByAuthorOrderByPagesNumDesc("She").toString());
        log.info(bookRepository.findByTitle("Jit").toString());
        log.info(bookRepository.findByIsbn("d").toString());
        log.info(bookRepository.findWherePagesNumIsGreatThanX(200).toString());


    }
}
