package automation.stepdef.api;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApiHooks {
    @Before("@api")
    public void beforeTest() {
        System.out.println("🔵 Setting up API Test Environment");
    }

    @After("@api")
    public void afterTest() {
        System.out.println("🔵 Cleaning up after API Test");
    }
}
