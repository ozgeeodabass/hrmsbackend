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

import kodlama.io.hrms.business.abstracts.CoverLetterService;
import kodlama.io.hrms.entities.CoverLetter;

@RestController
@RequestMapping("/api/coverletters")
public class CoverLettersController {

	
	private CoverLetterService coverLetterService;

	@Autowired
	public CoverLettersController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CoverLetter letter) {
		
		return ResponseEntity.ok(this.coverLetterService.add(letter));
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody CoverLetter letter) {
		return ResponseEntity.ok(this.coverLetterService.delete(letter));
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody CoverLetter letter) {
		return ResponseEntity.ok(this.coverLetterService.update(letter));
		
	}
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@Valid @RequestParam int id) {
		return ResponseEntity.ok(this.coverLetterService.getById(id));
	}
	
	@GetMapping("/getAllByCandidateId")
	public ResponseEntity<?> getAllByCandidateId(@Valid @RequestParam int id) {
		return ResponseEntity.ok(this.coverLetterService.getAllByCandidate_Id(id));
	}
	
}
