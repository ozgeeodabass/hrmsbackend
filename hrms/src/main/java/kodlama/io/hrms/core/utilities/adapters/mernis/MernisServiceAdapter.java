package kodlama.io.hrms.core.utilities.adapters.mernis;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.mernis.FakeMernisService;

@Service
public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean checkUser(long nationalityId, String firstName, String lastName, LocalDate dateOfBirth) {
		
		FakeMernisService mernis = new FakeMernisService();
		
		boolean result = mernis.isValid(nationalityId, firstName, lastName, dateOfBirth);
		
		return result;
		
		
	}

	
}
