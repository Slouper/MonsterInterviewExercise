package cz.selenide.monsterapp.registration.step;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;
import static java.lang.String.format;

import com.codeborne.selenide.Selenide;
import cz.selenide.monsterapp.base.AbstractStep;
import cz.selenide.monsterapp.pageobject.base.Alerts;
import cz.selenide.monsterapp.pageobject.home.HomePage;
import cz.selenide.monsterapp.pageobject.registration.CommonRegistrationPage;
import cz.selenide.monsterapp.pageobject.registration.R1_PersonalInformationPage;
import cz.selenide.monsterapp.pageobject.registration.R2_AccountPage;
import cz.selenide.monsterapp.pageobject.registration.R3_ContactInformationPage;
import cz.selenide.monsterapp.pageobject.registration.R4_MilitaryServicePage;
import cz.selenide.monsterapp.pageobject.registration.R5_EducationAndEmploymentPage;
import cz.selenide.monsterapp.pageobject.registration.R6_ProgramEligibilityPage;
import cz.selenide.monsterapp.pageobject.registration.R7_TermsAndConditionsPage;
import cz.selenide.monsterapp.savejobtest.data.User;
import org.testng.Assert;

public class RegistrationStep extends AbstractStep {

  /**
   * Starts on HomePage
   */
  public void registerUser(Class<HomePage> homePageClass, User testUser) {
    Selenide.open("/home");
    R1_PersonalInformationPage personalInformationPage = page(homePageClass)
        .clickOnLoginButton()
        .clickOnRegistrationAnchor();

    refreshIfAlertsDangerIsDisplayed(personalInformationPage);

    page(R1_PersonalInformationPage.class)
        .setFirstName(testUser.getFirstName())
        .setLastName(testUser.getLastName())
        .setSocialSecurityNumbers(testUser.getSocialSecurityNumber())
        .setDateOfBirth(testUser.getDateOfBirth())
        .setDefaultJobCorpsCenter()
        .checkUsCitizenYesRadio()
        .clickOnNextSectionButton();

    page(R2_AccountPage.class)
        .setEmail(testUser.getEmail())
        .setPassword(testUser.getPassword())
        .setDefaultSecurityQuestion()
        .clickOnNextSectionButton();

    page(R3_ContactInformationPage.class)
        .clickOnDoNotHavePrimaryAddress()
        .setEmailAsContactMethod()
        .setMobilePhoneType()
        .setPhoneNumber(testUser.getPhoneNumber())
        .clickOnNextSectionButton();

    page(R4_MilitaryServicePage.class)
        .clickOnActiveDutyMilitaryNoRadio()
        .clickOnDependentOfSomeoneNoRadio()
        .clickOnNextSectionButton();

    page(R5_EducationAndEmploymentPage.class)
        .clickOnCurrentlyInSchoolNoRadio()
        .clickOnDefenseContractorNoRadio()
        .clickOnEmloyedRadio()
        .setMastersDegreeEducation()
        .clickOnNextSectionButton();

    page(R6_ProgramEligibilityPage.class)
        .clickOnEligibilityForServicesNoRadio()
        .clickOnHispanicOrLatinoRadio()
        .clickOnMaleRadio()
        .clickOnAsianCheckBox()
        .clickOnReceivingTanfNoRadio()
        .clickOnWorkInLast25DaysNoRadio()
        .clickOnNextSectionButton();

    page(R7_TermsAndConditionsPage.class)
        .clickOnTermsAndConditionsCheckBox()
        .clickOnCreateAnAccountButton();

    // TODO: investigate how much time takes account creation on BEs. After that bring the solution for dynamic waiting.
    sleep(5000);

    assertErrorAlertIsDisplayed();
  }

  private void refreshIfAlertsDangerIsDisplayed(R1_PersonalInformationPage personalInformationPage) {
    Alerts alerts = personalInformationPage.alerts();
    if (alerts.isAlertDangerDisplayed()) {
      refresh();
      sleep(2000);
    }

    if (alerts.isAlertDangerDisplayed()) {
      Assert.fail(format("Is expected that registration form is displayed, but error alert displayed instead. Alert text [%s].", alerts.getDangerAlertValue()));
    }

  }

  private void assertErrorAlertIsDisplayed() {
    CommonRegistrationPage commonRegistrationPage = page(CommonRegistrationPage.class);
    if (commonRegistrationPage.alerts().isAlertDangerDisplayed()) {
      throw new AssertionError(format("Is expected, that account is created succesfully, but following error message displayed: [%s].",
          commonRegistrationPage.alerts().getDangerAlertValue().orElse("null")));
    }
  }
}
