package at.codecrafters.tdd_use.service;

import at.codecrafters.tdd_use.data.UserRepository;
import at.codecrafters.tdd_use.model.User;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(Long id, String firstName, String lastName, String email, String password, String repeatPassword) {
        if(firstName==null || firstName.equals("")){
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        User user = new User(id, firstName, lastName, email, password, repeatPassword);

        boolean isUserCreated;
        try{
            isUserCreated = userRepository.save(user);
        } catch(Exception e){
            throw new UserServiceException(e.getMessage());
        }

        if(!isUserCreated) throw new UserServiceException("Could not create user");
        return user;
    }
}
