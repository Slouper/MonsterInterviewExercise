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
  private final SelenideElement createNewAccountAnchor = $x("//a[text()='Create an account']");
  private final SelenideElement loginEmailInput = firstInputContainingLabel("Email Address");
  private final SelenideElement loginPasswordInput = firstInputContainingLabel("Password");
  private final SelenideElement signInButton = $x("(//button[@type='submit' and normalize-space(text())='Sign in'])[1]");

  public void clickOnRegistrationAnchor() {
    R1_PersonalInformationPage personalInformationPage = page(R1_PersonalInformationPage.class);
    LoopUtils.doWhile(
        personalInformationPage::isOpen,
        this::clickOnCreateNewAccountWithWait
    );
    personalInformationPage.assertPageIsOpen();
  }

  private void clickOnCreateNewAccountWithWait() {
    // TODO: Could not resolve the issue with clicking on the link. It clicks but no result of click is visible.
    LOG.warn("TODO: Fix this hard waiting for 'Create New Account' to be clicked. Resolve the issue with clicking without result.'");
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
