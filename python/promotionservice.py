from message import UserMessage


class Item(object):
    def __init__(self, name, price, tax):
        self.name = name
        self.price = price
        self.tax = tax


class PromotionService(object):
    def apply_promotion_to(self, item):
        result = []
        result.append(UserMessage("Total before promotion: {0:.1f}".format(item.price + item.price * item.tax)))

        item.price -= self._standard_discount()
        if item.price > 122:
            item.tax /= 2

        self._persist(item)

        result.append(UserMessage("Total after promotion: {0:.1f}".format(item.price + item.price * item.tax)))
        return result

    # This method can't be moved to another class, used by other code in this class.
    def _standard_discount(self):
        return 2

    def _persist(self, item):
        # Item is persisted to storage.
        pass

    # ... There is more code in this class.
