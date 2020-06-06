package cz.selenide.monsterapp.pageobject.base

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement

fun SelenideElement.performClick() {
    this.should(Condition.exist)
    this.should(Condition.appear)
    this.click()
}