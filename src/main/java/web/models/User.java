package web.models;

import javax.persistence.*;
import java.util.Objects;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "first_name")
  @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "Поле Имя может содержать только буквы")
  private String firstName;

  @Column(name = "last_name")
  @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "Поле Фамилия может содержать только буквы")
  private String lastName;

  @Column(name = "email")
  @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "Поле Email может содержать только буквы")
  private String email;

  @Column(name = "age")
  @Pattern(regexp="[1-9][0-9]*", message = "Поле Возраст должно быть больше ноля и может содержать только цифры")
  private Byte age;

  public User() {
  }

  public User(String firstName, String lastName, String email, Byte age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.age = age;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Byte getAge() {
    return age;
  }

  public void setAge(Byte age) {
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id) && Objects.equals(firstName,
        user.firstName) && Objects.equals(lastName, user.lastName)
        && Objects.equals(email, user.email) && Objects.equals(age, user.age);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, email, age);
  }
}
