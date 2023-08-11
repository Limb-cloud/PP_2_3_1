package web.service;

import java.util.List;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.dao.UserDaoIml;
import web.models.User;

@Service
public class UserServiceImpl implements UserService{

  private final UserDao dao = new UserDaoIml();

  @Override
  public List<User> listUsers() {
    return dao.listUsers();
  }

  @Override
  public void addUser(String firstName, String lastName, String email, Byte age) {
    User user = new User(firstName, lastName, email, age);
    dao.addUser(user);
  }

  @Override
  public void updateUserById(Long id) {

  }

  @Override
  public void removeUserById(Long id) {

  }
}
