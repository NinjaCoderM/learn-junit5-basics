package at.codecrafters;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoRepeatedTest {
    @DisplayName("Test assertEquals")
    //@RepeatedTest(5)
    @RepeatedTest(value=5, name="{displayName}. Repetition {currentRepetition} of {totalRepetitions}")
    void testAssertEquals_AcutalResultEqualsExpectedResult_Success(RepetitionInfo info, TestInfo testInfo) {
        System.out.println("Running " + testInfo.getTestMethod().get().getName());
        System.out.println("Repetition #" + info.getCurrentRepetition());
        int expectedResult = 4;
        int actualResult = expectedResult;
        assertEquals(expectedResult, actualResult, ()-> "Expeceted Result: " + expectedResult + ", but actual: " + actualResult + " Lazy Assert Message, Lambda only executed when test fails " );
    }
}
