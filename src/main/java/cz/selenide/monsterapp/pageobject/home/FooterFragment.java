package cz.selenide.monsterapp.pageobject.home;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import cz.selenide.monsterapp.pageobject.base.AbstractFragment;

public class FooterFragment extends AbstractFragment {
  private final SelenideElement wrappingElement = $x("//section[contains(@class, 'main-footer')]");
  private final SelenideElement philipsJobsAnchor = $x("//a[text() = 'Philips Jobs']");

  public void clickOnPhilipsJobsAnchor() {
    philipsJobsAnchor.click();
  }
}
