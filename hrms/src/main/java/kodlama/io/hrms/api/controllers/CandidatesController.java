package kodlama.io.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.entities.Candidate;


@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	
	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
        return  ResponseEntity.ok(candidateService.gettAll());
    }
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@Valid @RequestParam int id) {
		return ResponseEntity.ok(this.candidateService.getById(id));
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Candidate candidate) {
		
		return ResponseEntity.ok(this.candidateService.add(candidate));
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody Candidate candidate) {
		return ResponseEntity.ok(this.candidateService.delete(candidate));
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody Candidate candidate) {
		return ResponseEntity.ok(this.candidateService.update(candidate));
		
	}
	
	@GetMapping("/getCandidateByNationalityId")
	public ResponseEntity<?> getCandidateByNationalityId(@Valid @RequestParam String nationalityId){
		return ResponseEntity.ok(this.candidateService.getCandidateByNationalityId(nationalityId));
		
	}
	
	@GetMapping("/getByEmail")
	public ResponseEntity<?> getByEmail(@Valid @RequestParam String email){
		return ResponseEntity.ok(this.candidateService.getByEmail(email));
	}
	
	@GetMapping("/getCvDtoById")
	public ResponseEntity<?> getCvDtoById(@Valid @RequestParam int candidateId){
		return ResponseEntity.ok(this.candidateService.getCvDtoById(candidateId));
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String,String>();
		for(FieldError fieldError :exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
			
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;
	}
	
	

}
