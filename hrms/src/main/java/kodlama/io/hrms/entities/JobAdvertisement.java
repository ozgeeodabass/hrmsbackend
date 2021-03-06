package kodlama.io.hrms.entities;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name="job_advertisements")
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@JsonIgnore
	public int id;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="number_of_open_positions")
	private int numberOfOpenPositions;
	
	@Column(name="created_date")
	@JsonIgnore
	private LocalDate createdDate = LocalDate.now();
	
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	@Column(name="is_verified_by_system_personel",columnDefinition="boolean default false")
	private Boolean isVerifiedBySystemPersonel=false;
	
	@Column(name="is_active",columnDefinition = "boolean default true")
	@JsonIgnore
	private boolean isActive=true;
	
	
	//relational properties
	
	@ManyToOne()
	@JsonIgnoreProperties({"id","password","email","webSite","phoneNumber","passwordAgain","isEmailVerified","isVerifiedBySystemPersonel"})
	@JoinColumn(name="id",insertable=false, updatable=false)
	private Employer employer;
	
	@ManyToOne()
	@JsonIgnoreProperties({"id"})
	@JoinColumn(name="id",insertable=false, updatable=false)
	private City city;
	
	@ManyToOne()
	@JsonIgnoreProperties({"id"})
	@JoinColumn(name="id",insertable=false, updatable=false)
	private JobPosition jobPosition;
	
	
	
	
}
