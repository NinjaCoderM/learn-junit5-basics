package at.codecrafters;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderedTest {

    StringBuilder completed = new StringBuilder();

    @AfterEach
    void afterEach() {
        System.out.println("Completed: " + completed);
    }

    @Test
    @Order(4)
    void testA(){
        System.out.println("Running testA");
        completed.append("A");
    }
    @Test
    @Order(2)
    void testB(){
        System.out.println("Running testB");
        completed.append("B");
    }
    @Test
    @Order(3)
    void testC(){
        System.out.println("Running testC");
        completed.append("C");
    }
    @Test
    @Order(1)
    void testD(){
        System.out.println("Running testD");
        completed.append("D");
    }
}
