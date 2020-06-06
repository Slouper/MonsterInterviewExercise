package cz.selenide.monsterapp.pageobject.base;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

import com.codeborne.selenide.SelenideElement;

public class Selector {

  public static SelenideElement firstInputContainingLabel(String label) {
    return $x(format("(//label[contains(., '%s')])[1]/following-sibling::*/input[not(contains(@class, 'ng-hide'))]", label));
  }

  public static SelenideElement firstSelectContainingLabel(String label) {
    return $x(format("(//label[contains(., '%s')])[1]/following-sibling::*/select[not(contains(@class, 'ng-hide'))]", label));
  }

  public static SelenideElement radioOrCheckBoxContainingLabel(String label, int index) {
    return $x(format("((//legend[contains(., '%s')])[1]/..//input[not(contains(@class, 'ng-hide'))])[%s]/ancestor::label[1]", label, index));
  }

  public static SelenideElement firstRadioOrCheckBoxContainingLabel(String label) {
    return $x(format("((//legend[contains(., '%s')])[1]/..//input[not(contains(@class, 'ng-hide'))])[1]/ancestor::label[1]", label));
  }
}
