package cz.selenide.monsterapp.pageobject.userprofile;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.SelenideElement;
import cz.selenide.monsterapp.pageobject.base.AbstractPage;
import java.util.List;
import java.util.stream.Collectors;

public class SavedJobsPage extends AbstractPage {

  private static final List<SelenideElement> savedJobsNames = $$x("//div[contains(@class, 'content-wrapper')]//section");

  public SavedJobsPage openSavedJobsPage() {
    open("/savedJobs");
    return page(SavedJobsPage.class);
  }

  public List<String> getAllSavedJobsNames() {
    return savedJobsNames
        .stream()
        .map(SelenideElement::getText)
        .collect(Collectors.toList());
  }
}
