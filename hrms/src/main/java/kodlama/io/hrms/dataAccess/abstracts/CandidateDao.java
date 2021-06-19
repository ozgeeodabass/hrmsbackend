package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.Candidate;
import kodlama.io.hrms.entities.dtos.CandidateWithCvDto;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
	
	Candidate findCandidateByNationalityId(String nationalityId);
	Candidate findCandidateByEmail(String email);
	
	
	
	
	
	
}
