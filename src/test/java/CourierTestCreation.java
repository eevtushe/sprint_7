import apitests.CourierClass;

import io.restassured.response.Response;

import org.junit.Before;
import org.junit.Test;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import static org.hamcrest.Matchers.equalTo;

public class CourierTestCreation extends BaseTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
        courierClass = new CourierClass(courier);
    }

    @Test
    @DisplayName("Успешное создание курьера")
    @Description("Происходит успешное создание нового курьера")
    public void successCreateCourier() {
        Response response = courierClass.createCourier();
        response.then().assertThat().statusCode(201)
                .and()
                .body("ok", equalTo(true));
    }

    @Test
    @DisplayName("Пытаемся создать курьера с существующим логином")
    @Description("Нужно удостовериться в том, что нельзя создать курьера с существующим логином")
    public void createCourierWhichAlreadyExists() {
        courierClass.createCourier();
        Response response = courierClass.createCourier();
        response.then().assertThat().statusCode(409)
                .and()
                .body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    }

    @Test
    @DisplayName("Пытаемся создать курьера не указав имя")
    @Description("Нужно удостовериться в том, что нельзя создать курьера без имени")
    public void noNameCreateCourier() {
        courier.setFirstName(null);
        Response response = courierClass.createCourier();

        response.then().assertThat().statusCode(201)
                .and()
                .body("ok", equalTo(true));
    }

    @Test
    @DisplayName("Пытаемся создать курьера не указав логин")
    @Description("Нужно удостовериться в том, что нельзя создать курьера без логина")
    public void noLoginCreateCourier() {
        courier.setLogin(null);
        Response response = courierClass.createCourier();

        response.then().assertThat().statusCode(400)
                .and()
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    @Test
    @DisplayName("Пытаемся создать курьера не указав пароль")
    @Description("Нужно удостовериться в том, что нельзя создать курьера без пароля")
    public void noPasswordCreateCourier() {
        courier.setPassword(null);
        Response response = courierClass.createCourier();

        response.then().assertThat().statusCode(400)
                .and()
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

}