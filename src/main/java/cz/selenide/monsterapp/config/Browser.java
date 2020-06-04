package cz.selenide.monsterapp.config;

public enum Browser {
  CHROME("chrome");

  private final String browserName;

  Browser(String browseName) {
    this.browserName = browseName;
  }

  @Override
  public String toString() {
    return this.browserName;
  }
}
