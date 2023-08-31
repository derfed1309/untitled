package pojos;

import lombok.Data;

@Data
public class CreateUserResponse extends UserRequest {
    private String createdAt;
    private String id;
}
