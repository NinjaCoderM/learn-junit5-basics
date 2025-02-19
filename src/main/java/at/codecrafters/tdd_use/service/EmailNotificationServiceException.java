package at.codecrafters.tdd_use.service;

public class EmailNotificationServiceException extends RuntimeException {
    public EmailNotificationServiceException(String message) {
        super(message);
    }
}
