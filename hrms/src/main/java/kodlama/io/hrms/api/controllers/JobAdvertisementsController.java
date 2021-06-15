package kodlama.io.hrms.api.controllers;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<JobAdvertisement> getById(@RequestParam int id){
		return this.jobAdvertisementService.getById(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getByIsActiveTrue")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue(){
		return this.jobAdvertisementService.getByIsActiveTrue();
	}
	
	@GetMapping("/getByIsActiveTrueAndApplicationDeadlineLessThanEqual")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndApplicationDeadlineLessThanEqual(LocalDate date){
		return this.jobAdvertisementService.getByIsActiveTrueAndApplicationDeadlineLessThanEqual(date);
	}
	
	@GetMapping("/getByIsActiveTrueAndEmployer_CompanyName")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName){
		return this.jobAdvertisementService.getByIsActiveTrueAndEmployer_CompanyName(companyName);
	}
	
	@GetMapping("/getByIsActiveTrueAndCity_CityName")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndCity_CityName(String cityName){
		return this.jobAdvertisementService.getByIsActiveTrueAndCity_CityName(cityName);
	}
	
	@GetMapping("/getByEmployerId")
	public DataResult<List<JobAdvertisement>> getByEmployerId(int id){
		return this.jobAdvertisementService.getByEmployerId(id);
	}
	
	@GetMapping("/getByIsActiveTrueAndJobPosition")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndJobPosition(String jobPosition){
		return this.jobAdvertisementService.getByIsActiveTrueAndJobPosition(jobPosition);
	}
	
	@GetMapping("/getByIdIn")
	public DataResult<List<JobAdvertisement>> getByIdIn(List<Integer> ids){
		return this.jobAdvertisementService.getByIdIn(ids);
	}
	
	@GetMapping("/getByJobPosition_TitleContains")
	public DataResult<List<JobAdvertisement>> getByJobPosition_TitleContains(String title){
		return this.jobAdvertisementService.getByJobPosition_TitleContains(title);
		
	}
	
	
	
	
	

}
