package cz.selenide.monsterapp.pageobject.registration;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class RegistrationPageMilitaryService extends RegistrationPage {

  private final SelenideElement activeDutyMilitaryNoCheckBox = $x("//label[@id='id_option_label_elem_38-2009']");
  private final SelenideElement dependentOfSomeoneNoCheckBox = $x("//label[@id='id_option_label_elem_39-2009']");

  @Override
  public boolean isOpen() {
    return activeDutyMilitaryNoCheckBox.isDisplayed();
  }

  public RegistrationPageMilitaryService clickOnActiveDutyMilitaryNoCheckBox() {
    activeDutyMilitaryNoCheckBox.click();
    return this;
  }

  public RegistrationPageMilitaryService clickOnDependentOfSomeoneNoCheckBox(String phoneNumber) {
    dependentOfSomeoneNoCheckBox.click();
    return this;
  }
}
