package steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojos.CreateUserResponse;
import pojos.UsersPojo;

import static io.restassured.RestAssured.given;

public class UserSteps {

    private CreateUserResponse user;

    public UsersPojo getUser(){
        return given().get("/" + user.getId()).as(UsersPojo.class);
    }
    private static final RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setBaseUri("https://reqres.in")
                    .setBasePath("/api/users")
                    .setContentType(ContentType.JSON)
                    .build();

    public static UsersPojo getUser(int id){
        return given().get("/" + id).as(UsersPojo.class);
    }
}
