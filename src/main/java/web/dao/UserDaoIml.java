package web.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.models.User;

@Repository
public class UserDaoIml implements UserDao {

  @PersistenceContext
  private EntityManager em;

  public UserDaoIml() {}

  @Override
  public List<User> list() {
    return em.createQuery("from User", User.class).getResultList();
  }

  @Override
  public void add(User user) {
    em.persist(user);
  }

  @Override
  public void update(User user) {
    em.merge(user);
  }

  @Override
  public void remove(User user) {
    em.remove(user);
  }

  @Override
  public User find(Long id) {
    return em.find(User.class, id);
  }
}
