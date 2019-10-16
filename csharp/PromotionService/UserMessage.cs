namespace Promotionservice
{
	public class UserMessage
	{
		public readonly string value;

		public UserMessage(string value)
		{
			this.value = value;
		}

    public override bool Equals(object obj)
    {
        if (ReferenceEquals(this, obj))
        {
          return true;
        }
        if (ReferenceEquals(null, obj) || obj.GetType() != this.GetType())
        {
          return false;
        }
        var that = (UserMessage) obj;
        return this.value.Equals(that.value);
    }

    public override int GetHashCode()
    {
        return value.GetHashCode();
    }

    public override string ToString()
    {
        return value;
    }

	}
}
