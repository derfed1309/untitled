package utils.services;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.http.Cookies;
import pojos.UserRequest;
import pojos.CreateUserResponse;
import pojos.UsersPojo;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserService extends RestSrevice {
    @Override
    protected String getBasePath() {
        return "/users";
    }

    public UserService(Cookies cookies) {
        super(cookies);
    }

    @Step("Создание пользователя {rq.name}")
    public CreateUserResponse createUser(UserRequest rq){
        return given().spec(REQ_SPEC).body(rq).post().as(CreateUserResponse.class);
    }
    @Step("Получение списка пользователей")
    @Attachment
    public List<UsersPojo> getUsers() {
        return given().spec(REQ_SPEC)
                .get("?page=2")
                .jsonPath().getList("data", UsersPojo.class);
    }
}
