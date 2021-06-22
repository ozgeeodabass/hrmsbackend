package kodlama.io.hrms.business.abstracts;
import kodlama.io.hrms.entities.School;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;

public interface SchoolService {

	DataResult<List<School>> getAll();
	DataResult<List<School>> getSchoolsByReverseSort(int id);
	DataResult<School> getById(int id);
	Result add(School school);
	
	
	
	
}
