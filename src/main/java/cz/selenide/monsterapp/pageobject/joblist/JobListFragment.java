package cz.selenide.monsterapp.pageobject.joblist;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

import com.codeborne.selenide.SelenideElement;
import cz.selenide.monsterapp.pageobject.base.AbstractFragment;
import java.util.List;

public class JobListFragment extends AbstractFragment {
  private static final SelenideElement wrappingElement = $x("//div[@id='SearchResults']");

  private static final List<SelenideElement> jobRowList = wrappingElement.$$x(".//section");
  private static final String jobRowXPathWithPlaceholder = "(.//section)[%s]";
  private static final String jobRowTitleAnchorXPath = "(.//h2//a)[%s]";

  public String clickOnJobTitleAtRow(int index) {
    SelenideElement jobTitle = wrappingElement.$x(format(jobRowTitleAnchorXPath, index));
    String jobName = jobTitle.getText();
    jobTitle.click();
    return jobName;
  }

  public SelenideElement getJobRow(int index) {
    return wrappingElement.$x(format(jobRowXPathWithPlaceholder, index));
  }

  public int getAllJobRowsCount() {
    return jobRowList.size();
  }
}
