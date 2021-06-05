package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.Employer;


public interface EmployerService {

	DataResult<List<Employer>> gettAll();
	DataResult<Employer> getById(int id);
	Result add(Employer employer);
	Result delete(int id);
	Result update(Employer employer);
	DataResult<Employer> getEmployerByNationalalityId(String nationalityId);
	Result register(Employer employer);
	boolean checkPasswordIsTrue(Employer employer);
	Result existWithEmail(String eMail);
}
