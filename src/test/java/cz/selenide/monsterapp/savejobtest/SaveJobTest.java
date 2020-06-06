package cz.selenide.monsterapp.savejobtest;

import static java.lang.String.format;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

import cz.selenide.monsterapp.base.AbstractTest;
import cz.selenide.monsterapp.pageobject.home.HomePage;
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
    SaveJobStep saveJobStep = new SaveJobStep();

    List<String> savedJobNames = saveJobStep
        .registerUser(HomePage.class, testUser)
        .login(testUser)
        .openPhilipsJobs_saveFirstAndLastJobToFavorites(testUser);

    // TODO: Finish some steps in @link{SaveJobStep#assertExpectedJobsAreSavedInFavorites}
    saveJobStep.assertExpectedJobsAreSavedInFavorites(savedJobNames);
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
        randomNumeric(10));

    return new Object[][]{{testUser}};
  }
}
