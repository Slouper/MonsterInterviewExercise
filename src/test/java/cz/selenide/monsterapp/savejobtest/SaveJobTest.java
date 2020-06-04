package cz.selenide.monsterapp.savejobtest;

import com.codeborne.selenide.Selenide;
import cz.selenide.monsterapp.base.AbstractTest;
import cz.selenide.monsterapp.savejobtest.data.User;
import cz.selenide.monsterapp.savejobtest.step.SaveJobTestStep;
import java.time.LocalDate;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class SaveJobTest extends AbstractTest {

  @Test(dataProvider = "getTestData",
      description = "Open 'MosterWorksDemo' page, "
          + "create account,"
          + "list jobs,"
          + "save second and last of them,"
          + "assert they are saved correctly.")
  public void createAccount_saveJob_getSavedJobsTest(User testUser) {
    new SaveJobTestStep()
        .registerUser(testUser);

    // Wait only to see the result of the test on the screen
    Selenide.sleep(5000);
  }

  @DataProvider
  private Object[][] getTestData() {
    User testUser = new User(
        "Petr",
        "Sloup",
        123456,
        LocalDate.of(1990, 10, 10));

    return new Object[][]{{testUser}};
  }
}
