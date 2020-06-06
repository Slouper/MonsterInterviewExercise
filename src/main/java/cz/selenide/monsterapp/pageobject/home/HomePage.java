package cz.selenide.monsterapp.pageobject.home;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.SelenideElement;
import cz.selenide.monsterapp.pageobject.LoginFragment;
import cz.selenide.monsterapp.pageobject.base.AbstractPage;

public class HomePage extends AbstractPage {
  private final SelenideElement loginButton = $x("//div[@class='users']//div[@role = 'form']//a[@role = 'button']");

  @Override
  public boolean isOpen() {
    return loginButton.isDisplayed();
  }

  public LoginFragment clickOnLoginButton() {
    loginButton.click();
    return page(LoginFragment.class);
  }
}
