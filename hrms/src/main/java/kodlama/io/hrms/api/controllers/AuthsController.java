package kodlama.io.hrms.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.AuthService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.RegisterForCandidateDto;
import kodlama.io.hrms.entities.dtos.RegisterForEmployerDto;

@RestController
@RequestMapping("/api/auths")
public class AuthsController {

	private AuthService authService;

	@Autowired
	public AuthsController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/registerCandidate")
	public Result registerCandidate(@RequestBody RegisterForCandidateDto registerForCandidateDto) {
		
		return this.authService.registerCandidate(registerForCandidateDto);
		
	}
	
	@PostMapping("/registerEmployer")
	public Result registerEmployer(@RequestBody RegisterForEmployerDto registerForEmployerDto) {
		
		return this.authService.registerEmployer(registerForEmployerDto);
		
	}
	
	@GetMapping("/verifyemail")
	public Result verifyEmail(int user_id, String activationCode)  {
		
		return this.authService.verifyEmail(user_id,activationCode);
		
	}
	

	
	
}
