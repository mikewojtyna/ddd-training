package pro.buildmysoftware.ddd.order.anemic;

import lombok.Data;
import org.joda.money.Money;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Data
public class Order {

	@Id
	@GeneratedValue
	private UUID id;
	private Money totalCost;
	@OneToMany
	private List<Product> products;
	private Money maxTotalCost;
}
