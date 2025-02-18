package at.codecrafters.tdd_use.service;

import at.codecrafters.tdd_use.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @DisplayName("createUser")
    @ParameterizedTest
    @CsvSource({
            "1, John, Doe, john@example.com, password123, password123",
            "2, Jane, Smith, jane@example.com, pass456, pass456"
    })
    void testCreateUser_whenUserDetailProvided_returnsUserObject(Long id, String firstName, String lastName, String email, String password, String repeatPassword){
        //arrange
        UserService userService = new UserServiceImpl();

        //act
        User user = userService.createUser(id, firstName, lastName, email, password, repeatPassword);

        //assert
        assertNotNull(user, "The user should not be null");
        assertEquals(firstName, user.getFirstName(), "createUser firstName should be the same");
        assertEquals(lastName, user.getLastName(), "createUser lastName should be the same");
        assertEquals(email, user.getEmail(), "createUser email should be the same");
        assertEquals(password, user.getPassword(), "createUser password should be the same");
        assertEquals(repeatPassword, user.getRepeatPassword(), "createUser repeatPassword should be the same");
        assertNotNull(user.getId(), "User ID is missing");
    }

    @DisplayName("createUser firstName empty throws IllegalArgumentException")
    @ParameterizedTest
    @CsvSource({
            "1, , Doe, john@example.com, password123, password123",
            "2, , Smith, jane@example.com, pass456, pass456"
    })
    void testCreateUser_whenFirstNameIsEmpty_throwsIllegalArgumentException(Long id, String firstName, String lastName, String email, String password, String repeatPassword) {
        //arrange
        UserService userService = new UserServiceImpl();

        // act & assert
        IllegalArgumentException excep = assertThrows(IllegalArgumentException.class, () -> userService.createUser(id, firstName, lastName, email, password, repeatPassword),
                "Empty firstname should have thrown an IllegalArgumentException");

        assertEquals("First name cannot be null or empty", excep.getMessage(), "Message should be 'First name cannot be null or empty'");
    }
}
