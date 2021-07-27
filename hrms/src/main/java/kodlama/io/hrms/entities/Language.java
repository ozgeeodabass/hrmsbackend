package kodlama.io.hrms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="languages")
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="level")
	@Min(value=1)
	@Max(value=5)
	private int level;
	
	
	//relational properties 
	
	
	@ManyToOne()
	@JsonIgnoreProperties({"email","password","passwordAgain","nationalityId","dateOfBirth", "isEmailVerified","createdDate"})
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	
	
	
	
	

}
