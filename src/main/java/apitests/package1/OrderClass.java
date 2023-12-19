package apitests.package1;

import io.qameta.allure.Step;
import io.restassured.response.Response;

    public class OrderClass extends BaseClass {

        private static final String ORDER_ENDPOINT = "/api/v1/orders";

        @Step("Создать новый заказ")
        public Response createOrder(Object body) {
            return getRequestSpecification()
                    .and()
                    .body(body)
                    .when()
                    .post(ORDER_ENDPOINT);
        }

        @Step("Получить список всех заказов")
        public Response getOrders() {
            return getRequestSpecification()
                    .when()
                    .get(ORDER_ENDPOINT);
        }
    }
