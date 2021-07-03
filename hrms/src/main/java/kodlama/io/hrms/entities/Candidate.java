package kodlama.io.hrms.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import kodlama.io.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="candidates")
@PrimaryKeyJoinColumn(name= "id", referencedColumnName = "id")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Candidate extends User {
	
	@NotBlank(message= "Missing information")
	@NotNull
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank
	@NotNull
	private String lastName;
	
	@Column(name="nationality_id")
	@NotBlank
	@NotNull
	private String nationalityId;
	
	@Column(name="date_of_birth")
	@NotBlank
	@NotNull
	private LocalDate dateOfBirth;
	
	@Column(name="is_email_verified")
	@Nullable
	private boolean isEmailVerified;
	
	
	@Column(name="password_again")
	private String passwordAgain;
	
	@Column(name="created_date")
	@JsonIgnore
	private LocalDate createdDate=LocalDate.now();
	
	
	//relational properties
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CoverLetter> coverLetters;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<JobExperience> jobExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Language> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Link> socialLinks;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<School> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<Skill> skills;
	
	@JsonIgnore
	@Nullable
	@OneToOne(mappedBy = "candidate",optional=true, fetch=FetchType.LAZY)
	private Image image;
	
	
	
	
	
	
	
	
	
}
