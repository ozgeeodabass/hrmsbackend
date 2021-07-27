package kodlama.io.hrms.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="images")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="url")
	private String url;
	
	@Column(name="uploaded_date")
	@JsonIgnore
	private LocalDate uploadedDate= LocalDate.now();
	
	
	//relational properties
	
	
	@OneToOne
	@JsonIgnoreProperties({"email","password","passwordAgain","nationalityId","dateOfBirth", "isEmailVerified","createdDate"})
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	
}
