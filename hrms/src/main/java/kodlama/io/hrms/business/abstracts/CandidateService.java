package kodlama.io.hrms.business.abstracts;

import java.util.List;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.Candidate;
import kodlama.io.hrms.entities.dtos.CvDto;

public interface CandidateService {

	Result add(Candidate candidate);
	
	Result delete(Candidate candidate);
	
	Result update(Candidate candidate);
	
	DataResult<Candidate> getById(int id);
	
	DataResult<List<Candidate>> gettAll();
	
	DataResult<Candidate> getCandidateByNationalityId(String nationalityId);
	
	DataResult<Candidate> getByEmail(String email);
	
	public DataResult<CvDto> getCvDtoById(int candidateId);

	boolean existWithNationalityId(String nationalityId);

	boolean existWithEmail(String email);
	
	
}
