package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.VerificationCodeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlama.io.hrms.entities.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {
	
	private VerificationCodeDao codeDao;

	@Autowired
	public VerificationCodeManager(VerificationCodeDao codeDao) {
		super();
		this.codeDao = codeDao;
	}

	@Override
	public Result add(VerificationCode code) {
		this.codeDao.save(code);
		return new SuccessResult();
	}

	@Override
	public Result update(VerificationCode code) {
		this.codeDao.save(code);
		return new SuccessResult();
	}

	@Override
	public Result delete(VerificationCode code) {
		this.codeDao.delete(code);
		return new SuccessResult();
	}

	@Override
	public DataResult<VerificationCode> getByUserIdAndVerificationCode(int userId, String verificationCode) {
		return new SuccessDataResult<VerificationCode>(this.codeDao.findByUserIdAndVerificationCode(userId, verificationCode));
	};
	
	
	
	

}
