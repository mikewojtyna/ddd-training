package pro.buildmysoftware.ddd.bike.accountmanagement.user;


import java.util.Optional;

public interface UserRepository {

	Optional<User> findById(UserId userId);

	void save(User user);
}
