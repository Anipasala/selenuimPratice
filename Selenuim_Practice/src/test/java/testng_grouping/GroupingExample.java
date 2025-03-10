package testng_grouping;

import org.testng.annotations.Test;

public class GroupingExample {
	
	@Test(groups = {"smoke", "login"})
    public void testLogin() {
        System.out.println("Running login test");
    }

    @Test(groups = {"smoke"})
    public void testHomePage() {
        System.out.println("Running home page test");
    }

    
    @Test(groups = {"regression"})
    public void testSearch() {
        System.out.println("Running search functionality test");
    }

    @Test(groups = {"regression", "smoke"})
    public void testAddToCart() {
        System.out.println("Running add-to-cart test");
    }

}
