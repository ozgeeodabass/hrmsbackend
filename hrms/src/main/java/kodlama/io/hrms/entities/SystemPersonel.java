package kodlama.io.hrms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlama.io.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name="system_personels")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@PrimaryKeyJoinColumn(name = "id",referencedColumnName = "id") 
@EqualsAndHashCode(callSuper = false)
public class SystemPersonel extends User {
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	
	

}
