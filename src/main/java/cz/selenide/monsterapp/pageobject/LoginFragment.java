package cz.selenide.monsterapp.pageobject;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;
import static cz.selenide.monsterapp.pageobject.base.Selector.firstInputContainingLabel;
import static cz.selenide.monsterapp.pageobject.base.SelenideExtensionsKt.performClick;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.webdriver.WebDriverFactory;
import cz.selenide.monsterapp.pageobject.base.AbstractFragment;
import cz.selenide.monsterapp.pageobject.registration.R1_PersonalInformationPage;
import cz.selenide.monsterapp.utils.LoopUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginFragment extends AbstractFragment {
  private static final Logger LOG = LogManager.getLogger(WebDriverFactory.class);

  private final SelenideElement wrappingElement = $x("//div[@class='modal-content']");

  private final SelenideElement createNewAccountAnchor = wrappingElement.$x(".//a[text()='Create an account']");
  private final SelenideElement loginEmailInput = firstInputContainingLabel(wrappingElement, "Email Address");
  private final SelenideElement loginPasswordInput = firstInputContainingLabel(wrappingElement, "Password");
  private final SelenideElement signInButton = wrappingElement.$x("(.//button[@type='submit' and normalize-space(text())='Sign in'])[1]");

  public R1_PersonalInformationPage clickOnRegistrationAnchor() {
    R1_PersonalInformationPage personalInformationPage = page(R1_PersonalInformationPage.class);
    LoopUtils.doWhile(
        personalInformationPage::isOpen,
        this::clickOnCreateNewAccountWithWait
    );
    personalInformationPage.assertPageIsOpen();
    return personalInformationPage;
  }

  private void clickOnCreateNewAccountWithWait() {
    // TODO: Could not resolve the issue with clicking on the link. It clicks but no result of click is visible. Therefore there is hard waiting until now.
    LOG.warn(
        "TODO: Investigate why we have tio wait and then fix hard waiting for 'Create New Account' to be clicked. Resolve the issue with clicking without result.'");
    sleep(5000);
    performClick(createNewAccountAnchor);
    sleep(5000);
  }

  public LoginFragment setLoginEmail(String email) {
    loginEmailInput.setValue(email);
    return this;
  }

  public LoginFragment setLoginPassword(String password) {
    loginPasswordInput.setValue(password);
    return this;
  }

  public void clickOnSignInButton() {
    performClick(signInButton);
  }
}
