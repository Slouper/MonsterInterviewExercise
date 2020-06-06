package cz.selenide.monsterapp.pageobject.registration;

import static cz.selenide.monsterapp.pageobject.base.SelenideExtensionsKt.performClick;

import com.codeborne.selenide.SelenideElement;
import cz.selenide.monsterapp.pageobject.base.Selector;

public class R6_ProgramEligibilityPage extends CommonRegistrationPage {

  private final SelenideElement eligibilityForServicesNoRadio = Selector.radioOrCheckBoxContainingLabel("determine your eligibility for services", 2);
  private final SelenideElement receivingTanfNoRadio = Selector.radioOrCheckBoxContainingLabel("receiving TANF", 2);
  private final SelenideElement workInLast25DaysNoRadio = Selector.radioOrCheckBoxContainingLabel("farm worker for at least 25 days", 2);
  private final SelenideElement maleRadio = Selector.radioOrCheckBoxContainingLabel("Gender", 1);
  private final SelenideElement asianCheckBox = Selector.radioOrCheckBoxContainingLabel("Race", 2);
  private final SelenideElement hispanicOrLatinoRadio = Selector.radioOrCheckBoxContainingLabel("Hispanic or Latino", 1);

  public R6_ProgramEligibilityPage clickOnEligibilityForServicesNoRadio() {
    performClick(eligibilityForServicesNoRadio);
    return this;
  }

  public R6_ProgramEligibilityPage clickOnReceivingTanfNoRadio() {
    performClick(receivingTanfNoRadio);
    return this;
  }


  public R6_ProgramEligibilityPage clickOnWorkInLast25DaysNoRadio() {
    performClick(workInLast25DaysNoRadio);
    return this;
  }

  public R6_ProgramEligibilityPage clickOnMaleRadio() {
    performClick(maleRadio);
    return this;
  }

  public R6_ProgramEligibilityPage clickOnAsianCheckBox() {
    performClick(asianCheckBox);
    return this;
  }

  public R6_ProgramEligibilityPage clickOnHispanicOrLatinoRadio() {
    performClick(hispanicOrLatinoRadio);
    return this;
  }
}
