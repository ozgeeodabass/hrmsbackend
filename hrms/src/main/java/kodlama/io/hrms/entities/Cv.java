package kodlama.io.hrms.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cv")
public class Cv {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne
	@JoinColumn(name="id")
	private Candidate candidate;
	
	@Column(name="github_address")
	private String githubLink;
	
	@Column(name="linkedin_address")
	private String linkedinLink;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@OneToMany(mappedBy = "cv")
	private List<School> schools;
	

	@OneToMany(mappedBy = "cv")
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy = "cv")
	private List<Language> languages;
	
	@OneToOne(mappedBy = "cv", optional = true, fetch = FetchType.LAZY)
	@Nullable
	private Image image;
	
	@OneToMany(mappedBy = "cv")
	private List<Skill> skills;
	
	
	
	

}
