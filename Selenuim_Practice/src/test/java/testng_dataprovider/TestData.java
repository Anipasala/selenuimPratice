package testng_dataprovider;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name = "loginCredentials")
    public Object[][] provideLoginData() {
        return new Object[][] {
            { "user1@example.com", "password123" }, // First set of credentials
            { "user2@example.com", "password456" }, // Second set of credentials
            { "user3@example.com", "password789" }  // Third set of credentials
        };
    }

}
