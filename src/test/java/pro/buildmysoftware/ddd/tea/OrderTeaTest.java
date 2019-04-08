package pro.buildmysoftware.ddd.tea;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTeaTest {
	// @formatter:off
	@DisplayName(
		"when customer submits order with chosen tea, then order is " +
		"placed"
	)
	// @formatter:on
	@Test
	void test() throws Exception {
		// given
		Order order = prepareOrder();
		Tea blackTea = blackTea();
		Tea greenTea = greenTea();
		order.chooseTea(blackTea, greenTea);

		// when
		order.submit();

		// then
		assertThat(order.isPlaced()).isTrue();
	}

	// @formatter:off
	@DisplayName(
		"when customer submits empty order, then order is not placed"
	)
	// @formatter:on
	@Test
	void test1() throws Exception {
		// given
		Order emptyOrder = emptyOrder();

		// when
		emptyOrder.submit();

		// then
		assertThat(emptyOrder.isPlaced()).isFalse();
	}

	private Order emptyOrder() {
		return new Order();
	}

	private Order prepareOrder() {
		return new Order();
	}

	private Tea greenTea() {
		return new Tea("green");
	}

	private Tea blackTea() {
		return new Tea("black");
	}
}
