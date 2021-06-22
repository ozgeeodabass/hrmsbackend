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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Column(name="cv_id")
	private int CvId;
	
	@Column(name="github_address")
	private String githubLink;
	
	@Column(name="linkedin_address")
	private String linkedinLink;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@OneToOne(mappedBy = "cv", optional = true, fetch = FetchType.LAZY)
	@Nullable
	@JoinColumn(name="image_id",referencedColumnName = "candidate_cv_image")
	private Image cvImage;
	
	@OneToOne(mappedBy= "cv")
	@JoinColumn(name="id")
	private Candidate candidate;
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy= "cv")
	@JsonIgnore
	private List<School> schools;
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<Language> languages;
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<Skill> skills;
	
	
}
