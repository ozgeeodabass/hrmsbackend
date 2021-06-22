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
	@Column(name="school_id")
	private int schoolId;
	
	@Column(name="name")
	private String schoolName;
	
	@Column(name="department")
	private String department;
	
	@Column(name="start_year")
	private LocalDate schoolStartYear;
	
	@Column(name="graduation_year")
	@Nullable
	private LocalDate graduationYear;
	
	@ManyToOne()
	private Cv cv;
	
	
	
	
}
