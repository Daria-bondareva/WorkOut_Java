package com.WorkOut.Catalog;

import com.WorkOut.Catalog.workOut.dto.WorkOutRequest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CatalogServiceApplicationTests {
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
    void shouldCreateProduct() throws Exception {
        WorkOutRequest productRequest = getWorkOutRequest();
        RestAssured.given()
                .contentType("application/json")
                .body(productRequest)
                .when()
                .post("/api/catalog")
                .then()
                .log().all()
                .statusCode(201);
    }

    private WorkOutRequest getWorkOutRequest(){
        return new WorkOutRequest("yoga for your body", 2, BigDecimal.valueOf(250));
    }
}
