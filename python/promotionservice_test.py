import unittest

from hamcrest import *
from message import UserMessage
from promotionservice import PromotionService, Item


class PromotionServiceTestTestCase(unittest.TestCase):
    def test_book_promotion(self):
        messages = PromotionService().apply_promotion_to(
            Item("Functional programming with C++", 10, 0.2))

        assert_that(messages, equal_to([
            UserMessage("Total before promotion: 12.0"),
            UserMessage("Total after promotion: 9.6")
        ]))

    def test_expensive_book_promotion(self):
        messages = PromotionService().apply_promotion_to(
            Item("Functional programming with all languages", 210, 0.2))

        assert_that(messages, equal_to([
            UserMessage("Total before promotion: 252.0"),
            UserMessage("Total after promotion: 228.8")
        ]))


if __name__ == "__main__":
    unittest.main()
