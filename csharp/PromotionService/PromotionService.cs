using System;
using System.Collections.Generic;
using System.Globalization;

namespace Promotionservice
{
	public class Item
	{
		public string name;

		public int price;

		public double tax;

		public Item(string name, int price, double tax)
		{
			this.name = name;
			this.price = price;
			this.tax = tax;
		}
	}

	public class PromotionService
	{
		public virtual IList<UserMessage> ApplyPromotionTo(Item item)
		{
			var result = new List<UserMessage>();
			result.Add(new UserMessage(String.Format(CultureInfo.InvariantCulture, "Total before promotion: {0:F1}", item.price + item.price * item.tax)));

			item.price -= StandardDiscount();
			if (item.price > 122)
			{
				item.tax /= 2.0;
			}

			Persist(item);

			result.Add(new UserMessage(String.Format(CultureInfo.InvariantCulture, "Total after promotion: {0:F1}", item.price + item.price * item.tax)));
			return result;
		}

		// This method can't be moved to another class, used by other code in this class.
		private int StandardDiscount()
		{
			return 2;
		}

		private void Persist(Item item)
		{
			// Item is persisted to storage.
		}

		// ... There is more code in this class.
	}
}
