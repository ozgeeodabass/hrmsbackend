package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlama.io.hrms.entities.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService{

	private JobExperienceDao jobExperienceDao;

	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll());
	}


	@Override
	public DataResult<List<JobExperience>> getByCandidateIdByReverseSort(int id) {
		Sort sort = Sort.by(Sort.Direction.DESC, "experienceDate");
		
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(sort));
	}
	

	@Override
	public Result add(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("Job experience added");
		
	}

	@Override
	public Result addAll(List<JobExperience> jobExperiences) {
		for (JobExperience jobExperience : jobExperiences) {
			this.jobExperienceDao.save(jobExperience);
		}
		
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobExperience>> getByCandidateId(int id) {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getAllByCandidate_Id(id));
	}

	@Override
	public DataResult<List<JobExperience>> getByCandidateIdOrderByExperienceStartDate(int id) {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getByCandidate_IdOrderByStartDateDesc(id));
	}

	@Override
	public Result delete(JobExperience jobExperience) {
		this.jobExperienceDao.delete(jobExperience);
		return new SuccessResult("Job experience deleted");
	}

	@Override
	public Result update(JobExperience jobExperience) {
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("Job experience updated");
	}

	@Override
	public DataResult<JobExperience> getById(int id) {
		return new SuccessDataResult<JobExperience>(this.jobExperienceDao.getById(id));
	}

	
	
}
