package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class NumberOfPageTwoSpec {
    public static RequestSpecification numberOfPagesRequestSpec = with()
            .basePath("/api/login")
            .filter(withCustomTemplates())
            .log().uri()
            .log().body()
            .contentType(JSON);

    public static ResponseSpecification numberOfPagesResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .build();
}
