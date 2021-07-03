package kodlama.io.hrms.entities.dtos;

import java.util.List;

import kodlama.io.hrms.entities.Candidate;
import kodlama.io.hrms.entities.CoverLetter;
import kodlama.io.hrms.entities.Image;
import kodlama.io.hrms.entities.JobExperience;
import kodlama.io.hrms.entities.Language;
import kodlama.io.hrms.entities.Link;
import kodlama.io.hrms.entities.School;
import kodlama.io.hrms.entities.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	
	public Candidate candidate;
	public List<School> schools;
	public List<Skill> skills;
	public List<Link> links;
	public List<Language> languages;
	public List<JobExperience> jobExperiences;
	public List<CoverLetter> coverLetters;
	public Image image;
	

}
