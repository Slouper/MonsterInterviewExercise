package cz.selenide.monsterapp.pageobject.registration;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import cz.selenide.monsterapp.pageobject.base.AbstractPage;
import org.apache.commons.lang3.NotImplementedException;

public abstract class RegistrationPage extends AbstractPage {
  private final SelenideElement nextSectionButton = $x("//button[normalize-space(text()) = 'Next Section']");

  @Override
  public boolean isOpen() {
    throw new NotImplementedException("IsOpen not implemented for Abstract RegistrationPage.");
  }

  public void clickOnNextSectionButton() {
    nextSectionButton.click();
  }
}
