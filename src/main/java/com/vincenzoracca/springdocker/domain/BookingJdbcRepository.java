package com.vincenzoracca.springdocker.domain;

import org.springframework.data.repository.CrudRepository;

public interface BookingJdbcRepository extends CrudRepository<Book, String> {
}
