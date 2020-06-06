package cz.selenide.monsterapp.pageobject.registration;

import static cz.selenide.monsterapp.pageobject.base.Selector.radioOrCheckBoxContainingLabel;
import static cz.selenide.monsterapp.pageobject.base.SelenideExtensionsKt.performClick;

import com.codeborne.selenide.SelenideElement;

public class R4_MilitaryServicePage extends CommonRegistrationPage {

  private final SelenideElement activeDutyMilitaryNoRadio = radioOrCheckBoxContainingLabel("Are you Active Duty Military", 2);
  private final SelenideElement dependentOfSomeoneNoRadio = radioOrCheckBoxContainingLabel("Are you the spouse or dependent", 2);

  public R4_MilitaryServicePage clickOnActiveDutyMilitaryNoRadio() {
    performClick(activeDutyMilitaryNoRadio);
    return this;
  }

  public R4_MilitaryServicePage clickOnDependentOfSomeoneNoRadio() {
    performClick(dependentOfSomeoneNoRadio);
    return this;
  }
}
