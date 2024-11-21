package com.WorkOut.Review;

import com.WorkOut.Review.review.dto.ReviewRequest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

import java.time.LocalDateTime;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class ReviewServiceApplicationTests {
    @ServiceConnection
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.7");
    @LocalServerPort
    private Integer port;
    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }
    static {
        mongoDBContainer.start();
    }

    @Test
    void shouldCreateReview() throws Exception {
        ReviewRequest productRequest = getReviewRequest();
        RestAssured.given()
                .contentType("application/json")
                .body(productRequest)
                .when()
                .post("/api/review")
                .then()
                .log().all()
                .statusCode(201);
    }

    private ReviewRequest getReviewRequest(){
        return new ReviewRequest("nice training", LocalDateTime.of(2024, 11, 22, 10, 30), 5, null);
    }
}
