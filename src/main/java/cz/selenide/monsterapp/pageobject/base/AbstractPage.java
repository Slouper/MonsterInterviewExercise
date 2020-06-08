package cz.selenide.monsterapp.pageobject.base;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import java.lang.reflect.Field;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class AbstractPage {
  private Actions actions;
  private JavascriptExecutor javascriptExecutor;
  private Alerts alerts;

  public boolean isOpen() {
    SelenideElement checkedElement = null;
    Field[] fields = this.getClass().getDeclaredFields();
    for (Field field : fields) {
      if (field.getType() == SelenideElement.class) {
        field.setAccessible(true);
        try {
          checkedElement = (SelenideElement) field.get(this);
        } catch (IllegalAccessException e) {
          throw new RuntimeException(format("Could not access first SelenideElement field in the class [%s].", this.getClass().getSimpleName()));
        }
      }
    }

    if (checkedElement != null) {
      return checkedElement.isDisplayed();
    } else {
      throw new RuntimeException(format(
          "Is expected, that page class [%s] has at least one SelenideElement defined, but none was found and therefor isOpen() check could not be performed.",
          this.getClass().getSimpleName()));
    }
  }

  public WebDriver getDriver() {
    return WebDriverRunner.getWebDriver();
  }

  @SuppressWarnings("unused" /* For manipulating with page */)
  protected Actions getActions() {
    if (actions == null) {
      actions = new Actions(getDriver());
    }
    return actions;
  }

  public Alerts alerts() {
    if (alerts == null) {
      alerts = new Alerts();
    }
    return alerts;
  }

  @SuppressWarnings("unused" /* For manipulating via javascript */)
  public JavascriptExecutor getJavascriptExecutor() {
    if (javascriptExecutor == null) {
      javascriptExecutor = (JavascriptExecutor) getDriver();
    }
    return javascriptExecutor;
  }

  public final void assertPageIsOpen() {
    if (!this.isOpen()) {
      throw new PageIsNotOpenException(format("Page [%s] is not open.", this.getClass().getSimpleName()));
    }
  }

  public static class PageIsNotOpenException extends RuntimeException {
    public PageIsNotOpenException(String message) {
      super(message);
    }
  }

  @SuppressWarnings("SameParameterValue" /* For variable usage on all the pages */)
  protected boolean pageTitleContains(String value) {
    return $x(format("//title[contains(normalize-space(text()), '%s')]", value)).exists();
  }
}
