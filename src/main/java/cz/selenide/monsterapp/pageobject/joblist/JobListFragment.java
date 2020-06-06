package cz.selenide.monsterapp.pageobject.joblist;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static java.lang.String.format;

import com.codeborne.selenide.SelenideElement;
import cz.selenide.monsterapp.pageobject.base.AbstractFragment;
import java.util.List;
import org.testng.Assert;

public class JobListFragment extends AbstractFragment {
  private static final SelenideElement wrappingElement = $x("//div[@id='SearchResults']");
  private static final List<SelenideElement> jobRowList = $$x("//section");
  private static final String jobRowXPathWithPlaceholder = "(//section)[%s]";
  private static final SelenideElement noMoreResultsAnchor = $x("//a[@id = 'noMoreResults']");
  private static final String jobRowTitleAnchorXPath = "(//h2//a)[%s]";

  public String clickOnJobTitleAtRow(int index) {
    SelenideElement jobTitle = $x(format(jobRowTitleAnchorXPath, index));
    String jobName = jobTitle.getText();
    jobTitle.click();
    return jobName;
  }

  private SelenideElement getJobAtRow(int index) {
    return $x(format(jobRowXPathWithPlaceholder, index));
  }

  public int getAllJobRowsCount() {
    return jobRowList.size();
  }

  public JobListFragment scrollToLastRow() {
    int attempt = 0;
    while (!noMoreResultsAnchor.isDisplayed() && attempt < 15) {
      getJavascriptExecutor().executeScript("window.scrollBy(0,1000)");
      sleep(500);
      attempt++;
    }
    Assert.assertTrue(noMoreResultsAnchor.isDisplayed(), "Is expected that on the end of the job list is displayed anchor 'No More Results', but none was found.");

    return this;
  }
}
