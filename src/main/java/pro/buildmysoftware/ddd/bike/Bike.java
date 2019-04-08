package pro.buildmysoftware.ddd.bike;

public class Bike {

	public BikeRent rentBy(User user) {
		if (user.funds() >= 5) {
			return new BikeRent(20);
		}
		throw new CannotRentABike("EX_INSUFFICIENT_FUNDS");
	}

}
