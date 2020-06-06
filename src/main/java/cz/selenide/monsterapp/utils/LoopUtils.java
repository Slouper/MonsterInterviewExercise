package cz.selenide.monsterapp.utils;

import com.codeborne.selenide.Selenide;

public class LoopUtils {

  /**
   * @see LoopUtils#doWhile(Condition, Action, boolean)
   */
  public static void doWhile(Condition condition, Action action) {
    doWhile(condition, action, true);
  }

  /**
   * @param condition - condition to be fulfilled
   * @param action - action that should be done during while cycle
   */
  public static void doWhile(Condition condition, Action action, boolean doBeforeConditionEvaluation) {
    int attempt = 0;
    while (attempt < 5) {
      if (doBeforeConditionEvaluation) {
        action.perform();
      }
      if (condition.evaluate()) {
        break;
      }
      if (!doBeforeConditionEvaluation) {
        action.perform();
      }
      Selenide.sleep(5000);
      attempt++;
    }
  }


  @FunctionalInterface
  public interface Condition {
    boolean evaluate();
  }

  @FunctionalInterface
  public interface Action {
    void perform();
  }
}
