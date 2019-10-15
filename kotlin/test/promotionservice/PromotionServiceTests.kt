package promotionservice

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class PromotionServiceTests {

    @Test
    fun `Book promotion`() {
        val messages = PromotionService().applyPromotionTo(
            Item(
                name = "Functional programming with C++",
                price = 10,
                tax = 0.2
            )
        )
        assertThat(messages, equalTo(listOf(
            UserMessage("Total before promotion: 12.0"),
            UserMessage("Total after promotion: 9.6")
        )))
    }

    @Test
    fun `Expensive book promotion`() {
        val messages = PromotionService().applyPromotionTo(
            Item(
                name = "Functional programming with all languages",
                price = 210,
                tax = 0.2
            )
        )
        assertThat(messages, equalTo(listOf(
            UserMessage("Total before promotion: 252.0"),
            UserMessage("Total after promotion: 228.8")
        )))
    }
}
