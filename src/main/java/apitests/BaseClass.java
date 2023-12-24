package apitests;

import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class BaseClass {

        protected static final String MAIN_URI = "https://qa-scooter.praktikum-services.ru";

        protected RequestSpecification getRequestSpecification() {
            return given()
                    .baseUri(MAIN_URI)
                    .header("Content-Type", "application/json");
        }
    }
