package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.Skill;

public interface SkillService {
	
	Result add(Skill skill);
	
	Result addAll(List<Skill> skills);
	
	Result delete(Skill skill);
	
	Result update(Skill skill);
	
	DataResult<List<Skill>> getAllByCandidateId(int candidateId);

}
