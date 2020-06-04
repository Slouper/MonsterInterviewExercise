package cz.selenide.monsterapp.savejobtest.data;

import java.time.LocalDate;

public class User {

  private final String firstName;
  private final String lastName;
  private final int socialSecurityNumber;
  private final LocalDate dateOfBirth;

  public User(String firstName, String lastName, int socialSecurityNumber, LocalDate dateOfBirth) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.socialSecurityNumber = socialSecurityNumber;
    this.dateOfBirth = dateOfBirth;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getSocialSecurityNumber() {
    return socialSecurityNumber;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }
}
