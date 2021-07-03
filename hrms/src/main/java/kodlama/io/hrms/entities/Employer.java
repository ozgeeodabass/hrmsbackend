package kodlama.io.hrms.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import kodlama.io.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
public class Employer extends User {
	
	@Column(name = "web_site")
	@NotBlank
	@NotNull
	private String webSite;
	
	@NotBlank
	@NotNull
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name="password_again")
	private String passwordAgain;
	
	@NotBlank
	@NotNull
	@Column(name = "company_name")
	private String companyName;
	
	@Nullable
	@JsonIgnore
	@Column(name = "is_email_verified")
	private boolean isEmailVerified;
	
	@Nullable
	@JsonIgnore
	@Column(name = "is_verified_by_system_personel")
	private boolean isVerifiedBySystemPersonel;
	
	
	//relational properties
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
	

}
