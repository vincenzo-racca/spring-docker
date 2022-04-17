package com.vincenzoracca.springdocker.domain;

import org.springframework.data.annotation.Id;

public record Book (

        @Id
        Long id,

        String title,

        String author,

        Double price

) {
    public static Book build(String title, String author, Double price) {
        return new Book(null, title, author, price);
    }
}
