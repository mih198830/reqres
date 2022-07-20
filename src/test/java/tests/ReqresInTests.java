package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;


public class ReqresInTests {
    @Test
    void checkIfNumberOfPageEqualTwo(){
        given()
                .log().all()
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .log().body()
                .log().status()
                .body("total_pages", is(2))
                .statusCode(200);
    }

    @Test
    void checkPostCreateRequestNameCorrect(){
        String body = "{ \"name\": \"morpheus\", \"job\": \"leader\"," +
                " \"id\": \"400\", \"createdAt\": " +
                "\"2022-07-20T18:18:59.857Z\" }";

        given()
                .contentType(JSON)
                .body(body)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().body()
                .log().status()
                .body("name", is("morpheus"))
                .statusCode(201);
    }

    @Test
    void resourceNotFoundCheck(){
        given()
                .contentType(JSON)
                .when()
                .get("https://reqres.in/api/unknown/23")
                .then()
                .log().body()
                .body(is("{}"))
                .statusCode(404);
    }
}
