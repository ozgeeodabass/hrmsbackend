package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>{
	
	List<Language> getAllByCandidate_Id(int candidateId);
	

}
