package cz.selenide.monsterapp.savejobtest.step;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;
import static java.lang.String.format;
import static java.util.Arrays.asList;

import com.codeborne.selenide.Selenide;
import cz.selenide.monsterapp.base.AbstractStep;
import cz.selenide.monsterapp.pageobject.LoginFragment;
import cz.selenide.monsterapp.pageobject.home.FooterFragment;
import cz.selenide.monsterapp.pageobject.home.HomePage;
import cz.selenide.monsterapp.pageobject.joblist.JobDetailFragment;
import cz.selenide.monsterapp.pageobject.joblist.JobListFragment;
import cz.selenide.monsterapp.pageobject.registration.CommonRegistrationPage;
import cz.selenide.monsterapp.pageobject.registration.R1_PersonalInformationPage;
import cz.selenide.monsterapp.pageobject.registration.R2_AccountPage;
import cz.selenide.monsterapp.pageobject.registration.R3_ContactInformationPage;
import cz.selenide.monsterapp.pageobject.registration.R4_MilitaryServicePage;
import cz.selenide.monsterapp.pageobject.registration.R5_EducationAndEmploymentPage;
import cz.selenide.monsterapp.pageobject.registration.R6_ProgramEligibilityPage;
import cz.selenide.monsterapp.pageobject.registration.R7_TermsAndConditionsPage;
import cz.selenide.monsterapp.pageobject.userprofile.SavedJobsPage;
import cz.selenide.monsterapp.savejobtest.data.User;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SaveJobStep extends AbstractStep {

  /**
   * Starts on HomePage
   */
  public SaveJobStep registerUser(Class<HomePage> homePageClass, User testUser) {
    Selenide.open("/home");
    page(homePageClass)
        .clickOnLoginButton()
        .clickOnRegistrationAnchor();

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
        .setPassword("Kreslo_1234")
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

    // TODO: Some better solution? There is still error, can not test the valid scenario, no success screen.
    sleep(15000);

    // TODO: uncomment
//    assertAlertDangerNotDisplayed();

    return this;
  }

  public SaveJobStep login(User testUser) {
    page(HomePage.class)
        .clickOnLoginButton()
        .setLoginEmail(testUser.getEmail())
        .setLoginPassword("Kreslo_1234")
        .clickOnSignInButton();

    return this;
  }

  public List<String> openPhilipsJobs_saveFirstAndLastJobToFavorites(User testUser) {
    page(FooterFragment.class)
        .clickOnPhilipsJobsAnchor();

    JobListFragment jobListFragment = page(JobListFragment.class);
    JobDetailFragment jobDetailFragment = page(JobDetailFragment.class);

    String firstJobName = jobListFragment.clickOnJobTitleAtRow(1);
    jobDetailFragment.clickOnSaveJobAnchor();

    if (page(LoginFragment.class).isOpen()) {
      login(testUser);
    }

    int countOfAllJobs = jobListFragment
        .scrollToLastRow()
        .getAllJobRowsCount();

    String lastJobName = jobListFragment.clickOnJobTitleAtRow(countOfAllJobs);
    jobDetailFragment.clickOnSaveJobAnchor();

    return asList(firstJobName, lastJobName);
  }

  private void assertAlertDangerNotDisplayed() {
    CommonRegistrationPage commonRegistrationPage = page(CommonRegistrationPage.class);
    if (commonRegistrationPage.alertDangerIsDisplayed()) {
      throw new AssertionError(format("Is expected, that account is created succesfully, but following error message displayed: [%s].",
          commonRegistrationPage.getDangerAlertValue().orElse("null")));
    }
  }

  public void assertExpectedJobsAreSavedInFavorites(List<String> expectedSavedJobNames) {
    // Go to Saved Jobs Page URL
    List<String> actualSavedJobNames = page(SavedJobsPage.class)
        .getAllSavedJobsNames();

    List<String> notSavedJobsInFavorites = expectedSavedJobNames
        .stream()
        .filter(Predicate.not(actualSavedJobNames::contains))
        .collect(Collectors.toList());

    if (!notSavedJobsInFavorites.isEmpty()) {
      throw new AssertionError(
          format("Is expected that all expected jobs names are contained in saved favorite jobs on profile page of the user, but following were not found: %s.\n",
              notSavedJobsInFavorites)
              + format("Expected job names to be saved in favorite jobs list: %s\n", expectedSavedJobNames)
              + format("Actual job names present in favorite job list: %s\n", actualSavedJobNames));
    }

  }
}
