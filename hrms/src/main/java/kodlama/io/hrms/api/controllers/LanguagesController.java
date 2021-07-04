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
import kodlama.io.hrms.business.abstracts.LanguageService;
import kodlama.io.hrms.entities.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

	
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Language language) {
		
		return ResponseEntity.ok(this.languageService.add(language));
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody Language language) {
		return ResponseEntity.ok(this.languageService.delete(language));
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody Language language) {
		return ResponseEntity.ok(this.languageService.update(language));
		
	}
	
	
	@PostMapping("/addAll")
	public ResponseEntity<?> addAll(@Valid @RequestBody List<Language> languages) {
		
		return ResponseEntity.ok(this.languageService.addAll(languages));
		
	}
	
	@GetMapping("/getAllByCandidateId")
	public ResponseEntity<?> getAllByCandidateId(@Valid @RequestParam int id) {
		
		return ResponseEntity.ok(this.languageService.getAllByCandidateId(id));
		
	}
	
}
