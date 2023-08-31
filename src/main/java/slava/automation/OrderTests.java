package slava.automation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderTests {

    @BeforeAll
    public static void createOrder(){
        System.out.println("create order");
    }

    @BeforeEach
    public void createOrderEach(){
        System.out.println("create order each");
    }


    @Test
    public void testCreateOrder(){
        System.out.println("check that order was created");
    }

    @ParameterizedTest
    @ValueSource(strings = {"manager 1", "manager 2", "manager 3"})
    public void testListOrdersAsManager(String role){
        System.out.println("list orders as " + role);
        System.out.println("check that order is displayed");
    }

    @AfterAll
    public static void deleteOrder(){
        System.out.println("delete order");
    }

}
