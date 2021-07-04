package kodlama.io.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.VerificationCodeService;
import kodlama.io.hrms.entities.VerificationCode;

@RestController
@RequestMapping("/api/verificationcodes")
public class VerificatinCodesController {

	private VerificationCodeService verificationCodeService;

	@Autowired
	public VerificatinCodesController(VerificationCodeService verificationCodeService) {
		super();
		this.verificationCodeService = verificationCodeService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody VerificationCode verificationCode) {
		
		return ResponseEntity.ok(this.verificationCodeService.add(verificationCode));
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody VerificationCode verificationCode) {
		return ResponseEntity.ok(this.verificationCodeService.delete(verificationCode));
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody VerificationCode verificationCode) {
		return ResponseEntity.ok(this.verificationCodeService.update(verificationCode));
		
	}
	
	@GetMapping("/getByUserIdAndVerificationCode")
	public ResponseEntity<?> getByUserIdAndVerificationCode(@Valid @RequestParam int userId, @Valid @RequestParam String verificationCode){
		
		return ResponseEntity.ok(this.verificationCodeService.getByUserIdAndVerificationCode(userId,verificationCode));
		
	}
	
	
	
}
