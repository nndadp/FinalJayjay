package automation.utility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class ApiAuth {

    protected static final String APP_ID = "63a804408eb0cb069b57e43a";
    public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .addHeader("app-id", APP_ID)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
    }
}
