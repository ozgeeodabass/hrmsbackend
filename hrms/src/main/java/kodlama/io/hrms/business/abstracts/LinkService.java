package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.Link;

public interface LinkService {
	
	Result add(Link link);
	
	Result addAll(List<Link> links);
	
	Result update(Link link);
	
	Result delete(Link link);
	
	DataResult<List<Link>> getAllByCandidateId(int candidateId);
	
}
