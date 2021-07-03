package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlama.io.hrms.entities.Candidate;


public interface CandidateDao extends JpaRepository<Candidate,Integer> {
	
	Candidate getCandidateByNationalityId(String nationalityId);
	Candidate getCandidateByEmail(String email);
	Candidate getById(int id);
	
	
}
