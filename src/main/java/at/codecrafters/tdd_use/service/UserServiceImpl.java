package at.codecrafters.tdd_use.service;

import at.codecrafters.tdd_use.model.User;

public class UserServiceImpl implements UserService {
    @Override
    public User createUser(String firstName, String lastName, String email, String password, String repeatPassword) {
        return new User();
    }
}
