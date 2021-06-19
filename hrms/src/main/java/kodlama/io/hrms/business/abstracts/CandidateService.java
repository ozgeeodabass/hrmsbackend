package kodlama.io.hrms.business.abstracts;

import java.util.List;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.Candidate;
import kodlama.io.hrms.entities.dtos.CandidateWithCvDto;

public interface CandidateService {

	DataResult<List<Candidate>> gettAll();
	DataResult<Candidate> getById(int id);
	Result add(Candidate candidate);
	Result delete(int is);
	Result update(Candidate candidate);
	DataResult<Candidate> getCandidateByNationalId(String nationalId);
	Result register(Candidate candidate);
	boolean checkPasswordIsTrue(Candidate candidate);
	
	Result existWithTc(String Tc);
	Result existWithEmail(String eMail);
	
	DataResult<CandidateWithCvDto> findCandidateAndCvByCv_Id(int candidateId);
	
	
	
	
	
	
	
	
}
