package kodlama.io.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.entities.JobExperience;

@RestController
@RequestMapping("/api/jobexperiences")
public class JobExperiencesController {
	
	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobExperience experience) {
		
		return ResponseEntity.ok(this.jobExperienceService.add(experience));
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody JobExperience experience) {
		return ResponseEntity.ok(this.jobExperienceService.delete(experience));
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody JobExperience experience) {
		return ResponseEntity.ok(this.jobExperienceService.update(experience));
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
        return  ResponseEntity.ok(this.jobExperienceService.getAll());
    }
	
	
	@GetMapping("/getByCandidateIdByReverseSort")
	public ResponseEntity<?> getByCandidateIdByReverseSort(int id) {
        return  ResponseEntity.ok(this.jobExperienceService.getByCandidateIdByReverseSort(id));
    }
	
	@GetMapping("/getByCandidateId")
	public ResponseEntity<?> getByCandidateId(int id) {
        return  ResponseEntity.ok(this.jobExperienceService.getByCandidateId(id));
    }
	
	@GetMapping("/getByCandidateIdOrderByExperienceStartDate")
	public ResponseEntity<?> getByCandidateIdOrderByExperienceStartDate(int id) {
        return  ResponseEntity.ok(this.jobExperienceService.getByCandidateIdOrderByExperienceStartDate(id));
    }

	@GetMapping("/getById")
	public ResponseEntity<?> getById(int id) {
        return  ResponseEntity.ok(this.jobExperienceService.getById(id));
    }
	
}
