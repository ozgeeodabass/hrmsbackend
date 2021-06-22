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
	
	private String companyName;
	private String position;
	private LocalDate experienceStartDate;
	private boolean isExperienceEnd;
	
	private String languageName;
	private int languageLevel;
	
	private String skillName;
	
	private String imageUrl;
	
}
