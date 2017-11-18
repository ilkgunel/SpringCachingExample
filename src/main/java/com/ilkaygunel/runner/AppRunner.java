package com.ilkaygunel.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ilkaygunel.interfaces.BookRepository;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final BookRepository bookRepository;

    public AppRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(".... Fetching books According To Isbn");
        logger.info("isbn-1 -->" + bookRepository.getByIsbn("isbn-1"));
        logger.info("isbn-2 -->" + bookRepository.getByIsbn("isbn-2"));
        logger.info("isbn-3 -->" + bookRepository.getByIsbn("isbn-3"));
        logger.info("isbn-1 -->" + bookRepository.getByIsbn("isbn-1"));
        logger.info("isbn-2 -->" + bookRepository.getByIsbn("isbn-2"));
        logger.info("isbn-3 -->" + bookRepository.getByIsbn("isbn-3"));
        
        logger.info(".... Fetching books According To Title");
        logger.info("1984 -->" + bookRepository.getByTitle("1984"));
        logger.info("Hayvan Çiftliği -->" + bookRepository.getByIsbn("Hayvan Çiftliği"));
        logger.info("Kuyucaklı Yusuf -->" + bookRepository.getByIsbn("Kuyucaklı Yusuf"));
        logger.info("1984 -->" + bookRepository.getByIsbn("1984"));
        logger.info("Hayvan Çiftliği -->" + bookRepository.getByIsbn("Hayvan Çiftliği"));
        logger.info("Kuyucaklı Yusuf -->" + bookRepository.getByIsbn("Kuyucaklı Yusuf"));
    }

}
