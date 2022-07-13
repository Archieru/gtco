import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement

open class BaseSelenideActions(val baseSelector: String = "") {
    fun textWithSelector(text: String, selector: String): SelenideElement {
        return Selenide.`$$`(baseSelector+selector).findBy(Condition.text(text))
    }
}