package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    @Transactional
    public User getUserId(Integer id) {
        return userDao.getUserId(id);
    }

    @Override
    @Transactional
    public List<User> listUser() {
        return userDao.listUser();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);

    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        userDao.deleteById(id);

    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);

    }
}
