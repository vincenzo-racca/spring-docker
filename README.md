# Example of Dockerized Spring Boot Application

## Run the application without Docker
In the local env (without Docker), the spring-docker application uses H2 in memory database,
so you can run it in this way: `mvnw spring-boot:run`

## Run the application with Docker

### Build the spring-docker image
You can build the image of spring-docker application in two ways:
 - using `mvnw spring-boot:build-image` command (default way)
 - using the Dockerfile, with `docker build -t vincenzoracca/spring-docker:0.0.1-SNAPSHOT .` command

If you choose the second way, you need to comment the 26th row in the docker-compose file and uncomment the 28th row.

### Run the docker-compose file

Then, you need to run this command: `docker-compose up`. \
You can try the app calling this endpoint with a REST client, cURL for example:
`curl http://localhost:8081/spring-docker/books` 

The response should be this:
```json
{
    "_embedded": {
        "books": [
            {
                "_links": {
                    "book": {
                        "href": "http://localhost:8081/spring-docker/books/1"
                    },
                    "self": {
                        "href": "http://localhost:8081/spring-docker/books/1"
                    }
                },
                "author": "Robert C. Martin",
                "price": 35.0,
                "title": "Clean Code"
            },
            {
                "_links": {
                    "book": {
                        "href": "http://localhost:8081/spring-docker/books/2"
                    },
                    "self": {
                        "href": "http://localhost:8081/spring-docker/books/2"
                    }
                },
                "author": "Robert C. Martin",
                "price": 30.0,
                "title": "Clean Architecture"
            }
        ]
    },
    "_links": {
        "profile": {
            "href": "http://localhost:8081/spring-docker/profile/books"
        },
        "self": {
            "href": "http://localhost:8081/spring-docker/books"
        }
    }
}
```

Visit my blog for other articles about Spring and Docker: https://www.vincenzoracca.com/
