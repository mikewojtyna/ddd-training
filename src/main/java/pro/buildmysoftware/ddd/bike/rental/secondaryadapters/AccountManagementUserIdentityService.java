package pro.buildmysoftware.ddd.bike.rental.secondaryadapters;

import pro.buildmysoftware.ddd.bike.accountmanagement.UserBlockPolicy;
import pro.buildmysoftware.ddd.bike.accountmanagement.user.UserRepository;
import pro.buildmysoftware.ddd.bike.common.SecondaryAdapter;
import pro.buildmysoftware.ddd.bike.rental.domain.station.User;
import pro.buildmysoftware.ddd.bike.rental.secondaryports.UserId;
import pro.buildmysoftware.ddd.bike.rental.secondaryports.UserIdentityService;

import java.util.Optional;

@SecondaryAdapter
public class AccountManagementUserIdentityService implements UserIdentityService {

	// This might not be the best idea, generally speaking we should try
	// not to couple different contexts too much. However, sometimes one
	// context provides its api to others (using e.g. public API and
	// published language).
	// TODO: think about better design
	private UserRepository userRepository;
	private UserBlockPolicy userBlockPolicy;

	@Override
	public Optional<User> findUser(UserId userId) {
		return userRepository
			.findById(pro.buildmysoftware.ddd.bike.accountmanagement.user.UserId
				.valueOf(userId.getValue()))
			.map(accountUser -> new User(userBlockPolicy
				.decideWhetherToBlock(accountUser)));
	}
}
