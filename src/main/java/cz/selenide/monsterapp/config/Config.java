package cz.selenide.monsterapp.config;

import com.codeborne.selenide.Configuration;

public class Config {
  private static final String MONSTERWORKS_HOMEPAGE_URL = "https://www.monsterworksdemo.com";
  private static final String CHROME_DRIVER_LOCATION = "binaries/chromedriver.exe";

  public static void setupSelenide(Browser browser) {
    System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);
    Configuration.timeout = 30000;
    Configuration.browser = browser.toString();
    Configuration.startMaximized = true;
    Configuration.baseUrl = MONSTERWORKS_HOMEPAGE_URL;
    Configuration.clickViaJs = true;
    Configuration.pageLoadStrategy = "eager";
  }
}
