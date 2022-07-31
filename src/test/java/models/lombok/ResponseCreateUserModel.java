package models.lombok;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties("createdAt")
public class ResponseCreateUserModel {
    private String name;
    private String job;
    private String id;
}
