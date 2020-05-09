#include "UserMessage.h"
#include <stdlib.h>
#include <stdio.h>

struct Item
{
    char *name;
    int price;
    double tax;
};

struct Item *make_item(char *name, int price, double tax)
{
    struct Item *this = (struct Item *)malloc(sizeof(struct Item));
    this->name = name;
    this->price = price;
    this->tax = tax;
    return this;
}

const struct UserMessages *apply_promotion_to(struct Item *item)
{
    int standard_discount();
    void persist(const struct Item *item);

    struct UserMessages *result = make_user_messages();
    char *s = (char *)malloc(sizeof(char[24 + 6 + 1]));
    sprintf(s, "Total before promotion: %.1f", (item->price + item->price * item->tax));
    user_messages_add(result, make_user_message(s));

    item->price -= standard_discount();
    if (item->price > 122)
    {
        item->tax /= 2;
    }

    persist(item);

    s = (char *)malloc(sizeof(char[23 + 6 + 1]));
    sprintf(s, "Total after promotion: %.1f", (item->price + item->price * item->tax));
    user_messages_add(result, make_user_message(s));
    return result;
}

/* This method can't be moved to another class, used by other code in this class. */
int standard_discount(void)
{
    return 2;
}

void persist(const struct Item *item)
{
    /* Item is persisted to storage. */
}

/* ... There is more code in this module. */
