package web.dao;

import java.util.List;
import web.models.User;

public interface UserDao {
  List<User> listUsers();
  void addUser(User user);
  void updateUserById(Long id);
  void removeUserById(Long id);
}
