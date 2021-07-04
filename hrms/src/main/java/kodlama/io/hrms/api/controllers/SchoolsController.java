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

import kodlama.io.hrms.business.abstracts.SchoolService;
import kodlama.io.hrms.entities.School;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {

	private SchoolService schoolService;

	@Autowired
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody School school) {
		
		return ResponseEntity.ok(this.schoolService.add(school));
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody School school) {
		return ResponseEntity.ok(this.schoolService.delete(school));
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody School school) {
		return ResponseEntity.ok(this.schoolService.update(school));
		
	}
	
	@PostMapping("/addAll")
	public ResponseEntity<?> addAll(@Valid @RequestBody List<School> schools) {
		
		return ResponseEntity.ok(this.schoolService.addAll(schools));
		
	}
	
	@GetMapping("/getAllByCandidateId")
	public ResponseEntity<?> getAllByCandidateId(@Valid @RequestParam int id){
		
		return ResponseEntity.ok(this.schoolService.getAllByCandidateId(id));
		
	}
	
	
	@GetMapping("/getByCandidateIdOrderByGraduationYear")
	public ResponseEntity<?> getByCandidateIdOrderByGraduationYear(@Valid @RequestParam int candidateId){
		
		return ResponseEntity.ok(this.schoolService.getByCandidateIdOrderByGraduationYear(candidateId));
		
	}
	
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@Valid @RequestParam int id){
		
		return ResponseEntity.ok(this.schoolService.getById(id));
		
	}
	
	
}
