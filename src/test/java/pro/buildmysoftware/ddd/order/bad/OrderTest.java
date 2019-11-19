package pro.buildmysoftware.ddd.order.bad;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {

	@DisplayName("calculate total cost")
	@Test
	void test() throws Exception {
		// given
		Order order = new Order();
		OrderLine tea = new OrderLine();
		tea.setProduct("tea");
		tea.setQuantity(1);
		tea.setUnitPrice(BigDecimal.valueOf(10.00));
		OrderLine coffee = new OrderLine();
		coffee.setUnitPrice(BigDecimal.valueOf(20.00));
		coffee.setQuantity(2);
		coffee.setProduct("coffeee");
		List<OrderLine> lineItems = List.of(tea, coffee);
		order.setLineItems(lineItems);

		// when
		order.setTotalCost(order.getLineItems().stream()
			.map(OrderLine::getUnitPrice).reduce(BigDecimal::add)
			.orElse(BigDecimal.ZERO));

		// then
		assertThat(order.getTotalCost())
			.isEqualTo(BigDecimal.valueOf(50.00));
	}
}
