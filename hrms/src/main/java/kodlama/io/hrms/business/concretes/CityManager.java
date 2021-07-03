package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CityDao;
import kodlama.io.hrms.entities.City;

@Service
public class CityManager implements CityService {
	
	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public Result add(City city) {
		if(!isCityExists(city.getName()).isSuccess()) {
			return new ErrorResult("City already exist.");
		}
		this.cityDao.save(city);
		return new SuccessResult();
	}

	@Override
	public Result delete(City city) {
		this.cityDao.delete(city);
		return new SuccessResult();
	}

	@Override
	public Result update(City city) {
		this.cityDao.save(city);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}

	@Override
	public DataResult<City> getById(int id) {
		return new SuccessDataResult<City>(this.cityDao.getById(id));
	}
	
	public Result isCityExists(String name) {
		
		if(this.cityDao.getByName(name) != null) {
			return new ErrorResult();
			
		}
		return new SuccessResult();
	}

}
