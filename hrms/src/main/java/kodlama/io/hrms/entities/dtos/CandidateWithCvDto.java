package kodlama.io.hrms.entities.dtos;



import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateWithCvDto {

	
	private int id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String githubLink;
	private String linkedinLink;
	private String coverLetter;
	private String schoolName;
	private String department;
	private LocalDate schoolStartYear;
	private LocalDate graduationYear;
	private String jobExperience_companyName;
	private String jobExperience_position;
	private String jobExperienceDate;
	private String languageName;
	private String languageLevel;
	private String skillName;
	private String imageUrl;
	
}
