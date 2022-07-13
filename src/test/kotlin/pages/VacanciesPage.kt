package pages

import BaseSelenideActions
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide
import org.openqa.selenium.By

class VacanciesPage: BaseSelenideActions() {
    fun switchToVacancy(vacancyName: String): VacanciesPage {
        textWithSelector(vacancyName, ".menu-main-container a.menu-link").click()
        return this
    }

    fun getParagraphListForVacancy(vacancyName: String, paragraphName: String): ElementsCollection {
        return Selenide.elements(By.xpath(
            "//*[contains(text(),'$vacancyName')]" +          // find the vacancy title
                    "/ancestor::div[contains(@class, 'vacancies-second-contents') " +
                    "and contains(@class, 'active')]" +                     // get the vacancy text for the title
                    "//*[contains(text(), '$paragraphName')]/ancestor::p" + // find the required paragraph
                    "/following-sibling::ul[1]/li"                          // get the list of requirements in paragraph
            )
        )
    }
}