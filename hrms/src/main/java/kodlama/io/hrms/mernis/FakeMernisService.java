package kodlama.io.hrms.mernis;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class FakeMernisService {
	
	public boolean isValid(long nationalityId, String firstName, String lastName, LocalDate dateOfBirth) {
		System.out.println(firstName + " " + lastName + " için kullanıcı bilgileri doğrulandı" );
		return true;
	}

}
