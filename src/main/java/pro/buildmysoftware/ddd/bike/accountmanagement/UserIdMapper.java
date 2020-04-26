package pro.buildmysoftware.ddd.bike.accountmanagement;

import pro.buildmysoftware.ddd.bike.accountmanagement.user.UserId;

public interface UserIdMapper {

	UserId from(pro.buildmysoftware.ddd.bike.rental.secondaryports.UserId rentalUserId);
}
