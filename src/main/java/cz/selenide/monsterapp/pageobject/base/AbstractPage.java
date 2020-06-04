package cz.selenide.monsterapp.pageobject.base;

import static java.lang.String.format;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class AbstractPage {
  private ThreadLocal<Actions> actions;
  private JavascriptExecutor javascriptExecutor;

  public abstract boolean isOpen();

  public WebDriver getDriver() {
    return WebDriverRunner.getWebDriver();
  }

  protected Actions getActions() {
    if (actions.get() == null) {
      actions.set(new Actions(getDriver()));
    }
    return actions.get();
  }

  public JavascriptExecutor getJavascriptExecutor() {
    if (javascriptExecutor == null) {
      javascriptExecutor = (JavascriptExecutor) getDriver();
    }
    return javascriptExecutor;
  }


  public void assertPageIsOpen() {
    if (!this.isOpen()) {
      throw new PageIsNotOpenException(format("Page [%s] is not open.", this.getClass().getSimpleName()));
    }
  }

  public class PageIsNotOpenException extends RuntimeException {
    public PageIsNotOpenException(String message) {
      super(message);
    }
  }
}
