package kodlama.io.hrms.core.utilities.adapters.mernis;

import java.time.LocalDate;

public interface UserCheckService {
	
	boolean checkUser(long nationalityId, String firstName, String lastName,LocalDate dateOfBirth);

}
