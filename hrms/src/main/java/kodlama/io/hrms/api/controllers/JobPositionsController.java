package kodlama.io.hrms.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.entities.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.jobPositionService.gettAll());
    }
	
	@GetMapping("/getByTitle")
	public ResponseEntity<?> getByTitle(String title) {
        return ResponseEntity.ok(this.jobPositionService.getByTitle(title));
    }
	
	
	@PostMapping("/add")
	public ResponseEntity<?> add(JobPosition position) {
        return ResponseEntity.ok(this.jobPositionService.add(position));
    }
	
	
	
	
	
	
}
