package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {

	 User getUserByEmail(String email);
	 
	 User getById(int id);

}
