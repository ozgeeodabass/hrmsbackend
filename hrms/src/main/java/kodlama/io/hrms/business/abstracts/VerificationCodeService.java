package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.VerificationCode;

public interface VerificationCodeService {
	
	Result add(VerificationCode code);
	
	Result update(VerificationCode code);
	
	Result delete(VerificationCode code);
	
	DataResult<VerificationCode> getByUserIdAndVerificationCode(int userId, String verificationCode);
	

}
