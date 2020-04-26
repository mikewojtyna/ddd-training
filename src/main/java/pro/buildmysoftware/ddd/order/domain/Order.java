package pro.buildmysoftware.ddd.order.domain;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class Order {

	private Money currentCost;

	public Order() {
		currentCost = Money.zero(CurrencyUnit.USD);
	}

	public Money calculateTotalCost() {

		return currentCost;
	}

	public void add(Product tea) {
		currentCost = currentCost.plus(tea.getUnitPrice());
	}
}
