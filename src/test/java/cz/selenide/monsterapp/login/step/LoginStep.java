package cz.selenide.monsterapp.login.step;

import static com.codeborne.selenide.Selenide.page;

import cz.selenide.monsterapp.base.AbstractStep;
import cz.selenide.monsterapp.pageobject.home.HomePage;
import cz.selenide.monsterapp.savejobtest.data.User;

public class LoginStep extends AbstractStep {

  public void login(User testUser) {
    page(HomePage.class)
        .clickOnLoginButton()
        .setLoginEmail(testUser.getEmail())
        .setLoginPassword(testUser.getPassword())
        .clickOnSignInButton();
  }
}
