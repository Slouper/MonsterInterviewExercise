package cz.selenide.monsterapp.pageobject.base;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import java.util.Optional;

public class Alerts {
  private final SelenideElement dangerAlert = $x("//div[contains(@class, 'alert-danger')]");
  private final SelenideElement dangerAlertSpan = $x("//div[contains(@class, 'alert-danger')]/p/span");

  public Optional<String> getDangerAlertValue() {
    return Optional.of(dangerAlertSpan.getText());
  }

  public boolean isAlertDangerDisplayed() {
    return dangerAlert.isDisplayed();
  }
}
