package cz.selenide.monsterapp.pageobject.registration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;
import static java.lang.String.format;

import com.codeborne.selenide.SelenideElement;
import java.time.LocalDate;

public class RegistrationPagePersonalInformation extends RegistrationPage {

  private final SelenideElement registrationPageTitle = $x("//h1[text()='Create Account']");
  private final SelenideElement firstNameInput = $x("//input[@id='a_elem_0']");
  private final SelenideElement lastNameInput = $x("//input[@id='a_elem_1']");
  private final SelenideElement socialSecurityNumberInput = $x("//input[@id='a_elem_4']");
  private final SelenideElement socialSecurityNumberReenterInput = $x("//input[@id='a_elem_5']");
  private final SelenideElement dateOfBirthInput = $x("//input[@id='elem_6']");
  private final SelenideElement datePickerButton = $x("//input[@id='elem_6']/following-sibling::span[2]");
  private final SelenideElement todayDateAchnor = $x("//a[contains(text(), 'Today is')]");
  private final SelenideElement jobCorpsCenterSelectBox = $x("//select[@id='elem_7']");
  private final SelenideElement usCitizenCheckBox = $x("//label[@id='id_option_label_elem_3-2008']");

  @Override
  public boolean isOpen() {
    return registrationPageTitle.isDisplayed();
  }

  public RegistrationPagePersonalInformation setFirstName(String firstName) {
    refresh();
    firstNameInput.setValue(firstName);
    return this;
  }

  public RegistrationPagePersonalInformation setLastName(String lastName) {
    lastNameInput.setValue(lastName);
    return this;
  }

  public RegistrationPagePersonalInformation setSocialSecurityNumbers(int socialSecurityNumber) {
    socialSecurityNumberInput.setValue(String.valueOf(socialSecurityNumber));
    socialSecurityNumberReenterInput.setValue(String.valueOf(socialSecurityNumber));
    return this;
  }

  public RegistrationPagePersonalInformation setDateOfBirth(LocalDate date) {
    getJavascriptExecutor().executeScript(format("arguments[0].setAttribute('value',%s)", "10101990"), dateOfBirthInput);
    datePickerButton.click();
    sleep(1000);
    todayDateAchnor.click();
    sleep(1000);
    return this;
  }

  public RegistrationPagePersonalInformation setDefaultJobCorpsCenter() {
    jobCorpsCenterSelectBox.selectOption(1);
    return this;
  }

  public void checkUsCitizenCheckBox() {
    usCitizenCheckBox.click();
  }
}
