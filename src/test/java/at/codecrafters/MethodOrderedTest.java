package at.codecrafters;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderedTest {
    @Test
    @Order(4)
    void testA(){
        System.out.println("Running testA");
    }
    @Test
    @Order(2)
    void testB(){
        System.out.println("Running testB");
    }
    @Test
    @Order(3)
    void testC(){
        System.out.println("Running testC");
    }
    @Test
    @Order(1)
    void testD(){
        System.out.println("Running testD");
    }
}
