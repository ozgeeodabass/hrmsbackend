package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.School;

public interface SchoolDao extends JpaRepository<School, Integer> {

	List<School> getByCandidate_Id(int id);
	
}
