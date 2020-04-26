package pro.buildmysoftware.ddd.order.domain;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {

	// @formatter:off
	@DisplayName(
	        "given an empty order, " +
	        "when calculate total cost, " +
	        "then calculated cost is zero USD"
	)
	//@formatter:on
	@Test
	void emptyOrderTest() throws Exception {
		// given
		Order order = emptyOrder();

		// when
		Money totalCost = order.calculateTotalCost();

		// then
		assertThat(totalCost).isEqualTo(zeroUsd());
	}

	// @formatter:off
	@DisplayName(
	        "given an empty order, " +
	        "when add 'tea' with unit price $5 and quantity 1 to the " +
		"order, " +
	        "then total cost is $5"
	)
	//@formatter:on
	@Test
	void addItem() throws Exception {
		// given
		Order order = emptyOrder();
		Product tea = teaOfPriceInUsd(5);

		// when
		order.add(tea);

		// then
		assertThat(order.calculateTotalCost()).isEqualTo(usd(5));
	}

	private Money usd(int amount) {
		return Money.of(CurrencyUnit.USD, amount);
	}

	private Product teaOfPriceInUsd(int unitPrice) {
		return new Product(usd(unitPrice));
	}

	private Money zeroUsd() {
		return Money.zero(CurrencyUnit.USD);
	}

	private Order emptyOrder() {
		return new Order();
	}
}
