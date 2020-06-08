package cz.selenide.monsterapp.pageobject.base;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

import com.codeborne.selenide.SelenideElement;
import javax.annotation.Nullable;

public class Selector {

  public static SelenideElement firstInputContainingLabel(String label) {
    return firstInputContainingLabel(null, label);
  }

  public static SelenideElement firstInputContainingLabel(@Nullable SelenideElement wrappingElement, String label) {
    return wrappingElement != null
        ? wrappingElement.$x(format("(.//label[contains(., '%s')])[1]/following-sibling::*/input[not(contains(@class, 'ng-hide'))]", label))
        : $x(format("(//label[contains(., '%s')])[1]/following-sibling::*/input[not(contains(@class, 'ng-hide'))]", label));
  }

  public static SelenideElement firstSelectContainingLabel(String label) {
    return firstSelectContainingLabel(null, label);
  }

  public static SelenideElement firstSelectContainingLabel(@Nullable SelenideElement wrappingElement, String label) {
    return wrappingElement != null
        ? wrappingElement.$x(format("(.//label[contains(., '%s')])[1]/following-sibling::*/select[not(contains(@class, 'ng-hide'))]", label))
        : $x(format("(//label[contains(., '%s')])[1]/following-sibling::*/select[not(contains(@class, 'ng-hide'))]", label));
  }

  public static SelenideElement radioOrCheckBoxContainingLabel(String label, int index) {
    return radioOrCheckBoxContainingLabel(null, label, index);
  }

  public static SelenideElement radioOrCheckBoxContainingLabel(@Nullable SelenideElement wrappingElement, String label, int index) {
    return wrappingElement != null
        ? wrappingElement.$x(format("((.//legend[contains(., '%s')])[1]/..//input[not(contains(@class, 'ng-hide'))])[%s]/ancestor::label[1]", label, index))
        : $x(format("((//legend[contains(., '%s')])[1]/..//input[not(contains(@class, 'ng-hide'))])[%s]/ancestor::label[1]", label, index));
  }

  public static SelenideElement firstRadioOrCheckBoxContainingLabel(String label) {
    return firstRadioOrCheckBoxContainingLabel(null, label);
  }

  public static SelenideElement firstRadioOrCheckBoxContainingLabel(@Nullable SelenideElement wrappingElement, String label) {
    return wrappingElement != null
        ? wrappingElement.$x(format("((.//legend[contains(., '%s')])[1]/..//input[not(contains(@class, 'ng-hide'))])[1]/ancestor::label[1]", label))
        : $x(format("((//legend[contains(., '%s')])[1]/..//input[not(contains(@class, 'ng-hide'))])[1]/ancestor::label[1]", label));
  }
}
