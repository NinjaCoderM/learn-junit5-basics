package at.codecrafters.tdd_use.service;

import at.codecrafters.tdd_use.model.User;

public interface UserService {
    User createUser(Long id, String firstName, String lastName, String email, String password, String repeatPassword);
}
