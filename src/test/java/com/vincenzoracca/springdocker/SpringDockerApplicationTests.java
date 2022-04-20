package com.vincenzoracca.springdocker;

import com.vincenzoracca.springdocker.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class SpringDockerApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void initDbTest() {
		ResponseEntity<PagedModel<Book>> response = testRestTemplate.exchange("/books/", HttpMethod.GET,
				null,  new ParameterizedTypeReference<PagedModel<Book>>() {});

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getContent().size()).isEqualTo(2);
	}
}

