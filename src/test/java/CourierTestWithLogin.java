import apitests.CourierClass;

import org.junit.Before;
import org.junit.Test;
import apitests.RandomDataGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CourierTestWithLogin extends BaseTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
        courierClass = new CourierClass(courier);
        RandomDataGenerator = new RandomDataGenerator();
        courierClass.createCourier();
    }

    @Test
    @DisplayName("Авторизация прошла успешно")
    @Description("Успешная авторизация")
    public void successLoginCourier() {
        Response response = courierClass.loginCourier();
        response.then().assertThat().statusCode(200).and().body("id", notNullValue());
    }

    @Test
    @DisplayName("Попытка войти в систему без логина")
    @Description("Нужно удостовериться в том, что без логина войти в систему нельзя")
    public void noLoginCourier() {
        courier.setLogin(null);

        Response response = courierClass.loginCourier();
        response.then().assertThat().statusCode(400).and().body("message", equalTo("Недостаточно данных для входа"));
    }

    @Test
    @DisplayName("Попытка войти в систему без пароля")
    @Description("Нужно удостовериться в том, что без пароля войти в систему нельзя")
    public void noPasswordLoginCourier() {
        courier.setPassword(null);

        Response response = courierClass.loginCourier();
        response.then().assertThat().statusCode(400).and().body("message", equalTo("Недостаточно данных для входа"));
    }

    @Test
    @DisplayName("Попытка войти в систему с неправильным паролем")
    @Description("Нужно удостовериться в том, что с неправильным паролем войти в систему нельзя")
    public void wrongPasswordLoginCourier() {
        courier.setPassword(RandomDataGenerator.getRandomString(5));

        Response response = courierClass.loginCourier();
        response.then().assertThat().statusCode(404).and().body("message", equalTo("Учетная запись не найдена"));
    }

    @Test
    @DisplayName("Попытка войти в систему с неправильным логином")
    @Description("Нужно удостовериться в том, что с неправильным логином войти в систему нельзя")
    public void wrongLoginCourier() {
        courier.setLogin(RandomDataGenerator.getRandomString(5));
        Response response = courierClass.loginCourier();

        response.then().assertThat().statusCode(404).and().body("message", equalTo("Учетная запись не найдена"));
    }
}