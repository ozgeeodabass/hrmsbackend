package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.Candidate;
import kodlama.io.hrms.entities.JobPosition;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
	
	Candidate findCandidateByNationalId(String nationalId);
	Candidate findCandidateByEmail(String email);

	
	
}
