package cz.selenide.monsterapp.pageobject.registration;

import static cz.selenide.monsterapp.pageobject.base.Selector.firstInputContainingLabel;
import static cz.selenide.monsterapp.pageobject.base.Selector.firstSelectContainingLabel;

import com.codeborne.selenide.SelenideElement;

public class R2_AccountPage extends CommonRegistrationPage {

  private final SelenideElement emailInput = firstInputContainingLabel("Email Address");
  private final SelenideElement emailReenterInput = firstInputContainingLabel("Re-Enter Email Address");
  private final SelenideElement passwordInput = firstInputContainingLabel("Password");
  private final SelenideElement passwordReenterInput = firstInputContainingLabel("Re-enter password");
  private final SelenideElement securityQuestionSelect = firstSelectContainingLabel("Choose a security question");
  private final SelenideElement securityQuestionAnswerInput = firstInputContainingLabel("Your Answer");

  public R2_AccountPage setEmail(String value) {
    emailInput.setValue(value);
    emailReenterInput.setValue(value);
    return this;
  }

  public R2_AccountPage setPassword(String value) {
    passwordInput.setValue(value);
    passwordReenterInput.setValue(value);
    return this;
  }

  public R2_AccountPage setDefaultSecurityQuestion() {
    securityQuestionSelect.selectOption(1);
    securityQuestionAnswerInput.setValue("AutomatTest");
    return this;
  }
}
