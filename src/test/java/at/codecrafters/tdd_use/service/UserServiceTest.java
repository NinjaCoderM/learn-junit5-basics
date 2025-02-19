package at.codecrafters.tdd_use.service;

import at.codecrafters.tdd_use.data.UserRepository;
import at.codecrafters.tdd_use.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @Mock
    EmailVerificationService emailVerificationService;

    @DisplayName("createUser")
    @ParameterizedTest
    @CsvSource({
            "1, John, Doe, john@example.com, password123, password123",
            "2, Jane, Smith, jane@example.com, pass456, pass456"
    })
    void testCreateUser_whenUserDetailProvided_returnsUserObject(Long id, String firstName, String lastName, String email, String password, String repeatPassword){
        //arrange
        //userService = new UserServiceImpl(userRepository);
        when(userRepository.save(Mockito.any(User.class))).thenReturn(true);
        doNothing().when(emailVerificationService).scheduleEmailConfirmation(Mockito.any(User.class));

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
        verify(userRepository/* default: , Mockito.times(1)*/).save(Mockito.any(User.class));
    }

    @DisplayName("createUser firstName empty throws IllegalArgumentException")
    @ParameterizedTest
    @CsvSource({
            "1, , Doe, john@example.com, password123, password123",
            "2, , Smith, jane@example.com, pass456, pass456"
    })
    void testCreateUser_whenFirstNameIsEmpty_throwsIllegalArgumentException(Long id, String firstName, String lastName, String email, String password, String repeatPassword) {
        //arrange
        // act & assert
        IllegalArgumentException excep = assertThrows(IllegalArgumentException.class, () -> userService.createUser(id, firstName, lastName, email, password, repeatPassword),
                "Empty firstname should have thrown an IllegalArgumentException");

        assertEquals("First name cannot be null or empty", excep.getMessage(), "Message should be 'First name cannot be null or empty'");
    }

    @DisplayName("createUser throws RuntimeException")
    @ParameterizedTest
    @CsvSource({
            "1, John, Doe, john@example.com, password123, password123",
            "2, Jane, Smith, jane@example.com, pass456, pass456"
    })
    void testCreateUser_whenRuntimeException_throwsUserServiceException(Long id, String firstName, String lastName, String email, String password, String repeatPassword) {
        //arrange
        when(userRepository.save(Mockito.any(User.class))).thenThrow(new RuntimeException("Database error"));
        // act & assert
        assertThrows(UserServiceException.class, () -> userService.createUser(id, firstName, lastName, email, password, repeatPassword),"should have thrown an UserServiceException");
    }

    @DisplayName("scheduleEmailConfirmation throws EmailNotifictiaonException")
    @ParameterizedTest
    @CsvSource({
            "1, John, Doe, john@example.com, password123, password123",
            "2, Jane, Smith, jane@example.com, pass456, pass456"
    })
    void testCreateUser_wheEmailNotifictiaonException_throwsUserServiceException(Long id, String firstName, String lastName, String email, String password, String repeatPassword) {
        //arrange
        when(userRepository.save(Mockito.any(User.class))).thenReturn(true);
        doThrow(EmailNotificationServiceException.class).when(emailVerificationService).scheduleEmailConfirmation(Mockito.any(User.class));
        //act & assert
        assertThrows(UserServiceException.class, () -> userService.createUser(id, firstName, lastName, email, password, repeatPassword),"should have thrown an UserServiceException");
        //Assert
        verify(emailVerificationService, times(1)).scheduleEmailConfirmation(Mockito.any(User.class));
    }






}
