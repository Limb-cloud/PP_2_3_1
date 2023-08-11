package web.service;

import java.util.List;
import web.models.User;

public interface UserService {
  List<User> listUsers();
  void addUser(String firstName, String lastName, String email, Byte age);
  void updateUserById(Long id);
  void removeUserById(Long id);
}
