package components

import BaseSelenideActions

class TopMenuComponent(baseSelector: String): BaseSelenideActions(baseSelector) {
    fun hoverSection(sectionName: String): TopMenuComponent {
        textWithSelector(sectionName, ">li>a").hover()
        return this
    }

    fun submenuSelect(menuItem: String) {
        textWithSelector(menuItem, " .sub-menu>li>a").click()
    }
}