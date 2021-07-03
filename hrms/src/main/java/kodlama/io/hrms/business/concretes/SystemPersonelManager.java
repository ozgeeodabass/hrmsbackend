package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.SystemPersonelService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.SystemPersonelDao;
import kodlama.io.hrms.entities.SystemPersonel;

@Service
public class SystemPersonelManager implements SystemPersonelService {

	
	private SystemPersonelDao personelDao;
	
	@Autowired
	public SystemPersonelManager(SystemPersonelDao personelDao) {
		super();
		this.personelDao = personelDao;
	}

	@Override
	public Result add(SystemPersonel personel) {
		this.personelDao.save(personel);
		return new SuccessResult("Personel added");
	}

	@Override
	public Result delete(SystemPersonel personel) {
		this.personelDao.delete(personel);
		return new SuccessResult("Personel deleted");
	}

	@Override
	public Result update(SystemPersonel personel) {
		this.personelDao.save(personel);
		return new SuccessResult("Personel updated");
	}

	@Override
	public DataResult<List<SystemPersonel>> getAll() {
		return new SuccessDataResult<List<SystemPersonel>>(this.personelDao.findAll());
	}

	@Override
	public DataResult<SystemPersonel> getById(int id) {
		return new SuccessDataResult<SystemPersonel>(this.personelDao.getById(id));
	}
	
	
	
	

}
