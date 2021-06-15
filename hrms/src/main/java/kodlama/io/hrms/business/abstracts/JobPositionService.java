package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.JobPosition;

public interface JobPositionService {
	
	DataResult<List<JobPosition>> gettAll();
	DataResult<JobPosition> getByTitle(String title);
	Result add(JobPosition position);
	
	
	
}
