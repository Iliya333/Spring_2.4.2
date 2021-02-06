package web.servise;

import web.model.User;

import java.util.List;

public interface UserService {
    User getUserId(Integer  id);

    List<User> listUser();

    void saveUser(User user);

    void deleteById(Integer  id);

    void updateUser(User user);
}

