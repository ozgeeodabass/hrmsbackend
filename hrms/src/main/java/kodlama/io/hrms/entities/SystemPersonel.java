package kodlama.io.hrms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name="system_personel_users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@PrimaryKeyJoinColumn(name = "id")
public class SystemPersonel extends User {
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	
	

}