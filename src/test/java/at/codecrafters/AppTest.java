package at.codecrafters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    //test<System Under Test>_<Condition or State Change>_<Result>
    @Test
    void testApp_initApp_appNotNull(){
        App app = new App();
        assertNotNull(app, "Expected: App is not Null");
    }

    //test<System Under Test>_<Condition or State Change>_<Result>
    @Test
    void testAssertEquals_AcutalResultEqualsExpectedResult_Success(){
        int expectedResult = 4;
        int actualResult = expectedResult;
        assertEquals(expectedResult, actualResult, ()-> "Expeceted Result: " + expectedResult + ", but actual: " + actualResult + " Lazy Assert Message, Lambda only executed when test fails " );
    }
}