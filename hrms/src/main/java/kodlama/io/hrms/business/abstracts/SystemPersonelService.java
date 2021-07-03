package kodlama.io.hrms.business.abstracts;
import kodlama.io.hrms.entities.SystemPersonel;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;

public interface SystemPersonelService {
	
	Result add(SystemPersonel personel);
	
	Result delete(SystemPersonel personel);
	
	Result update(SystemPersonel personel);
	
	DataResult<List<SystemPersonel>> getAll();
	
	DataResult<SystemPersonel> getById(int id);
	

}
