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

import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.entities.City;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {
	
	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody City city) {
		
		return ResponseEntity.ok(this.cityService.add(city));
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody City city) {
		return ResponseEntity.ok(this.cityService.delete(city));
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody City city) {
		return ResponseEntity.ok(this.cityService.update(city));
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
        return  ResponseEntity.ok(cityService.getAll());
    }
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@Valid @RequestParam int id) {
		return ResponseEntity.ok(this.cityService.getById(id));
	}
	
	
	

}
