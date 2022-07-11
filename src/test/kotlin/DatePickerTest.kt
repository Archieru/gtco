import kotlin.test.assertEquals
import kotlin.test.fail

class DatePickerTest {
    fun datePicker(yyyy: Int, mm: Int? = null, dd: Int? = null): String {
        return "2022-07-13" // today
    }

    fun illegalFormatTest(message: String, function: () ->  Any) {
        try {
            function.invoke()
            fail(message)
        } catch (_: IllegalArgumentException) {}
    }

    //    @Test
    fun exactDateTest() {
        assertEquals(datePicker(2015, 5, 20), "2015-05-20", "Exact date should e represented correctly")
        assertEquals(datePicker(2025, 10, 2), "2025-10-02", "Exact date should e represented correctly")
        assertEquals(datePicker(2016, 2, 29), "2016-02-29", "Should have Feb29 on leap year")

        illegalFormatTest("Should not have a month 0") { datePicker(2023, 0, 14) }
        illegalFormatTest("Should not have a month more than 12") { datePicker(2023, 13, 14) }
        illegalFormatTest("Should not have a date 0") { datePicker(2023, 11, 0) }
        illegalFormatTest("Should not have a date more than 31") { datePicker(2023, 11, 32) }
        illegalFormatTest("Should not have a date more than 30 in June") { datePicker(2023, 6, 31) }
        illegalFormatTest("Should not have a date more than 28 in Feb") { datePicker(2023, 2, 29) }
        illegalFormatTest("Should not have a date more than 29 in leap Feb") { datePicker(2023, 2, 30) }
    }

    //    @Test
    fun yearAndMonthTest() {
        assertEquals(datePicker(2022, 7), "2022-07-13", "Current year + current month should return today's date")
        assertEquals(datePicker(2022, 6), "2022-06-15", "Current year + previous month should return 15th date")
        assertEquals(datePicker(2022, 3), "2022-03-15", "Current year + previous n months should return 15th date")
        assertEquals(datePicker(2022, 9), "2022-09-15", "Current year + future month should return 15th date")
        assertEquals(datePicker(2021, 7), "2021-07-15", "Previous year + any month should return 15th date")
        assertEquals(datePicker(2019, 9), "2019-09-15", "Previous n years + any month should return 15th date")
        assertEquals(datePicker(2023, 7), "2023-07-15", "Future year + any month should return 15th date")

        illegalFormatTest("Should not have a month 0") { datePicker(2023, 0) }
        illegalFormatTest("Should not have a month more than 12") { datePicker(2023, 13) }
    }

    //    @Test
    fun yearOnlyTest() {
        assertEquals(datePicker(2022), "2022-04-07", "Half of the period passed from the start of the year till today's date")
        assertEquals(datePicker(2021), "2021-12-31", "Previous year should return Dec31")
        assertEquals(datePicker(2019), "2019-06-30", "Previous n years should return Jun30")
        assertEquals(datePicker(2023), "2023-06-30", "Future year should return Jun30")
    }
}