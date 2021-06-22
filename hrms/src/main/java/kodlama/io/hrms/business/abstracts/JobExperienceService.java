package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.JobExperience;

public interface JobExperienceService {

	
	DataResult<List<JobExperience>> getAll();
	DataResult<List<JobExperience>> getExperiencesByReverseSort(int id);
	DataResult<JobExperience> getById(int id);
	Result add(JobExperience jobExperience);
}
