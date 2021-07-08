package kodlama.io.hrms.business.concretes;

import java.time.LocalDate;
import org.springframework.data.domain.Sort;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.hrms.entities.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		
		return new SuccessResult("Job Advertisement added !");  
	
	}
	
	
	@Override
	public DataResult<List<JobAdvertisement>> getByIsActive() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActive(),"All active advertisement listed !");
		
	}

	
	@Override
	public DataResult<List<JobAdvertisement>> getAllSortedByReleaseDate() {
	
		Sort sort = Sort.by(Sort.Direction.DESC,"appealDeadline");
				
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort));
		
	}
	

	@Override
	public DataResult<List<JobAdvertisement>>getAllByEmployerId(int employerId) {
		 
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployer_Id(employerId));
	}
		
	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job Advertisement updated !");
	}
	
	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
 
		this.jobAdvertisementDao.delete(jobAdvertisement);

		return new SuccessResult("Job Advertisement deleted !");
	}


	@Override
	public Result toggleActive(int jobId) {
		
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getById(jobId);
		if(!isJobAdvertisementExists(jobAdvertisement)) {
			
			return new ErrorResult("Job Advertisement doesn't exists");

		}
		
		jobAdvertisement.setActive(!jobAdvertisement.isActive());
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Toggled") ;
	}
	
	@Override
	public Result toggleVerifiedByEmployee(int jobId) {
		
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getById(jobId);
		if(!isJobAdvertisementExists(jobAdvertisement)) {
			
			return new ErrorResult("Job Advertisement doesn't exists");

		}
		
		jobAdvertisement.setIsVerifiedBySystemPersonel(true);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Verified by Employee");
	}

    
	
	
	public boolean isJobAdvertisementExists(JobAdvertisement jobAdvertisement) {
		
		if(jobAdvertisement == null) {
			return false;
		}
		return true;
	}
	
	
	
	
}
