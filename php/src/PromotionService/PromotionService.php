<?php
namespace PromotionService;

class Item
{
    public $name;
    public $price;
    public $tax;

    public function __construct($name, $price, $tax)
    {
        $this->name = $name;
        $this->price = $price;
        $this->tax = $tax;
    }
}

class PromotionService
{

    public function applyPromotionTo(Item $item)
    {
        $result = [];
        $result[] = new UserMessage(sprintf("Total before promotion: %.1F", $item->price + $item->price * $item->tax));

        $item->price -= $this->standardDiscount();
        if ($item->price > 122) {
            $item->tax /= 2;
        }

        $this->persist($item);

        $result[] = new UserMessage(sprintf("Total after promotion: %.1F", $item->price + $item->price * $item->tax));
        return $result;
    }

    // This method can't be moved to another class, used by other code in this class.
    private function standardDiscount()
    {
        return 2;
    }

    private function persist(Item $item)
    {
        // Item is persisted to storage.
    }

    // ... There is more code in this class.
}
