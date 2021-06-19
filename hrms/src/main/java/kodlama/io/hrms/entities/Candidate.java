package kodlama.io.hrms.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="candidate_users")
@PrimaryKeyJoinColumn(name= "id")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Candidate extends User {

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="nationality_id")
	private String nationalityId;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	@Column(name="password_again")
	private String passwordAgain;
	
	@OneToOne(mappedBy = "candidate")
	private Cv cv;
	
	@OneToMany
	private List<JobExperience> jobExperiences;
	
	@OneToMany
	private List<School> schools;
	
	
	
	
}
