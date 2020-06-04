package cz.selenide.monsterapp.base;

import static cz.selenide.monsterapp.config.Browser.CHROME;

import cz.selenide.monsterapp.config.Config;
import org.testng.annotations.BeforeClass;

public class AbstractTest {

  @BeforeClass
  public static void setupSelenide() {
    Config.setupSelenide(CHROME);
  }
}
