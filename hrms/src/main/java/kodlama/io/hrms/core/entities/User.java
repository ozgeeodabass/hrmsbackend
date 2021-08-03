package kodlama.io.hrms.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@MappedSuperclass
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@Column(name="user_id")
	@JsonIgnore
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column(name="email")
	@Email
	@NotBlank
	@NotNull
	@JsonIgnore
	private String email;
	
	@Column(name="password")
	@NotBlank
	@NotNull
	@JsonIgnore
	private String password;
}
