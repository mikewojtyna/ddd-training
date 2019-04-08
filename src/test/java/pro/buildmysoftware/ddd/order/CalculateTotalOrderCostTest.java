package pro.buildmysoftware.ddd.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTotalOrderCostTest {
	@DisplayName("should calcualate total cost of all parts")
	@Test
	void test() throws Exception {
		// given
		Order order = new Order();
		OrderLine tea = new OrderLine("tea", 10, 5);
		OrderLine coffee = new OrderLine("coffee", 1, 20);
		order.addItem(tea);
		order.addItem(coffee);

		// when
		int totalCost = order.totalCost();

		// then
		assertThat(totalCost).isEqualTo(70);
	}
}
