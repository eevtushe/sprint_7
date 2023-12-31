import apitests.CourierClass;
import apitests.Courier;
import apitests.RandomDataGenerator;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.After;

import static org.hamcrest.CoreMatchers.equalTo;

public class BaseTest {
    protected Courier courier;
    protected CourierClass courierClass;
    protected RandomDataGenerator RandomDataGenerator;

    @Step("Подготавливаем тестовые данные")
    public void setUp() {
        RandomDataGenerator RandomDataGenerator = new RandomDataGenerator();
        initializeTestData(RandomDataGenerator);
    }

    private void initializeTestData(RandomDataGenerator RandomDataGenerator) {
        courier = RandomDataGenerator.generateCourier();
    }

    @After
    public void deleteCourier() {
        if (courier != null && courier.getId() != null) {
            Response response = courierClass.deleteCourier();
            response.then()
                    .log().all()
                    .statusCode(200)
                    .body("ok", equalTo(true));
        }
    }
}
