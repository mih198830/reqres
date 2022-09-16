package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.notNullValue;

public class CreateUserSpec {
    public static RequestSpecification loginRequestSpec = with()
            .basePath("/api/users")
            .filter(withCustomTemplates())
            .log().uri()
            .log().body()
            .contentType(JSON);

    public static ResponseSpecification loginResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody("job", notNullValue())
            .build();
}
