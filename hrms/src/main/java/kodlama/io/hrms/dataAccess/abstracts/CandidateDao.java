package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.Candidate;
import kodlama.io.hrms.entities.dtos.CandidateWithCvDto;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
	
	Candidate findCandidateByNationalityId(String nationalityId);
	Candidate findCandidateByEmail(String email);
	
	//@Query("Select new kodlama.io.hrms.entities.dtos.CandidateWithCvDto(c.id, c.firstName, c.lastName, c.dateOfBirth,  v.githubLink, v.linkedinLink, v.coverLetter, v.schools.schoolName, v.schools.department, v.schools.schoolStartYear, v.schools.graduationYear, v.jobExperiences.companyName, v.jobExperiences.position, v.jobExperiences.experienceStartDate, v.jobExperiences.isExperienceEnd, v.languages.languageName, v.languages.languageLevel, v.skills.skillName, v.cvImage.url ) From Cv c Inner Join c.candidate v where v.id:=candidateId")
	//CandidateWithCvDto getCandidateWithCvDetailsById(int candidateId);
	
	
	
	
	
}
