#include <setjmp.h> /* used by cmocka */
#include <stdarg.h> /* used by cmocka */
#include <stddef.h> /* used by cmocka */

#include <cmocka.h>
#include "PromotionService.c"

static void book_promotion(void **state)
{
    (void)state; /* unused */

    struct Item *item = make_item("Functional programming with C++", 10, 0.2);

    const struct UserMessages *messages = apply_promotion_to(item);

    assert_int_equal(2, messages->count);
    assert_string_equal("Total before promotion: 12.0", messages->messages[0]->value);
    assert_string_equal("Total after promotion: 9.6", messages->messages[1]->value);
}

static void expensive_book_promotion(void **state)
{
    (void)state; /* unused */

    struct Item *item = make_item("Functional programming with all languages", 210, 0.2);

    const struct UserMessages *messages = apply_promotion_to(item);

    assert_int_equal(2, messages->count);
    assert_string_equal("Total before promotion: 252.0", messages->messages[0]->value);
    assert_string_equal("Total after promotion: 228.8", messages->messages[1]->value);
}

int main(void)
{
    const struct CMUnitTest test_suite[] = {
        cmocka_unit_test(book_promotion),           /* */
        cmocka_unit_test(expensive_book_promotion), /* */
    };

    return cmocka_run_group_tests(test_suite, NULL, NULL);
}
