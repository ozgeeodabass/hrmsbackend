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

import kodlama.io.hrms.business.abstracts.SystemPersonelService;
import kodlama.io.hrms.entities.SystemPersonel;

@RestController
@RequestMapping("/api/systempersonels")
public class SystemPersonelsController {

	private SystemPersonelService systemPersonelService;

	@Autowired
	public SystemPersonelsController(SystemPersonelService systemPersonelService) {
		super();
		this.systemPersonelService = systemPersonelService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody SystemPersonel systemPersonel) {
		
		return ResponseEntity.ok(this.systemPersonelService.add(systemPersonel));
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody SystemPersonel systemPersonel) {
		return ResponseEntity.ok(this.systemPersonelService.delete(systemPersonel));
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody SystemPersonel systemPersonel) {
		return ResponseEntity.ok(this.systemPersonelService.update(systemPersonel));
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		
		return ResponseEntity.ok(this.systemPersonelService.getAll());
		
	}
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam int id){
		
		return ResponseEntity.ok(this.systemPersonelService.getById(id));
		
	}
}
