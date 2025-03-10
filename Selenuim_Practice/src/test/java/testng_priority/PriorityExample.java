package testng_priority;

import org.testng.annotations.Test;

public class PriorityExample {
	
	@Test(priority = 1)
    public void testOne() {
        System.out.println("Test 1 - Priority 1");
    }

    @Test(priority = 2)
    public void testTwo() {
        System.out.println("Test 2 - Priority 2");
    }

    @Test(priority = 3)
    public void testThree() {
        System.out.println("Test 3 - Priority 3");
    }
   // No priority executes first as it having default 0
    @Test
    public void testFour() {
        System.out.println("Test 4 - No priority");
    }

}
