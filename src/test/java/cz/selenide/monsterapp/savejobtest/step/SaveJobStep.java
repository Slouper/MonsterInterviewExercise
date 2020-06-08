package cz.selenide.monsterapp.savejobtest.step;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;
import static cz.selenide.monsterapp.utils.LoopUtils.doWhile;
import static java.lang.String.format;
import static java.util.Arrays.asList;

import cz.selenide.monsterapp.base.AbstractStep;
import cz.selenide.monsterapp.login.step.LoginStep;
import cz.selenide.monsterapp.pageobject.LoginFragment;
import cz.selenide.monsterapp.pageobject.home.FooterFragment;
import cz.selenide.monsterapp.pageobject.joblist.JobDetailFragment;
import cz.selenide.monsterapp.pageobject.joblist.JobListFragment;
import cz.selenide.monsterapp.pageobject.joblist.JobListPage;
import cz.selenide.monsterapp.pageobject.userprofile.SavedJobsPage;
import cz.selenide.monsterapp.savejobtest.data.User;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SaveJobStep extends AbstractStep {

  public List<String> openPhilipsJobs_saveFirstAndLastJobToFavorites(User testUser) {
    FooterFragment footerFragment = page(FooterFragment.class);
    footerFragment.clickOnPhilipsJobsAnchor();

    JobListFragment jobListFragment = page(JobListFragment.class);
    JobDetailFragment jobDetailFragment = page(JobDetailFragment.class);

    logStep("Saving second job to saved jobs.");
    String firstJobName = jobListFragment.clickOnJobTitleAtRow(2);
    jobDetailFragment.clickOnSaveJobAnchor();

    // Probably not correct behavior - after clicking on save job, it gets stuck on the blank page
    footerFragment.clickOnPhilipsJobsAnchor();

    if (page(LoginFragment.class).isOpen()) {
      logStep("Because 'LoginPage' is open, we login the user.");
      new LoginStep().login(testUser);
    }

    logStep("Saving last job to saved jobs.");
    String lastJobName = saveLastJob(jobListFragment, jobDetailFragment);

    return asList(firstJobName, lastJobName);
  }

  private String saveLastJob(JobListFragment jobListFragment, JobDetailFragment jobDetailFragment) {
    doWhile(
        JobListPage.noMoreResultsAnchor::isDisplayed,
        () -> {
          int jobsCount = jobListFragment.getAllJobRowsCount();
          jobListFragment.getJobRow(jobsCount).scrollIntoView(true);
          sleep(5000);
        }
    );

    String lastJobName = jobListFragment.clickOnJobTitleAtRow(jobListFragment.getAllJobRowsCount());
    jobDetailFragment.clickOnSaveJobAnchor();
    return lastJobName;
  }

  public void assertExpectedJobsAreDisplayedOnSavedJobsPage(List<String> expectedSavedJobNames) {
    // Go to Saved Jobs Page URL
    List<String> actualSavedJobNames = page(SavedJobsPage.class)
        .openSavedJobsPage()
        .getAllSavedJobsNames();

    List<String> notSavedJobsInFavorites = expectedSavedJobNames
        .stream()
        .filter(Predicate.not(actualSavedJobNames::contains))
        .collect(Collectors.toList());

    if (!notSavedJobsInFavorites.isEmpty()) {
      throw new AssertionError(
          format("Is expected that all expected jobs names are contained in saved favorite jobs on profile page of the user, but following were not found: %s.\n",
              notSavedJobsInFavorites)
              + format("Expected job names to be saved in favorite jobs list: %s\n", expectedSavedJobNames)
              + format("Actual job names present in favorite job list: %s\n", actualSavedJobNames));
    }

  }
}
