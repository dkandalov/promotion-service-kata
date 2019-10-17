class UserMessage(object):
    def __init__(self, value):
        self._value = value

    def __eq__(self, other):
        if isinstance(other, self.__class__):
            return self._value == other._value
        else:
            return False

    def __hash__(self):
        return self._value.__hash__()

    def __str__(self):
        return self._value
