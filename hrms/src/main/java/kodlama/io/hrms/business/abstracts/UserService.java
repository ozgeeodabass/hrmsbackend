package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.entities.User;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;

public interface UserService {

	DataResult<User> getByEmail(String email);
	Result add(User user);
	
}
