package kodlama.io.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.JobAdvertisement;

public interface JobAdvertisementService {
	
	Result add(JobAdvertisement jobAdvertisement);
	
	Result delete(JobAdvertisement jobAdvertisement);
	
	Result update(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<JobAdvertisement> getById(int id);
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrue();

	DataResult<List<JobAdvertisement>> getAllSortedByCreatedDate();
	
	DataResult<List<JobAdvertisement>> getAllByEmployerId(int employerId);
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndApplicationDeadlineLessThanEqual(LocalDate date);
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndCity_CityId(int cityId);
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndJobPosition(String jobPosition);
	
	DataResult<List<JobAdvertisement>> getByIdIn(List<Integer> ids);
	
	DataResult<List<JobAdvertisement>> getByJobPosition_TitleContains(String title);
	
}
