package cz.selenide.monsterapp.pageobject.registration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import cz.selenide.monsterapp.pageobject.base.AbstractPage;
import java.util.List;
import java.util.Optional;

public class CommonRegistrationPage extends AbstractPage {
  private final List<SelenideElement> nextSectionButton = $$x("//button[normalize-space(text()) = 'Next Section']");
  private final SelenideElement createAnAccountButton = $x("//Button[normalize-space(text()) = 'Create an account']");
  private final SelenideElement dangerAlert = $x("//div[contains(@class, 'alert-danger')]");
  private final SelenideElement dangerAlertSpan = $x("//div[contains(@class, 'alert-danger')]/p/span");

  public void clickOnNextSectionButton() {
    Optional<SelenideElement> nextSectionButtonOpt = nextSectionButton
        .stream()
        .filter(SelenideElement::isDisplayed)
        .findFirst();

    if (nextSectionButtonOpt.isPresent()) {
      nextSectionButtonOpt.get().click();
    } else {
      nextSectionButton.get(0).click();
    }
  }

  public void clickOnCreateAnAccountButton() {
    createAnAccountButton.click();
  }

  public Optional<String> getDangerAlertValue() {
    return Optional.of(dangerAlertSpan.getText());
  }

  public boolean alertDangerIsDisplayed() {
    return dangerAlert.isDisplayed();
  }
}
