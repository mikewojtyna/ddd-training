package pro.buildmysoftware.ddd.order.good;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

public class OrderTest {

	@DisplayName("can create order with single item")
	@Test
	void test() throws Exception {
		// given
		Order order = emptyOrder();
		Item item = anyItem();
		order.addItem(item);

		// when
		Collection<Item> items = order.items();

		// then
		assertThat(items).hasSize(1);
	}

	// @formatter:off
	@DisplayName(
		"given empty order, " +
		"when add single item of price 10.00 USD, " +
		"then total cost is 10.00 USD"
	)
	// @formatter:on
	@Test
	void test1() throws Exception {
		// given
		Order order = emptyOrder();
		Item item = itemOfPrice(10.00);

		// when
		order.addItem(item);

		// then
		assertThat(order.totalCost()).isEqualTo(usd(10.00));
	}

	// @formatter:off
	@DisplayName(
		"given empty order, " +
		"when add two items of price 10.00 and 20.00 USD, " +
		"then total cost is 30.00 USD"
	)
	// @formatter:on
	@Test
	void test2() throws Exception {
		// given
		Order order = emptyOrder();
		Item firstItem = itemOfPrice(10.00);
		Item secondItem = itemOfPrice(20.00);

		// when
		order.addItem(firstItem);
		order.addItem(secondItem);

		// then
		assertThat(order.totalCost()).isEqualTo(usd(30.00));
	}

	// @formatter:off
	@DisplayName(
		"given empty order with max limit 1000.00 USD, " +
		"when add item with cost 1001.00 USD, " +
		"then operation fails"
	)
	// @formatter:on
	@Test
	void test4() throws Exception {
		// given
		Order order = emptyOrderWithMaxLimit(1000.00);
		Item item = itemOfPrice(1001.00);

		// when
		MaxLimitExceededException ex = catchThrowableOfType(() -> order
			.addItem(item), MaxLimitExceededException.class);

		// then
		assertThat(ex).isNotNull();
	}

	private Order emptyOrderWithMaxLimit(double amount) {
		return Order.limited(BigDecimal.valueOf(amount));
	}

	private BigDecimal usd(double amount) {
		return BigDecimal.valueOf(amount);
	}

	private Item itemOfPrice(double price) {
		return new Item(BigDecimal.valueOf(price));
	}

	private Order emptyOrder() {
		return new Order();
	}

	private Item anyItem() {
		return new Item(defaultPrice());
	}

	private BigDecimal defaultPrice() {
		return BigDecimal.valueOf(100.00);
	}
}
