package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.City;

public interface CityService {
	
	Result add(City city);
	
	Result delete (City city);
	
	Result update(City city);
	
	DataResult<List<City>> getAll();
	
	DataResult<City> getById(int id);

}
