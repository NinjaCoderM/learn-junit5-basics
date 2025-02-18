package at.codecrafters.tdd_use.service;

import at.codecrafters.tdd_use.model.User;

public class UserServiceImpl implements UserService {
    @Override
    public User createUser(Long id, String firstName, String lastName, String email, String password, String repeatPassword) {
        if(firstName==null || firstName.equals("")){
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        return new User(id, firstName, lastName, email, password, repeatPassword);
    }
}
