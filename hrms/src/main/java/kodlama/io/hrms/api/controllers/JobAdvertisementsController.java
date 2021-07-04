package kodlama.io.hrms.api.controllers;

import java.time.LocalDate;
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

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService= jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.jobAdvertisementService.getAll());
	}
	
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@Valid @RequestParam int id){
		return ResponseEntity.ok(this.jobAdvertisementService.getById(id));
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
	
	@GetMapping("/getByIsActiveTrue")
	public ResponseEntity<?> getByIsActiveTrue(){
		return ResponseEntity.ok(this.jobAdvertisementService.getByIsActiveTrue());
	}
	
	
	@GetMapping("/getByIsActiveTrueAndApplicationDeadlineLessThanEqual")
	public ResponseEntity<?> getByIsActiveTrueAndApplicationDeadlineLessThanEqual(LocalDate date){
		return ResponseEntity.ok(this.jobAdvertisementService.getByIsActiveTrueAndApplicationDeadlineLessThanEqual(date));
	}

	
	@GetMapping("/getByIsActiveTrueAndCity_CityId")
	public ResponseEntity<?> getByIsActiveTrueAndCity_CityId(int cityId){
		return ResponseEntity.ok(this.jobAdvertisementService.getByIsActiveTrueAndCity_CityId(cityId));
	}
	
	@GetMapping("/getByIsActiveTrueAndJobPosition")
	public ResponseEntity<?> getByIsActiveTrueAndJobPosition(String jobPosition){
		return ResponseEntity.ok(this.jobAdvertisementService.getByIsActiveTrueAndJobPosition(jobPosition));
	}
	
	@GetMapping("/getByIdIn")
	public ResponseEntity<?> getByIdIn(List<Integer> ids){
		return ResponseEntity.ok(this.jobAdvertisementService.getByIdIn(ids));
	}
	
	
	@GetMapping("/getByJobPosition_TitleContains")
	public ResponseEntity<?> getByJobPosition_TitleContains(String title){
		return ResponseEntity.ok(this.jobAdvertisementService.getByJobPosition_TitleContains(title));
	}
	
	
	@GetMapping("/getAllSortedByCreatedDate")
	public ResponseEntity<?> getAllSortedByCreatedDate(){
		return ResponseEntity.ok(this.jobAdvertisementService.getAllSortedByCreatedDate());
	}
	
	
	@GetMapping("/getAllByEmployerId")
	public ResponseEntity<?> getAllByEmployerId(int employerId){
		return ResponseEntity.ok(this.jobAdvertisementService.getAllByEmployerId(employerId));
	}
}


