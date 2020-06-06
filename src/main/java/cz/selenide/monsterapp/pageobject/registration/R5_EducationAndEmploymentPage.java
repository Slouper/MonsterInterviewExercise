package cz.selenide.monsterapp.pageobject.registration;

import static cz.selenide.monsterapp.pageobject.base.Selector.firstSelectContainingLabel;
import static cz.selenide.monsterapp.pageobject.base.Selector.radioOrCheckBoxContainingLabel;
import static cz.selenide.monsterapp.pageobject.base.SelenideExtensionsKt.performClick;

import com.codeborne.selenide.SelenideElement;

public class R5_EducationAndEmploymentPage extends CommonRegistrationPage {

  private final SelenideElement highestEducationSelect = firstSelectContainingLabel("Highest Education");
  private final SelenideElement currentlyInSchoolNoRadio = radioOrCheckBoxContainingLabel("enrolled in school", 2);
  private final SelenideElement employedRadio = radioOrCheckBoxContainingLabel("Employment Status", 1);
  private final SelenideElement defenseContractorNoRadio = radioOrCheckBoxContainingLabel("defense contractor", 2);

  public R5_EducationAndEmploymentPage setMastersDegreeEducation() {
    highestEducationSelect.selectOption("Master's Degree");
    return this;
  }

  public R5_EducationAndEmploymentPage clickOnCurrentlyInSchoolNoRadio() {
    performClick(currentlyInSchoolNoRadio);
    return this;
  }

  public R5_EducationAndEmploymentPage clickOnEmloyedRadio() {
    performClick(employedRadio);
    return this;
  }

  public R5_EducationAndEmploymentPage clickOnDefenseContractorNoRadio() {
    performClick(defenseContractorNoRadio);
    return this;
  }

}
