package specs;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.notNullValue;

public class СheckPostCreateRequestNameCorrect {
    public static RequestSpecification postCreateRequestSpec = with()
            .basePath("/api/users")
            .log().uri()
            .log().body()
            .contentType(JSON);

    public static ResponseSpecification postCreateResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody("id", notNullValue())
            .build();
}
