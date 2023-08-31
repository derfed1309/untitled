package utils.services;

import io.restassured.http.Cookies;
import pojos.UsersPojo;

import java.util.List;

import static io.restassured.RestAssured.given;

public class OrderService extends RestSrevice{
    @Override
    protected String getBasePath() {
        return "/orders";
    }

    public OrderService(Cookies cookies) {
        super(cookies);
    }

    public List<UsersPojo> getOrders() {
        return given().spec(REQ_SPEC)
                .get("/orders")
                .jsonPath().getList("data", UsersPojo.class);
    }
}
