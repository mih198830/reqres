package tests;

import io.restassured.RestAssured;
import models.lombok.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static specs.NumberOfPageTwoSpec.numberOfPagesRequestSpec;
import static specs.NumberOfPageTwoSpec.numberOfPagesResponseSpec;
import static specs.ResourceNotFoundCheckSpec.notFoundRequestSpec;
import static specs.ResourceNotFoundCheckSpec.notFoundResponseSpec;
import static specs.SuccessfulLoginSpec.loginRequestSpec;
import static specs.SuccessfulLoginSpec.loginResponseSpec;
import static specs.СheckPostCreateRequestNameCorrect.postCreateRequestSpec;
import static specs.СheckPostCreateRequestNameCorrect.postCreateResponseSpec;

public class ReqresInTests {

    @BeforeAll
    static void setup() {
        baseURI = "https://reqres.in";
    }

    @Test
    void checkIfNumberOfPageEqualTwo(){
        given()
                .spec(numberOfPagesRequestSpec)
                .when()
                .get()
                .then()
                .spec(numberOfPagesResponseSpec)
                .body("total_pages", is(2));
    }

    @Test
    void checkPostCreateRequestNameCorrect(){
        RequestCreateUserModel body = new RequestCreateUserModel();
        body.setName("morpheus");
        body.setJob("leader");

        ResponseCreateUserModel response =
                (ResponseCreateUserModel)
                        given()
                                .spec(postCreateRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                                .spec(postCreateResponseSpec)
                                .extract().as(ResponseCreateUserModel.class);
        assertThat(response.getName()).isEqualTo("morpheus");
        assertThat(response.getJob()).isEqualTo("leader");
    }

    @Test
    void resourceNotFoundCheck(){
        given()
                .spec(notFoundRequestSpec)
                .when()
                .get()
                .then()
                .spec(notFoundResponseSpec)
                .log().body()
                .body(is("{}"));
    }

    @Test
    void successfulRegistration(){
        RequestSuccessfullRegistrationModel body = new RequestSuccessfullRegistrationModel();
        body.setEmail("eve.holt@reqres.in");
        body.setPassword("pistol");

        ResponseSuccessfullRegistrationModel response =
        given()
                .spec(loginRequestSpec)
                .contentType(JSON)
                .body(body)
                .when()
                .post()
                .then()
                .spec(loginResponseSpec)
                .extract().as(ResponseSuccessfullRegistrationModel.class);
        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }

    @Test
    void apiRegisterTestTokenExist() {
        RequestSuccessfulLoginModel body = new RequestSuccessfulLoginModel();
        body.setEmail("eve.holt@reqres.in");
        body.setPassword("cityslicka");

        ResponseSuccessfulLoginModel response =
            given()
                    .spec(loginRequestSpec)
                    .body(body)
                    .when()
                    .post()
                    .then()
                    .spec(loginResponseSpec)
                    .extract().as(ResponseSuccessfulLoginModel.class);
                    assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
        }
}
