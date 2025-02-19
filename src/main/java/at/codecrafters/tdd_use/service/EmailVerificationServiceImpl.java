package at.codecrafters.tdd_use.service;

import at.codecrafters.tdd_use.model.User;

public class EmailVerificationServiceImpl implements EmailVerificationService {
    @Override
    public void scheduleEmailConfirmation(User user) {
        //create entry in queue for user
        System.out.println("scheduleEmailConfirmation is called");
    }
}
