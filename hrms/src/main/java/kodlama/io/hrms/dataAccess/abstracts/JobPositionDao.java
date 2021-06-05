package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {
	
	JobPosition findByPositionName(String positionName);
	

}
