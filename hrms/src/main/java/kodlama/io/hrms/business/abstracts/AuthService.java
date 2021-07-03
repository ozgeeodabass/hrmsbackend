package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.RegisterForCandidateDto;
import kodlama.io.hrms.entities.dtos.RegisterForEmployerDto;

public interface AuthService {
	
	 Result registerEmployer(RegisterForEmployerDto registerForEmployerDto);
	   
	 Result registerCandidate(RegisterForCandidateDto registerForCandidateDto);
	   
	 Result verifyEmail(int user_id, String activationCode);

}
