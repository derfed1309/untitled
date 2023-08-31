import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojos.UserRequest;
import pojos.CreateUserResponse;
import pojos.UsersPojo;
import utils.RestWrapper;
import utils.UserGenerator;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тесты работы с API клиента")
@Feature("Api for users")
public class RestTest {
    private static RestWrapper api;
    @BeforeAll
    public static void prepareClient(){
        api = RestWrapper.loginAs("Slava", "pas123");
    }

    @Test
    @Story("Get user")
    @DisplayName("Получение пользователя")
    public void getUsers() {
        assertThat(api.user.getUsers()).extracting(UsersPojo::getFirstName).contains("Byron");
    }

    @Test
    @DisplayName("Создание пользователя")
    @Story("Create user")
    @Description("Проверяет отправку запроса на создание пользователя и что бла бла бла")
    public void createUser() {
        UserRequest rq = UserGenerator.getSimpleUser();
        CreateUserResponse rs = api.user.createUser(rq);

        assertThat(rs)
                .isNotNull()
                .extracting(CreateUserResponse::getName)
                .isEqualTo(rq.getName());
        assertThat(false).isTrue();
    }
}
