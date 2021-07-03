package kodlama.io.hrms.business.abstracts;
import kodlama.io.hrms.entities.School;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;

public interface SchoolService {
	
	Result add(School school);
	
	Result addAll(List<School> schools);
	
	Result delete(School school);
	
	Result update(School school);
	
	DataResult<List<School>> getAllByCandidateId(int id);
	
	DataResult<School> getById(int id);
	
	DataResult<List<School>> getByCandidateIdOrderByGraduationYear(int candidateId);
	
	
	
}
