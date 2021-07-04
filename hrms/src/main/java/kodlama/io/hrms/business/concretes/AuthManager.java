package kodlama.io.hrms.business.concretes;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.AuthService;
import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.abstracts.VerificationCodeService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.core.utilities.verification.VerificationService;
import kodlama.io.hrms.entities.Candidate;
import kodlama.io.hrms.entities.Employer;
import kodlama.io.hrms.entities.VerificationCode;
import kodlama.io.hrms.entities.dtos.RegisterForCandidateDto;
import kodlama.io.hrms.entities.dtos.RegisterForEmployerDto;

@Service
public class AuthManager  implements AuthService{
	
	private CandidateService candidateService;
	private EmployerService employerService;
	private VerificationCodeService codeService;
	private VerificationService verificationService;
	
	private ModelMapper modelMapper;

	@Autowired
	public AuthManager(CandidateService candidateService, EmployerService employerService,
			VerificationCodeService codeService, VerificationService verificationService, ModelMapper modelMapper) {
		super();
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.codeService = codeService;
		this.verificationService = verificationService;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result registerEmployer(RegisterForEmployerDto registerForEmployerDto) {
		if(!checkIfPaswordAndPasswordAgainEqual(registerForEmployerDto.getPassword(),registerForEmployerDto.getPassword())) {
			
			return new ErrorResult("Password do not match !");
		}
		
       Employer employer = modelMapper.map(registerForEmployerDto, Employer.class);
       
		var result = this.employerService.add(employer);
		
		System.out.println(result);
         if(result.isSuccess()) {
        	 this.generateVerificationCode(employer.getId());

           }
          return new ErrorResult("Please try again.");
	}

	@Override
	public Result registerCandidate(RegisterForCandidateDto registerForCandidateDto) {
		if(!checkIfPaswordAndPasswordAgainEqual(registerForCandidateDto.getPassword(),registerForCandidateDto.getPassword())) {
			
			return new ErrorResult("Password do not match !");
		}
		
		Candidate candidate = modelMapper.map(registerForCandidateDto, Candidate.class);
		
		var result = this.candidateService.add(candidate);
		
		if(result.isSuccess()) {
			
			this.generateVerificationCode(candidate.getId());
		
		}
		return new ErrorResult(result.getMessage());
	}

	@Override
	public Result verifyEmail(int user_id, String activationCode) {
		var result = this.codeService.getByUserIdAndVerificationCode(user_id, activationCode);  

		if(!this.isVerificationCodeExist(user_id, activationCode).isSuccess()
				|| !this.isVerifiationCodeActive(user_id, activationCode).isSuccess()
				|| !isExpired(user_id,activationCode).isSuccess()) {
			
			return new ErrorResult();
		}

	    if(!this.setCandidateActivationCode(user_id).isSuccess() && !this.setEmployerActivationCode(user_id).isSuccess()) {
	    	return new ErrorResult("User couldn't find");
	    }
	    
	 
	    VerificationCode verificationCode = result.getData();
	    
	    verificationCode.setConfirmedDate(LocalDate.now());
	    verificationCode.setIsActivate(true);
	    this.codeService.update(verificationCode);
	   	    
	    return new SuccessResult("Verified !");
	}
	
	private Result setEmployerActivationCode(int user_id) {
		
	    if(this.employerService.getById(user_id).getData()!= null) {
		    	
		    	Employer employer = this.employerService.getById(user_id).getData();
		    
		    	employer.setEmailVerified(true);
		    	
		    	this.employerService.update(employer);
		    	
		    	return new SuccessResult();
		    }
	        
	    return new ErrorResult();
		}
		
		private Result setCandidateActivationCode(int user_id) {
		    if(this.candidateService.getById(user_id).getData()!=null) {
		    	
		    	Candidate candidate =this.candidateService.getById(user_id).getData();
		    	
		    	candidate.setEmailVerified(true);
		    	
		    	this.candidateService.update(candidate);

		    	return new SuccessResult();
		    }
		    
		    return new ErrorResult();
			}
	
	
	
	private boolean checkIfPaswordAndPasswordAgainEqual(String password, String passwordAgain) {
		if(!passwordAgain.equals(password)) {
			return false;
		}
		return true;
	}
	
	
	private Result isVerificationCodeExist(int user_id, String activationCode) {
		if(this.codeService.getByUserIdAndVerificationCode(user_id, activationCode)==null) {
			return new ErrorResult("Verification code is not exist!");
		}
		return new SuccessResult();
	}
	
	private Result isVerifiationCodeActive(int user_id,String activationCode) {
		if(this.codeService.getByUserIdAndVerificationCode(user_id, activationCode).getData().getIsActivate()) {
			return new ErrorResult("Verification code is already active");
		}
		return new SuccessResult();
	}
	
	
	private Result isExpired(int user_id, String activationCode) {
		if(this.codeService.getByUserIdAndVerificationCode(user_id, activationCode).getData().getExpiredDate().isBefore(LocalDate.now())) {
			return new ErrorResult("Verification code expired.");
		}
		return new SuccessResult();
	}
	
	
	private Result generateVerificationCode(int userId) {
		String code= this.verificationService.codeGenerator();
		this.verificationService.sendVerificationCode(code);
		VerificationCode verifCode= new VerificationCode(userId, code, LocalDate.now().plusDays(1));
		this.codeService.add(verifCode);
		return new SuccessResult("User registered.");
	}
	
	
	
	
	
	
	

}
