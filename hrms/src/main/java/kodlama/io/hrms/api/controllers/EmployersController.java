package kodlama.io.hrms.api.controllers;

import java.util.List;

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


import kodlama.io.hrms.business.abstracts.EmployerService;

import kodlama.io.hrms.entities.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Employer employer){
		return ResponseEntity.ok(this.employerService.add(employer));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody Employer employer){
		return ResponseEntity.ok(this.employerService.delete(employer));
	}
	
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody Employer employer){
		return ResponseEntity.ok(this.employerService.update(employer));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.employerService.getAll());
	}
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@Valid @RequestParam int id){
		return ResponseEntity.ok(this.employerService.getById(id));
	}
	
	@GetMapping("/getByEmail")
	public ResponseEntity<?> getByEmail(@Valid @RequestParam String email){
		return ResponseEntity.ok(this.employerService.getByEmail(email));
	}
	
	
	
	
}
