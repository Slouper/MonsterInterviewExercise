package cz.selenide.monsterapp.pageobject.joblist;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import cz.selenide.monsterapp.pageobject.base.AbstractFragment;

public class JobDetailFragment extends AbstractFragment {
  private final SelenideElement wrappingElement = $x("//div[@id='ContentContainer']");
  private final SelenideElement saveJobAnchor = $x("//a[@id='SaveJob']//*[text() = 'Save']");

  public void clickOnSaveJobAnchor() {
    saveJobAnchor.click();
  }
}
