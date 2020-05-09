#include "UserMessage.h"
#include <assert.h>
#include <stdlib.h>

const struct UserMessage *make_user_message(const char *value)
{
    struct UserMessage *this = (struct UserMessage *)malloc(sizeof(struct UserMessage));
    this->value = value;
    return this;
}

struct UserMessages *make_user_messages()
{
    struct UserMessages *this = (struct UserMessages *)malloc(sizeof(struct UserMessages));
    this->count = 0;
    for (unsigned int i = 0; i < MAX_MESSAGES; i++)
    {
        this->messages[i] = NULL;
    }
    return this;
}

void user_messages_add(struct UserMessages *this, const struct UserMessage *message)
{
    this->messages[this->count++] = message;
    assert(this->count <= 10);
}
