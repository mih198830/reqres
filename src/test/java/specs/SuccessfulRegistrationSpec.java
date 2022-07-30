package specs;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.notNullValue;

public class SuccessfulRegistrationSpec {
    public static RequestSpecification postRegistrationSuccessRequestSpec = with()
            .basePath("/api/register")
            .log().uri()
            .log().body()
            .contentType(JSON);

    public static ResponseSpecification postRegistrationSuccessResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody("id", notNullValue())
            .expectBody("token", notNullValue())
            .build();
}
