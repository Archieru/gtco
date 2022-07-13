import com.codeborne.selenide.CollectionCondition.size
import org.junit.jupiter.api.Test
import pages.CtcoMainPage
import pages.VacanciesPage

class CtcoTest {
    @Test
    fun shouldHaveCorrectSkillCount() {
        CtcoMainPage()
            .open()
            .topMenu
                .hoverSection("Careers")
                .submenuSelect("Vacancies")

        VacanciesPage()
            .switchToVacancy("TEST AUTOMATION ENGINEER")
            .getParagraphListForVacancy(
                "TEST AUTOMATION ENGINEER",
                "Professional skills and qualification"
            )
            .shouldHave(size(8))
    }
}