package promotionservice

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class PromotionServiceTests {

    @Test fun `Book promotion`() {
        val messages = PromotionService().applyPromotionTo(
            Item(
                name = "Functional programming with C++",
                price = 10,
                tax = 0.2
            )
        )
        assertThat(messages, equalTo(listOf(
            Message("Total before promotion: 12.0"),
            Message("Total after promotion: 9.6")
        )))
    }

    @Test fun `Massive Book promotion`() {
        val messages = PromotionService().applyPromotionTo(
            Item(
                name = "Functional programming with Groovy",
                price = 210,
                tax = 0.2
            )
        )
        assertThat(messages, equalTo(listOf(
            Message("Total before promotion: 252.0"),
            Message("Total after promotion: 228.8")
        )))
    }
}