package web.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

@Repository
public class UserDaoIml implements UserDao {

  @PersistenceContext
  private EntityManager em;

  public UserDaoIml() {}

  @Override
  public List<User> listUsers() {
    return em.createQuery("from User", User.class).getResultList();
  }

  @Transactional
  @Override
  public void addUser(User user) {

  }

  @Transactional
  @Override
  public void updateUserById(Long id) {

  }

  @Transactional
  @Override
  public void removeUserById(Long id) {

  }
}
