package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.JobExperience;

public interface JobExperienceService {

	Result add(JobExperience jobExperience);
	
	Result delete(JobExperience jobExperience);
	
	Result update(JobExperience jobExperience);
	
	Result addAll(List<JobExperience> jobExperiences);
	
	DataResult<List<JobExperience>> getAll();
	
	DataResult<List<JobExperience>> getByCandidateIdByReverseSort(int candidateId);
	
	DataResult<JobExperience> getById(int id);
	
	DataResult<List<JobExperience>> getByCandidateId(int id);
	
	DataResult<List<JobExperience>> getByCandidateIdOrderByExperienceStartDate(int id);
	
}
