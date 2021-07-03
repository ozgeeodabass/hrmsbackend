package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.LinkService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.LinkDao;
import kodlama.io.hrms.entities.Link;

@Service
public class LinkManager implements LinkService {

	
	private LinkDao linkDao;

	@Autowired
	public LinkManager(LinkDao linkDao) {
		super();
		this.linkDao = linkDao;
	}

	@Override
	public Result add(Link link) {
		this.linkDao.save(link);
		return new SuccessResult();
	}

	@Override
	public Result addAll(List<Link> links) {
		
		for (Link link : links) {
			this.linkDao.save(link);
		}
		
		return new SuccessResult();
	}

	@Override
	public Result update(Link link) {
		this.linkDao.save(link);
		return new SuccessResult();
	}

	@Override
	public Result delete(Link link) {
		this.linkDao.delete(link);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Link>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Link>>(this.linkDao.getAllByCandidate_Id(candidateId));
	}
	
	
}
