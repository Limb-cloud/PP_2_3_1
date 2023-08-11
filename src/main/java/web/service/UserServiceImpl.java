package web.service;

import java.util.List;
import org.springframework.stereotype.Service;
import web.models.User;

@Service
public class UserServiceImpl implements UserService{

  @Override
  public List<User> listUsers() {
    return null;
  }

  @Override
  public void addUser(String firstName, String lastName, String email, Byte age) {

  }

  @Override
  public void updateUserById(Long id) {

  }

  @Override
  public void removeUserById(Long id) {

  }
}
