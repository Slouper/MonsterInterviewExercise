package cz.selenide.monsterapp.base;

import static java.lang.String.format;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbstractStep {
  private final Logger LOG = LogManager.getLogger(this.getClass());

  @SuppressWarnings("SameParameterValue" /* General function for logging steps on Step classes */)
  protected void logStep(String stepDescription, Object... args) {
    LOG.info("     STEP: {}", format(stepDescription, args));
  }
}
