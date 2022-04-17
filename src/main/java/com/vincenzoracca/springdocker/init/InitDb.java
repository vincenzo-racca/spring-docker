package com.vincenzoracca.springdocker.init;

import com.vincenzoracca.springdocker.domain.Book;
import com.vincenzoracca.springdocker.domain.BookingJdbcRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitDb {

    private final BookingJdbcRepository bookingJdbcRepository;

    public InitDb( BookingJdbcRepository bookingJdbcRepository) {
        this.bookingJdbcRepository = bookingJdbcRepository;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        var book1 = Book.build("Clean Code", "Robert C. Martin", 35.0);
        var book2 = Book.build("Clean Architecture", "Robert C. Martin", 30.0);
        bookingJdbcRepository.saveAll(List.of(book1, book2));
    }


}
