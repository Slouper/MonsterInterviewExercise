package cz.selenide.monsterapp.pageobject.registration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static cz.selenide.monsterapp.pageobject.base.Selector.firstInputContainingLabel;
import static cz.selenide.monsterapp.pageobject.base.Selector.firstSelectContainingLabel;

import com.codeborne.selenide.SelenideElement;

public class R3_ContactInformationPage extends CommonRegistrationPage {

  private final SelenideElement doNotHavePrimaryAddressButton = $x("//button[normalize-space(text())='I do not have a primary address']");
  private final SelenideElement phoneNumberInput = firstInputContainingLabel("Primary Phone");
  private final SelenideElement phoneTypeSelect = firstSelectContainingLabel("Type");
  private final SelenideElement contactMethodSelect = firstSelectContainingLabel("Preferred Contact Method");

  public R3_ContactInformationPage clickOnDoNotHavePrimaryAddress() {
    doNotHavePrimaryAddressButton.click();
    return this;
  }

  /**
   * @param phoneNumber - 10 positions
   */
  public R3_ContactInformationPage setPhoneNumber(String phoneNumber) {
    sleep(500);
    phoneNumberInput.setValue(phoneNumber);
    return this;
  }

  public R3_ContactInformationPage setMobilePhoneType() {
    phoneTypeSelect.selectOption("Mobile");
    return this;
  }

  public R3_ContactInformationPage setEmailAsContactMethod() {
    contactMethodSelect.selectOption("Email");
    return this;
  }
}
