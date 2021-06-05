package kodlama.io.hrms.mernis;

public class fakeMernisService {
	
	public boolean isValid(String nationalityId, String firstName, String lastName, String birthYear) {
		System.out.println(firstName + " " + lastName + " için kullanıcı bilgileri doğrulandı" );
		return true;
	}

}
