package promotionservice;

import java.util.ArrayList;
import java.util.List;

class Item {
    String name;
    int price;
    double tax;

    public Item(String name, int price, double tax) {
        this.name = name;
        this.price = price;
        this.tax = tax;
    }
}

public class PromotionService {

    public List<UserMessage> applyPromotionTo(Item item) {
        List<UserMessage> result = new ArrayList<>();
        result.add(new UserMessage("Total before promotion: " + (item.price + item.price * item.tax)));

        item.price -= standardDiscount();
        if (item.price > 122) {
            item.tax /= 2;
        }

        persist(item);

        result.add(new UserMessage("Total after promotion: " + (item.price + item.price * item.tax)));
        return result;
    }

    // This method can't be moved to another class, used by other code in this class.
    private int standardDiscount() {
        return 2;
    }

    private void persist(Item item) {
        // Item is persisted to storage.
    }

    // ... There is more code in this class.

}

