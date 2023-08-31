package utils;

import pojos.UserRequest;

public class UserGenerator {
    public static UserRequest getSimpleUser(){
        return UserRequest.builder()
                .name("Slava")
                .job("QA")
                .build();
    }
}
