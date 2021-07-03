package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.Link;

public interface LinkDao extends JpaRepository<Link, Integer> {

	List<Link> getAllByCandidate_Id(int candidateId);
	
	
}
