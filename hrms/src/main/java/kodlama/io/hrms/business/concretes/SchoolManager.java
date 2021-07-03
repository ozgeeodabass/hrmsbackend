package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.SchoolService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.SchoolDao;
import kodlama.io.hrms.entities.School;

@Service
public class SchoolManager implements SchoolService {

	private SchoolDao schoolDao;

	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	

	@Override
	public Result add(School school) {
		this.schoolDao.save(school);
		return new SuccessResult("Okul eklendi");
	}




	@Override
	public Result addAll(List<School> schools) {
		for (School school : schools) {
			this.schoolDao.save(school);
		}
		return new SuccessResult();
	}




	@Override
	public Result delete(School school) {
		this.schoolDao.delete(school);
		return new SuccessResult();
	}




	@Override
	public Result update(School school) {
		this.schoolDao.save(school);
		return new SuccessResult();
	}




	@Override
	public DataResult<List<School>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getAllByCandidate_Id(id));
	}




	@Override
	public DataResult<List<School>> getByCandidateIdOrderByGraduationYear(int candidateId) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getAllByCandidate_IdOrderByGraduationYear(candidateId));
	}



	@Override
	public DataResult<School> getById(int id) {
		return new SuccessDataResult<School>(this.schoolDao.getById(id));
	}
	
	
	
	
	
	
}
