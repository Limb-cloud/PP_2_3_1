package web.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

@Repository
public class UserDaoIml implements UserDao {

  public UserDaoIml() {}

  @SuppressWarnings("unchecked")
  @Override
  public List<User> listUsers() {
    return null;
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
