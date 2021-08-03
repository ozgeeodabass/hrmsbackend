package kodlama.io.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.JobAdvertisement;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAllByIsActive();

	DataResult<List<JobAdvertisement>> getAllSortedByReleaseDate();

	DataResult<List<JobAdvertisement>> getAllByEmployerId(int employerId);
	
	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<JobAdvertisement> getById(int id);
	
	
	Result toggleActive(int jobId);
	
	Result toggleVerifiedByEmployee(int jobId);
	
	Result add(JobAdvertisement jobAdvertisement);
	
	Result update(JobAdvertisement jobAdvertisement);
	
	Result delete(JobAdvertisement jobAdvertisement);
	
}
