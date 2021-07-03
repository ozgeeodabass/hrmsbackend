package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.CoverLetter;

public interface CoverLetterService {
	
	Result add(CoverLetter coverLetter);
	
	Result delete (CoverLetter coverLetter);
	
	Result update (CoverLetter coverLetter);
	
	DataResult<CoverLetter> getById(int id);
	
	DataResult<List<CoverLetter>> getAllByCandidate_Id(int candidateId);
	
	

}
