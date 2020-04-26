package pro.buildmysoftware.ddd.bike.rental.secondaryports;

import pro.buildmysoftware.ddd.bike.common.SecondaryPort;
import pro.buildmysoftware.ddd.bike.rental.domain.station.User;

import java.util.Optional;

@SecondaryPort
public interface UserIdentityService {

	Optional<User> findUser(UserId userId);
}
