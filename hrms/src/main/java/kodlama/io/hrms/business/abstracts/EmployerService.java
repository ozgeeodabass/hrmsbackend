package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.Employer;

public interface EmployerService {
	
	Result add(Employer employer);
	
	Result delete(Employer employer);
	
	Result update(Employer employer);
	
	DataResult<List<Employer>> getAll();
	
	DataResult<Employer> getById(int id);
	
	DataResult<Employer> getByEmail(String email);
	
	

}
