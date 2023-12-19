import apitests.package1.OrderClass;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class GetAllOrdersTest extends BaseTest {

    private final OrderClass orderClass;

    public GetAllOrdersTest() {
        super();
        this.orderClass = new OrderClass();
    }

    @Test
    @DisplayName("Получить список всех заказов")
    @Description("Нужно удостовериться в том, что возвращается НЕПУСТОЙ список заказов")
    public void getAllOrders() {
        Response response = orderClass.getOrders();

        response.then().assertThat().statusCode(200)
                .and().body("orders", not(empty()))
                .and().body("pageInfo.total", notNullValue());
    }
}