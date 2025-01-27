package at.codecrafters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void testApp(){
        App app = new App();
        assertNotNull(app, "App is null");
        int expectedResult = 4;
        int actualResult = expectedResult;
        assertEquals(expectedResult, actualResult, ()-> "Expeceted Result: " + expectedResult + ", but actual: " + actualResult + " Lazy Assert Message, Lambda only executed when test fails " );
    }
}