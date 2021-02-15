package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    User getUserId(Long  id);

    List<User> listUser();

    void saveUser(User user);

    void deleteById(Long  id);

    void updateUser(User user);
}

