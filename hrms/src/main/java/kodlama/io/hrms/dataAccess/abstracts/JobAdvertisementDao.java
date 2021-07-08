package kodlama.io.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	
	@Query("From JobAdvertisement where isActive=true")
	List<JobAdvertisement> getByIsActive();
	
	List<JobAdvertisement> getByEmployer_Id(int employerId);
	
	JobAdvertisement getById(int jobId);
	
	
	
}
