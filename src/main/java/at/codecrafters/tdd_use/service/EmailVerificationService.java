package at.codecrafters.tdd_use.service;

import at.codecrafters.tdd_use.model.User;

public interface EmailVerificationService {
    void scheduleEmailConfirmation(User user);
}
