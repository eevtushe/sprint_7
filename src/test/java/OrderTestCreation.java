import apitests.OrderClass;
import apitests.Order;

import java.util.Arrays;
import java.util.Collection;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.Matchers.notNullValue;

@RunWith(Parameterized.class)
public class OrderTestCreation extends BaseTest {
    private final Order order;
    private final OrderClass orderClass;

    public OrderTestCreation(Order order) {
        this.order = order;
        this.orderClass = new OrderClass();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{

                {new Order("Иван", "Петров", "Ленина, 21", 2, "+7 999 333 00 00", 2, "2023-09-01", "Жду заказ", new String[]{"GREY"})},
                {new Order("Сергей", "Матвеев", "Сталина, 34.", 3, "+7 999 444 00 00", 10, "2023-10-01", "Жду заказ", new String[]{"BLACK", "GREY"})},
                {new Order("Андрей", "Фролов", "Горохова, 31", 5, "+7 999 555 00 00", 3, "2024-12-01", "Жду заказ", null)}
        });
    }

    @Test
    @DisplayName("Создаем заказ, где можно выбрать разные цвета")
    @Description("Нужно удостовериться в том, что можно создать заказ с разными цветами")
    public void createOrder() {
        Response response = createOrderRequest();

        response.then().assertThat().statusCode(201)
                .and().body("track", notNullValue());
    }

    private Response createOrderRequest() {
        return orderClass.createOrder(order);
    }
}