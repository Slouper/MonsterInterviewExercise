package cz.selenide.monsterapp.pageobject.registration;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class RegistrationPageAccount extends RegistrationPage {

  private final SelenideElement emailInput = $x("//input[@id='c_elem_8']");
  private final SelenideElement emailReenterInput = $x("//input[@id='a_elem_10']");
  private final SelenideElement passwordInput = $x("//input[@id='a_elem_11']");
  private final SelenideElement passwordReenterInput = $x("//input[@id='a_elem_12']");
  private final SelenideElement securityQuestionSelect = $x("//select[@id='elem_9']");
  private final SelenideElement securityQuestionAnswerInput = $x("//input[@id='a_elem_13']");

  @Override
  public boolean isOpen() {
    return emailInput.isDisplayed();
  }

  public RegistrationPageAccount setEmail(String value) {
    emailInput.setValue(value);
    emailReenterInput.setValue(value);
    return this;
  }

  public RegistrationPageAccount setPassword(String value) {
    passwordInput.setValue(value);
    passwordReenterInput.setValue(value);
    return this;
  }

  public RegistrationPageAccount setDefaultSecurityQuestion() {
    securityQuestionSelect.selectOption(1);
    securityQuestionAnswerInput.setValue("AutomatTest");
    return this;
  }
}
