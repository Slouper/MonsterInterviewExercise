package cz.selenide.monsterapp.pageobject.base;

import static java.lang.String.format;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import java.lang.reflect.Field;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class AbstractFragment extends ElementsContainer {
  private JavascriptExecutor javascriptExecutor;

  public WebDriver getDriver() {
    return WebDriverRunner.getWebDriver();
  }

  public JavascriptExecutor getJavascriptExecutor() {
    if (javascriptExecutor == null) {
      javascriptExecutor = (JavascriptExecutor) getDriver();
    }
    return javascriptExecutor;
  }

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
          "Is expected, that page class [%s] has at least one SelenideElement defined, but none was found and therfore isOpen() check could not be performed.",
          this.getClass().getSimpleName()));
    }
  }
}
