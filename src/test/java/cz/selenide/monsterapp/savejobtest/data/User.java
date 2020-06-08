package cz.selenide.monsterapp.savejobtest.data;

import java.time.LocalDate;
import lombok.Data;

@Data
public class User {

  private final String firstName;
  private final String lastName;
  private final int socialSecurityNumber;
  private final LocalDate dateOfBirth;
  private final String email;
  private final String phoneNumber;
  private final String password;

  public User(String firstName, String lastName, int socialSecurityNumber, LocalDate dateOfBirth, String email, String phoneNumber, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.socialSecurityNumber = socialSecurityNumber;
    this.dateOfBirth = dateOfBirth;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.password = password;
  }
}
