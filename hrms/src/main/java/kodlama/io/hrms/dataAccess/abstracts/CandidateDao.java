package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.Candidate;
import kodlama.io.hrms.entities.dtos.CandidateWithCvDto;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
	
	Candidate findCandidateByNationalityId(String nationalityId);
	Candidate findCandidateByEmail(String email);
	
	@Query("Select new kodlama.io.hrms.entities.dtos.CandidateWithCvDto c.id, c.firstName, c.lastName, c.dateOfBirth,  "
			+ "cv.githubLink, cv.linkedinLink, cv.coverLetter, cv.schoolName, cv.department, cv.schoolStartYear, cv.graduationYear, cv.companyName, cv.position, cv.experienceDate, cv.languageName, cv.languageLevel, cv.skillName, cv.url"
			+ "From Cv cv Inner Join cv.candidate c ")
	CandidateWithCvDto getCandidateWithCvDetails();
	
	
	
}
