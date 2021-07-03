package kodlama.io.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	JobAdvertisement getById(int id);
	
	@Query("From JobAdvertisement where isActive=true")
	List<JobAdvertisement> getByIsActive();
	
	List<JobAdvertisement> getByEmployer_Id(int employerId);
	
	List<JobAdvertisement> getByIsActiveTrueAndEmployer_Id(String employerId);
	
	List<JobAdvertisement> getByIsActiveTrueAndOrderByCreatedAt();
	
	List<JobAdvertisement> getByIsActiveTrueAndApplicationDeadlineLessThanEqual(LocalDate date);
	
	List<JobAdvertisement> getByIsActiveTrueAndCity_CityId(int cityId);
	
	List<JobAdvertisement> getByIsActiveTrueAndJobPositionEquals(String jobPosition);
	
	List<JobAdvertisement> getByIdIn(List<Integer> ids);
	
	List<JobAdvertisement> getByJobPosition_TitleContains(String title);
	
	List<JobAdvertisement> getByJobPosition_jobPositionId(int id);
	
	
	
}
