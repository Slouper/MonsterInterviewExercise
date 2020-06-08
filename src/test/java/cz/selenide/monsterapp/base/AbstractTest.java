package cz.selenide.monsterapp.base;

import static cz.selenide.monsterapp.config.Browser.CHROME;
import static java.lang.String.format;

import cz.selenide.monsterapp.config.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

public class AbstractTest {
  private final Logger LOG = LogManager.getLogger(this.getClass());

  @BeforeClass
  public void setupSelenide() {
    Config.setupSelenide(CHROME);
  }

  protected void logStep(String stepDescription, Object... args) {
    LOG.info("     STEP: {}", format(stepDescription, args));
  }
}
