<?php
namespace PromotionService;

class PromotionServiceTest extends \PHPUnit_Framework_TestCase
{

    /** @test */
    public function bookPromotion()
    {
        $promotionService = new PromotionService();
        $messages = $promotionService->applyPromotionTo(
            new Item("Functional programming with C++", 10, 0.2));

        assertThat($messages, equalTo([
            new UserMessage("Total before promotion: 12.0"),
            new UserMessage("Total after promotion: 9.6"),
        ]));
    }

    /** @test */
    public function expensiveBookPromotion()
    {
        $promotionService = new PromotionService();
        $messages = $promotionService->applyPromotionTo(
            new Item("Functional programming with all languages", 210, 0.2));

        assertThat($messages, equalTo([
            new UserMessage("Total before promotion: 252.0"),
            new UserMessage("Total after promotion: 228.8"),
        ]));
    }

}
