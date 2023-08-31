package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class UsersPojo{
	@JsonProperty("last_name")
	private String lastName;
	private int id;
	private String avatar;
	@JsonProperty("first_name")
	private String firstName;
	private String email;
}
