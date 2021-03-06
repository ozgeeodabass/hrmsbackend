package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlama.io.hrms.entities.JobExperience;



public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {
	
	List<JobExperience> getByCandidate_IdOrderByStartDateDesc(int candidateId);
	List<JobExperience> getAllByCandidate_Id(int candidateId);
	JobExperience getById(int id);
	
	
}
