package kodlama.io.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.JobAdvertisement;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<JobAdvertisement> getById(int id);
	DataResult<JobAdvertisement> changeStatus(int employerId, int advertisementId, boolean status);
	
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getByIsActiveTrue();
	
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndApplicationDeadlineLessThanEqual(LocalDate date);
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndCity_CityName(String cityName);
	DataResult<List<JobAdvertisement>> getByEmployerId(int id);
	DataResult<List<JobAdvertisement>> getByIsActiveTrueAndJobPosition(String jobPosition);
	DataResult<List<JobAdvertisement>> getByIdIn(List<Integer> ids);
	DataResult<List<JobAdvertisement>> getByJobPosition_TitleContains(String title);
}
