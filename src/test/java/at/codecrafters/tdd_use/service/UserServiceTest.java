package at.codecrafters.tdd_use.service;

import at.codecrafters.tdd_use.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserServiceTest {

    @DisplayName("create User")
    @Test
    void testCreateUser_whenUserDetailProvided_returnsUserObject(){
        //arrange
        UserService userService = new UserServiceImpl();

        String firstName = "firstName";
        String lastName = "lastName";
        String email = "email";
        String password = "password";
        String repeatPassword = "password";

        //act
        User user = userService.createUser(firstName, lastName, email, password, repeatPassword);

        //assert
        assertNotNull(user, "The user should not be null");
    }


}
