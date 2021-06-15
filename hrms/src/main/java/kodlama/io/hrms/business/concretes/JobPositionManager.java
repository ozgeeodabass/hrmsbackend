package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.io.hrms.entities.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}



	@Override
	public DataResult<List<JobPosition>> gettAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
	}


	@Override
	public DataResult<JobPosition> getByTitle(String title) {
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByTitle(title));
	}



	@Override
	public Result add(JobPosition jobPosition) {
		if(this.jobPositionDao.findByTitle(jobPosition.getTitle())!=null)
            return new ErrorResult("Aynı isimde iki adet iş pozisyonu oluşturulamaz.");
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("İş pozisyonu başarıyla eklendi.");
	}
		

}
