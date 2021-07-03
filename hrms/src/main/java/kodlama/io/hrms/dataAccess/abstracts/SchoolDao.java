package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.School;

public interface SchoolDao extends JpaRepository<School, Integer> {
	
	List<School> getAllByCandidate_IdOrderByGraduationYear(int candidateId);
	List<School> getAllByCandidate_Id(int candidateId);

	
}
