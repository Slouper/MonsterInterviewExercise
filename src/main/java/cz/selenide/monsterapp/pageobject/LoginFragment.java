package cz.selenide.monsterapp.pageobject;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

import com.codeborne.selenide.SelenideElement;
import cz.selenide.monsterapp.pageobject.base.AbstractFragment;
import cz.selenide.monsterapp.pageobject.registration.RegistrationPagePersonalInformation;
import cz.selenide.utils.LoopUtils;

public class LoginFragment extends AbstractFragment {

  private final SelenideElement loginFragmentWrappingElement = $x("//div[@class='modal-content']");

  private final SelenideElement createNewAccountAnchor = $x("//a[text()='Create an account']");

  private final SelenideElement loginNameInput = $x("//input[@id='a_elem_0']");

  private final SelenideElement loginPasswordInput = $x("//input[@id='a_elem_1']");

  public RegistrationPagePersonalInformation clickOnRegistrationAnchor() {
    RegistrationPagePersonalInformation registrationPagePersonalInformation = page(RegistrationPagePersonalInformation.class);
    LoopUtils.doWhile(
        registrationPagePersonalInformation::isOpen,
        this::clickAndWait
    );
    registrationPagePersonalInformation.assertPageIsOpen();

    return registrationPagePersonalInformation;
  }

  private void clickAndWait() {
    createNewAccountAnchor.click();
    sleep(5000);
  }
}
