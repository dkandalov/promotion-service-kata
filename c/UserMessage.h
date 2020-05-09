#ifndef MAX_MESSAGES

#define MAX_MESSAGES 10

struct UserMessage
{
    const char *value;
};

struct UserMessages
{
    int count;
    const struct UserMessage *messages[MAX_MESSAGES];
};

#endif

extern const struct UserMessage *make_user_message(const char *value);
extern struct UserMessages *make_user_messages();
extern void user_messages_add(struct UserMessages *this, const struct UserMessage *message);
