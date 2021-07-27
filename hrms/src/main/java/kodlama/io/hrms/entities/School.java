package kodlama.io.hrms.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="schools")
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String schoolName;
	
	@Column(name="department")
	private String departmentName;
	
	@Column(name="start_year")
	private LocalDate startYear;
	
	@Column(name="graduation_year",nullable = true)
	private LocalDate graduationYear;
	
	
	//relational properties 
	
	
	@ManyToOne()
	@JsonIgnoreProperties({"email","password","passwordAgain","nationalityId","dateOfBirth", "isEmailVerified","createdDate"})
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	
	
	
}
