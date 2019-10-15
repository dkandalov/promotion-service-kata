@file:Suppress("MemberVisibilityCanBePrivate")

package promotionservice

import java.util.ArrayList

class Item(
    val name: String,
    var price: Int,
    var tax: Double
)

data class UserMessage(val value: String)

class PromotionService {

    fun applyPromotionTo(item: Item): List<UserMessage> {
        val result = ArrayList<UserMessage>()
        result += UserMessage("Total before promotion: ${item.price + item.price * item.tax}")

        item.price -= standardDiscount()
        if (item.price > 122) {
            item.tax /= 2
        }

        result += UserMessage("Total after promotion: ${item.price + item.price * item.tax}")
        return result
    }

    // Can't be moved to another class, used by other code.
    fun standardDiscount() = 2
}
