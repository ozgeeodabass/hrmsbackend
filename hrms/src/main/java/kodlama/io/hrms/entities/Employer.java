package kodlama.io.hrms.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import kodlama.io.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
public class Employer extends User {
	
	@Column(name = "web_site")
	@NotBlank
	@NotNull
	@JsonIgnore
	private String webSite;
	
	@NotBlank
	@NotNull
	@JsonIgnore
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name="password_again")
	@JsonIgnore
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
