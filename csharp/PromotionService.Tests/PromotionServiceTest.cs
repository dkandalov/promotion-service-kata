using System.Collections.Generic;
using NHamcrest;
using NHamcrest.XUnit;

namespace PromotionService.Tests
{
	public class PromotionServiceTest
	{
        [Xunit.Fact]
		public void BookPromotion()
		{
			var messages = new PromotionService().ApplyPromotionTo(
				new Item("Functional programming with C++", 10, 0.2));
			Assert.That(messages, Is.ListOf(
				Is.EqualTo(new UserMessage("Total before promotion: 12.0")),
				Is.EqualTo(new UserMessage("Total after promotion: 9.6"))
			));
		}

        [Xunit.Fact]
		public void ExpensiveBookPromotion()
		{
			var messages = new PromotionService().ApplyPromotionTo(
				new Item("Functional programming with all languages", 210, 0.2));
			Assert.That(messages, Is.ListOf(
				Is.EqualTo(new UserMessage("Total before promotion: 252.0")),
				Is.EqualTo(new UserMessage("Total after promotion: 228.8"))
			));
		}
	}
}
