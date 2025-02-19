package at.codecrafters.tdd_use.data;

import at.codecrafters.tdd_use.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    Map<Long, User> users = new HashMap<>();

    @Override
    public boolean save(User user) {
        if (!users.containsKey(user.getId())) {
            users.put(user.getId(), user);
            return true;
        }
        return false;
    }
}
