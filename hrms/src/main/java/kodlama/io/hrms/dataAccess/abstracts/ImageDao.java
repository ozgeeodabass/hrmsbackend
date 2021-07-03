package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.Image;

public interface ImageDao extends JpaRepository<Image, Integer> {

	Image getByCandidate_Id(int candidateId);
	Image getById(int id);
	
}
