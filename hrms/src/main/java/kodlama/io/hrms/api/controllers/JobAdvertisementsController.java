package kodlama.io.hrms.api.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService= jobAdvertisementService;
	}
	

	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement){
		return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody JobAdvertisement jobAdvertisement){
		return ResponseEntity.ok(this.jobAdvertisementService.delete(jobAdvertisement));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody JobAdvertisement jobAdvertisement){
		return ResponseEntity.ok(this.jobAdvertisementService.update(jobAdvertisement));
	}
	
	@GetMapping("/getByIsActive")
	public ResponseEntity<?> getByIsActive(){
		return ResponseEntity.ok(this.jobAdvertisementService.getByIsActive());
	}
	
	
	@GetMapping("/getByAppealDeadline")
	public ResponseEntity<?> getByAppealDeadline(){
		
		return ResponseEntity.ok(this.jobAdvertisementService.getAllSortedByReleaseDate());
				
	}
	
	@GetMapping("/getAllByEmployerId")
	public ResponseEntity<?> getAllByEmployerId(int employerId){
		return ResponseEntity.ok(this.jobAdvertisementService.getAllByEmployerId(employerId));
	}
}


