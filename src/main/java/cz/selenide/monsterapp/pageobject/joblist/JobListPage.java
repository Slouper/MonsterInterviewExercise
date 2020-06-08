package cz.selenide.monsterapp.pageobject.joblist;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import cz.selenide.monsterapp.pageobject.base.AbstractPage;

public class JobListPage extends AbstractPage {
  public static final SelenideElement noMoreResultsAnchor = $x("//a[@id = 'noMoreResults']");
}
