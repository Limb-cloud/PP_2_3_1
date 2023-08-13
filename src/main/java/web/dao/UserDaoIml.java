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

  @Override
  public List<User> list() {
    return em.createQuery("from User", User.class).getResultList();
  }

  @Override
  @Transactional
  public void add(User user) {
    em.persist(user);
  }

  @Override
  @Transactional
  public void update(User user) {
    em.merge(user);
  }

  @Override
  @Transactional
  public void remove(Long id) {
    em.remove(find(id));
  }

  @Override
  public User find(Long id) {
    return em.find(User.class, id);
  }
}
