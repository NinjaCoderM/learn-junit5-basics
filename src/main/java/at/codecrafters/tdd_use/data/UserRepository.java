package at.codecrafters.tdd_use.data;

import at.codecrafters.tdd_use.model.User;

public interface UserRepository {
    boolean save(User user);
}
