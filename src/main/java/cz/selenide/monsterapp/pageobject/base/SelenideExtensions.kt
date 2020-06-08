package cz.selenide.monsterapp.pageobject.base

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.JavascriptExecutor

fun SelenideElement.performClick() {
    performClick(true)
}

fun SelenideElement.performClick(viaJavascript: Boolean) {
    this.should(Condition.exist)
    this.should(Condition.appear)

    if (viaJavascript) {
        javaScriptClick()
    } else {
        this.click()
    }
}

private fun SelenideElement.javaScriptClick() {
    (this.wrappedDriver as JavascriptExecutor).executeScript("arguments[0].click();", this)
}