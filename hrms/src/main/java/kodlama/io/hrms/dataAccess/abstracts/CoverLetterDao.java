package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.CoverLetter;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer> {

	CoverLetter getById(int id);
	
}
