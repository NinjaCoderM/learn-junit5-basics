package at.codecrafters;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math operations in Calculator class")
class AppTest {
    //test<System Under Test>_<Condition or State Change>_<Result>
    @DisplayName("Test App is not null")
    @Test
    void testApp_initApp_appNotNull(){
        App app = new App();
        assertNotNull(app, "Expected: App is not Null");
    }

    //test<System Under Test>_<Condition or State Change>_<Result>
    @DisplayName("Test assertEquals")
    @Test
    void testAssertEquals_AcutalResultEqualsExpectedResult_Success(){
        int expectedResult = 4;
        int actualResult = expectedResult;
        assertEquals(expectedResult, actualResult, ()-> "Expeceted Result: " + expectedResult + ", but actual: " + actualResult + " Lazy Assert Message, Lambda only executed when test fails " );
    }

    @DisplayName("ParameterizedTest MethodSource [expectedResult, actualResult]")
    @ParameterizedTest
    @MethodSource()
    void testParameterizedMethodSource_AcutalResultEqualsExpectedResult_Success(int expectedResult, int actualResult){
        assertEquals(expectedResult, actualResult, ()-> "Expeceted Result: " + expectedResult + ", but actual: " + actualResult + " Lazy Assert Message, Lambda only executed when test fails " );
    }

    private static Stream<Arguments> testParameterizedMethodSource_AcutalResultEqualsExpectedResult_Success(){
        return Stream.of(
                Arguments.of(10, 10),
                Arguments.of(100, 100)
        );
    }

}