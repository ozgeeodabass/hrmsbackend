package kodlama.io.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByIsActiveTrue();
	List<JobAdvertisement> getByIsActiveTrueAndApplicationDeadlineLessThanEqual(LocalDate date);
	List<JobAdvertisement> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	List<JobAdvertisement> getByIsActiveTrueAndCities_CityName(String cityName);
	List<JobAdvertisement> getByEmployerId(int id);
	List<JobAdvertisement> getByIsActiveTrueAndJobPosition(String jobPosition);
	JobAdvertisement getById(int id);
	List<JobAdvertisement> getByIdIn(List<Integer> ids);
	List<JobAdvertisement> getByJobPosition_TitleContains(String title);
	
	
}
