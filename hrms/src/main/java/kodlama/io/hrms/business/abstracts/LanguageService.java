package kodlama.io.hrms.business.abstracts;
import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.Language;

public interface LanguageService {
	
	Result add(Language language);
	
	Result addAll(List<Language> languages);
	
	Result delete(Language language);
	
	Result update(Language language);
	
	DataResult<List<Language>> getAllByCandidateId(int id);
	

}
