package pro.buildmysoftware.ddd.bike.accountmanagement;

import pro.buildmysoftware.ddd.bike.accountmanagement.user.User;
import pro.buildmysoftware.ddd.bike.common.DomainService;

@DomainService
public interface UserBlockPolicy {

	boolean decideWhetherToBlock(User user);
}
