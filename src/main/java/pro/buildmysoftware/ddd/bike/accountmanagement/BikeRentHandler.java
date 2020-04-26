package pro.buildmysoftware.ddd.bike.accountmanagement;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pro.buildmysoftware.ddd.bike.accountmanagement.user.UserRepository;
import pro.buildmysoftware.ddd.bike.rental.domain.station.BikeRent;

@Component
public class BikeRentHandler {

	private UserIdMapper userIdMapper;
	private UserRepository userRepository;

	@EventListener
	public void handle(BikeRent bikeRent) {
		userRepository.findById(userIdMapper.from(bikeRent.getUserId()))
			.ifPresent(user -> {
				user.updateHistory(bikeRent);
				userRepository.save(user);
			});
	}
}
