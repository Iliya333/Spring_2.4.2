package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.*;
import java.util.List;;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserId(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUser() {
        return   entityManager.createQuery("from User").getResultList();

    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteById(Integer id) {
      entityManager.createQuery("delete from User WHERE id=:id")
              .setParameter("id",id)
              .executeUpdate();

    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}