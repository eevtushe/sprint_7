package apitests.package1;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import apitests.package2.Courier;

    public class CourierClass extends BaseClass {

        private final Courier courier;
        private static final String COURIER_ENDPOINT = "/api/v1/courier";

        public CourierClass(Courier courier) {
            this.courier = courier;
        }

        @Step("Создаем нового курьера")
        public Response createCourier() {
            return getRequestSpecification()
                    .and()
                    .body(courier)
                    .when()
                    .post(COURIER_ENDPOINT);
        }

        @Step("Авторизация")
        public Response loginCourier() {
            Response response = getRequestSpecification()
                    .and()
                    .body(courier)
                    .when()
                    .post(COURIER_ENDPOINT + "/login");
            return response;
        }

        @Step("Удаляем курьера")
        public Response deleteCourier() {
            return getRequestSpecification()
                    .pathParam("id", courier.getId())
                    .when()
                    .delete(COURIER_ENDPOINT + "/{id}");
        }
    }
