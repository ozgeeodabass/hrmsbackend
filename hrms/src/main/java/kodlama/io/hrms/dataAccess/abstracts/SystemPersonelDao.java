package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.SystemPersonel;

public interface SystemPersonelDao extends JpaRepository<SystemPersonel, Integer> {

	SystemPersonel getById(int id);
	
}
