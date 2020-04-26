package pro.buildmysoftware.ddd.order.anemic;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.List;
import java.util.UUID;

public class OrderService {

	public void calculateTotalCost(UUID id) {
		Order order = getOrder(id);
		List<Product> products = order.getProducts();
		Money totalCost = products.stream()
			.map(product -> product.getPrice()
				.multipliedBy(product.getQuantity()))
			.reduce((acc, curr) -> acc.plus(curr))
			.orElse(Money.zero(CurrencyUnit.EUR));
		order.setTotalCost(totalCost);
		save(order);
	}

	private void save(Order order) {
		// TODO: save to db
	}

	private Order getOrder(UUID id) {
		// TODO: fake access to db
		return null;
	}
}
