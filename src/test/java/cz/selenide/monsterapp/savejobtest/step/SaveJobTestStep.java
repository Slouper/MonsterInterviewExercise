package cz.selenide.monsterapp.savejobtest.step;

import com.codeborne.selenide.Selenide;
import cz.selenide.monsterapp.base.AbstractStep;
import cz.selenide.monsterapp.pageobject.HomePage;
import cz.selenide.monsterapp.savejobtest.data.User;

public class SaveJobTestStep extends AbstractStep {

  public void registerUser(User testUser) {
    Selenide.open("/home");
    Selenide.page(HomePage.class)
        .clickOnLoginButton()
        .clickOnRegistrationAnchor()
        .setFirstName(testUser.getFirstName())
        .setLastName(testUser.getLastName())
        .setSocialSecurityNumbers(testUser.getSocialSecurityNumber())
        .setDateOfBirth(testUser.getDateOfBirth())
        .setDefaultJobCorpsCenter()
        .checkUsCitizenCheckBox();
  }
}
