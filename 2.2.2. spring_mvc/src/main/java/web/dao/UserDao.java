package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    User getUserId(Integer id);

    List<User> listUser();

    void saveUser(User user);

    void deleteById(Integer  id);

    void updateUser(User user);
}

