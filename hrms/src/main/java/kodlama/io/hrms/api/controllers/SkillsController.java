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

import kodlama.io.hrms.business.abstracts.SkillService;
import kodlama.io.hrms.entities.Skill;

@RestController
@RequestMapping("/api/skills")
public class SkillsController {

	private SkillService skillService;

	@Autowired
	public SkillsController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Skill skill) {
		
		return ResponseEntity.ok(this.skillService.add(skill));
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody Skill skill) {
		return ResponseEntity.ok(this.skillService.delete(skill));
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody Skill skill) {
		return ResponseEntity.ok(this.skillService.update(skill));
		
	}
	
	@PostMapping("/addAll")
	public ResponseEntity<?> addAll(@Valid @RequestBody List<Skill> skills) {
		
		return ResponseEntity.ok(this.skillService.addAll(skills));
		
	}
	
	@GetMapping("/getAllByCandidateId")
	public ResponseEntity<?> getAllByCandidateId(@Valid @RequestParam int candidateId) {
		
		return ResponseEntity.ok(this.skillService.getAllByCandidateId(candidateId));
		
	}
	
	
	
}
