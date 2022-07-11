import com.codeborne.selenide.CollectionCondition.size
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.Selenide.elements
import com.codeborne.selenide.SelenideElement
import org.junit.jupiter.api.Test
import org.openqa.selenium.By

class CtcoTest {
    @Test
    fun shouldHaveCorrectSkillCount() {
        fun textWithSelector(text: String, selector: String): SelenideElement = `$$`(selector).findBy(text(text))

        Selenide.open("https://ctco.lv/")
        textWithSelector("Careers", "#menu-main>li>a").hover()
        textWithSelector("Vacancies", ".sub-menu>li>a").click()
        textWithSelector("TEST AUTOMATION ENGINEER", ".menu-main-container a.menu-link").click()

        elements(By.xpath("//*[text()='TEST AUTOMATION ENGINEER vacancy']" +                        // find the vacancy title
                "/ancestor::div[contains(@class, 'vacancies-second-contents') and contains(@class, 'active')]" +  // get the vacancy text for the title
                "//*[text()='Professional skills and qualification:']/ancestor::p" +                              // find the required paragraph
                "/following-sibling::ul[1]/li")).shouldHave(size(8))                                  // check the list after the paragraph
    }
}