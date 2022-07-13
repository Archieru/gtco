package pages

import BaseSelenideActions
import com.codeborne.selenide.Selenide
import components.TopMenuComponent

class CtcoMainPage : BaseSelenideActions() {
    val topMenu = TopMenuComponent("#menu-main")

    fun open(): CtcoMainPage {
        Selenide.open("https://ctco.lv/")
        return this
    }
}