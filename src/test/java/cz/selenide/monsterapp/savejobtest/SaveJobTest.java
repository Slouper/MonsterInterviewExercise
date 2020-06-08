package cz.selenide.monsterapp.savejobtest;

import static java.lang.String.format;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

import cz.selenide.monsterapp.base.AbstractTest;
import cz.selenide.monsterapp.login.step.LoginStep;
import cz.selenide.monsterapp.pageobject.home.HomePage;
import cz.selenide.monsterapp.registration.step.RegistrationStep;
import cz.selenide.monsterapp.savejobtest.data.User;
import cz.selenide.monsterapp.savejobtest.step.SaveJobStep;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class SaveJobTest extends AbstractTest {

  @Test(dataProvider = "getTestData",
      description = "Open 'MonsterWorksDemo' page, "
          + "create account,"
          + "list jobs,"
          + "save second and last of them,"
          + "assert they are saved correctly.")
  public void createAccount_saveJob_getSavedJobsTest(User testUser) {

    logStep("Register new user with email [%s] and password [%s].", testUser.getEmail(), testUser.getPassword());
    new RegistrationStep().registerUser(HomePage.class, testUser);

    logStep("Login with user user with email [%s] and password [%s].", testUser.getEmail(), testUser.getPassword());
    new LoginStep().login(testUser);

    logStep("Save first and last Philips job for the user [%s].", testUser.getEmail());
    SaveJobStep saveJobStep = new SaveJobStep();
    List<String> savedJobNames = saveJobStep.openPhilipsJobs_saveFirstAndLastJobToFavorites(testUser);

    logStep("Check that following jobs [%s] saved in previous step are present on saved jobs page of the user [%s].", savedJobNames, testUser.getEmail());
    saveJobStep.assertExpectedJobsAreDisplayedOnSavedJobsPage(savedJobNames);
  }

  @DataProvider
  private Object[][] getTestData() {
    String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssS"));
    int randomYearOfBirth = (int) RandomUtils.nextLong(1940, 1996);
    User testUser = new User(
        "AUT" + randomAlphabetic(4),
        "AUT" + randomAlphabetic(4),
        Integer.parseInt(randomNumeric(6)),
        LocalDate.of(randomYearOfBirth, 10, 10),
        format("test%s@test.com", dateTime),
        randomNumeric(10),
        "Kreslo_1234");

    return new Object[][]{{testUser}};
  }
}
