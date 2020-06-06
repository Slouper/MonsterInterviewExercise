package cz.selenide.monsterapp.pageobject.registration;

import static cz.selenide.monsterapp.pageobject.base.Selector.firstRadioOrCheckBoxContainingLabel;

import com.codeborne.selenide.SelenideElement;

public class R7_TermsAndConditionsPage extends CommonRegistrationPage {

  private final SelenideElement termsAndConditionsCheckBox = firstRadioOrCheckBoxContainingLabel("Terms");

  public R7_TermsAndConditionsPage clickOnTermsAndConditionsCheckBox() {
    termsAndConditionsCheckBox.click();
    return this;
  }
}
