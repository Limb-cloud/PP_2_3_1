package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  private static final String REDIRECT_MAIN_PAGE = "redirect:/";

  @GetMapping(value = "/")
  public String printWelcome() {
    return "index";
  }

  @GetMapping(value = "/adduser_form")
  public String printAddUser() {
    return "add_user";
  }

  @GetMapping(value = "/update_user_form")
  public String printUpdateUser() {
    return "update_user";
  }

  @PostMapping(value = "/add_user")
  public String addUser() {
    return REDIRECT_MAIN_PAGE;
  }

  @PostMapping(value = "/update_user")
  public String updateUser() {
    return REDIRECT_MAIN_PAGE;
  }

  @GetMapping(value = "/remove_user")
  public String removeUser() {
    return REDIRECT_MAIN_PAGE;
  }
}
