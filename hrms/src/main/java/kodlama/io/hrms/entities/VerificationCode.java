package kodlama.io.hrms.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "verification_codes")
public class VerificationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name="verification_code")
	private String verificationCode;
	
	@Column(name="created_date")
	private LocalDate createdDate=LocalDate.now();
	
	@Column(name="expired_date")  
	private LocalDate expiredDate;
	
	@NotNull
	@Column(name="is_activate", columnDefinition = "boolean default false") 
	private Boolean isActivate;
	
	@Nullable
	@Column(name="confirmed_date")  //  ?
	private LocalDate confirmedDate;
	
	
	public VerificationCode(int userId, String verificationCode, LocalDate expiredDate) {
		super();
		this.userId = userId;
		this.verificationCode = verificationCode;
		this.expiredDate = expiredDate;
	}
	
	

}
