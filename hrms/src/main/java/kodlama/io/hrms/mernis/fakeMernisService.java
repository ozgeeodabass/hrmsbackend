package kodlama.io.hrms.mernis;

import java.util.Date;

public class fakeMernisService {
	
	public boolean isValid(String nationalityId, String firstName, String lastName, Date birthYear) {
		System.out.println(firstName + " " + lastName + " için kullanıcı bilgileri doğrulandı" );
		return true;
	}

}
