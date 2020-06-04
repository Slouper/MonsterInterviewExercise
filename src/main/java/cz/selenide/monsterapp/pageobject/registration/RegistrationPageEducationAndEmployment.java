package cz.selenide.monsterapp.pageobject.registration;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class RegistrationPageEducationAndEmployment extends RegistrationPage {

  private final SelenideElement highestEducationSelect = $x("//select[@id='elem_40']");
  private final SelenideElement currentlyInSchoolNoCheckBox = $x("//label[@id='id_option_label_elem_42-2009']");
  private final SelenideElement employedCheckBox = $x("//label[@id='id_option_label_elem_43-86562']");
  private final SelenideElement defenseContractorNoCheckBox = $x("//label[@id='id_option_label_elem_41-2009']");


  @Override
  public boolean isOpen() {
    return highestEducationSelect.isDisplayed();
  }

  public RegistrationPageEducationAndEmployment setMastersDegreeEducation() {
    highestEducationSelect.selectOption("Master's Degree");
    return this;
  }

  public RegistrationPageEducationAndEmployment clickOnCurrentlyInSchoolNoCheckBox() {
    currentlyInSchoolNoCheckBox.click();
    return this;
  }

  public RegistrationPageEducationAndEmployment clickOnEmloyedCheckBox() {
    employedCheckBox.click();
    return this;
  }

  public RegistrationPageEducationAndEmployment clickOnDefenseContractorNoCheckBox() {
    defenseContractorNoCheckBox.click();
    return this;
  }

}
