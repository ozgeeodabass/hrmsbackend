package kodlama.io.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterForCandidateDto {
	
	private String email;
	private String password;
	private String passwordAgain;
	private String firstName;
	private String lastName;
	private String nationalityId;
	private LocalDate dateOfBirth;
	

}
