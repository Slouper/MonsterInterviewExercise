package cz.selenide.monsterapp.pageobject.registration;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class RegistrationPageContactInformation extends RegistrationPage {

  private final SelenideElement doNotHavePrimaryAddressButton = $x("//button[normalize-space(text())='I do not have a primary address']");
  private final SelenideElement phoneNumberInput = $x("//input[@id='a_elem_14']");
  private final SelenideElement phoneTypeSelect = $x("//select[@id='elem_15']");
  private final SelenideElement contactMethodSelect = $x("//select[@id='elem_20']");

  @Override
  public boolean isOpen() {
    return doNotHavePrimaryAddressButton.isDisplayed();
  }

  public RegistrationPageContactInformation clickOnDoNotHavePrimaryAddress() {
    doNotHavePrimaryAddressButton.click();
    return this;
  }

  /**
   * @param phoneNumber - 10 positions
   */
  public RegistrationPageContactInformation setPhoneNumber(String phoneNumber) {
    phoneNumberInput.setValue(phoneNumber);
    return this;
  }

  public RegistrationPageContactInformation setMobilePhoneType() {
    phoneTypeSelect.selectOption("Mobile");
    return this;
  }

  public RegistrationPageContactInformation setEmailAsContactMethod() {
    contactMethodSelect.selectOption("Email");
    return this;
  }
}
