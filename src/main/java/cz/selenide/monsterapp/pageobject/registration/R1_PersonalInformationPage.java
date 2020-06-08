package cz.selenide.monsterapp.pageobject.registration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static cz.selenide.monsterapp.pageobject.base.SelenideExtensionsKt.performClick;

import com.codeborne.selenide.SelenideElement;
import java.time.LocalDate;

public class R1_PersonalInformationPage extends CommonRegistrationPage {

  @SuppressWarnings("unused" /* Used for default page isOpen check */)
  private final SelenideElement registrationPageTitle = $x("//h1[text()='Create Account']");
  private final SelenideElement firstNameInput = $x("//input[@id='a_elem_0']");
  private final SelenideElement lastNameInput = $x("//input[@id='a_elem_1']");
  private final SelenideElement socialSecurityNumberInput = $x("//input[@id='a_elem_4']");
  private final SelenideElement socialSecurityNumberReenterInput = $x("//input[@id='a_elem_5']");
  private final SelenideElement dateOfBirthInput = $x("//input[@id='elem_6']");
  private final SelenideElement datePickerButton = $x("//input[@id='elem_6']/following-sibling::span[2]");
  private final SelenideElement todayDateAnchor = $x("//a[contains(text(), 'Today is')]");
  private final SelenideElement jobCorpsCenterSelectBox = $x("//select[@id='elem_7']");
  private final SelenideElement usCitizenYesRadio = $x("//label[@id='id_option_label_elem_3-2008']");

  @Override
  public boolean isOpen() {
    return pageTitleContains("Create Account");
  }

  public R1_PersonalInformationPage setFirstName(String firstName) {
    firstNameInput.setValue(firstName);
    return this;
  }

  public R1_PersonalInformationPage setLastName(String lastName) {
    lastNameInput.setValue(lastName);
    return this;
  }

  public R1_PersonalInformationPage setSocialSecurityNumbers(int socialSecurityNumber) {
    socialSecurityNumberInput.setValue(String.valueOf(socialSecurityNumber));
    socialSecurityNumberReenterInput.setValue(String.valueOf(socialSecurityNumber));
    return this;
  }

  public R1_PersonalInformationPage setDateOfBirth(LocalDate date) {
    performClick(datePickerButton);
    sleep(1000);
    performClick(todayDateAnchor);
    sleep(1000);
    performClick(dateOfBirthInput);
    sleep(1000);
    dateOfBirthInput.sendKeys(String.valueOf(date.getYear()));
    return this;
  }

  public R1_PersonalInformationPage setDefaultJobCorpsCenter() {
    jobCorpsCenterSelectBox.selectOption(1);
    return this;
  }

  public R1_PersonalInformationPage checkUsCitizenYesRadio() {
    usCitizenYesRadio.click();
    return this;
  }
}
