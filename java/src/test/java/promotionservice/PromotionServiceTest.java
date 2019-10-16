package promotionservice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

class PromotionServiceTest {

    @Test
    void bookPromotion() {
        List<UserMessage> messages = new PromotionService().applyPromotionTo(
            new Item(
                "Functional programming with C++",
                10,
                0.2
            )
        );
        assertThat(messages, equalTo(Arrays.asList(
            new UserMessage("Total before promotion: 12.0"),
            new UserMessage("Total after promotion: 9.6")
        )));
    }

    @Test
    void expensiveBookPromotion() {
        List<UserMessage> messages = new PromotionService().applyPromotionTo(
            new Item(
                "Functional programming with all languages",
                210,
                0.2
            )
        );
        assertThat(messages, equalTo(Arrays.asList(
            new UserMessage("Total before promotion: 252.0"),
            new UserMessage("Total after promotion: 228.8")
        )));
    }
}
