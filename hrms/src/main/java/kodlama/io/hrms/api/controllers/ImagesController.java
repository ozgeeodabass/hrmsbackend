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
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.business.abstracts.ImageService;
import kodlama.io.hrms.entities.Candidate;
import kodlama.io.hrms.entities.Image;

@RestController
@RequestMapping("/api/images")
public class ImagesController {
	
	private ImageService imageService;
	private CandidateService candidateService;
	
	@Autowired
	public ImagesController(ImageService imageService,
			CandidateService candidateService) {
		super();

		this.imageService = imageService;
		this.candidateService = candidateService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestParam int id, @Valid @RequestBody MultipartFile imageFile) {
		
		Candidate candidate = this.candidateService.getById(id).getData();
		Image image= new Image();
		image.setCandidate(candidate);
		
		return ResponseEntity.ok(this.imageService.add(image,imageFile));
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody Image image) {
		return ResponseEntity.ok(this.imageService.delete(image));
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody Image image) {
		return ResponseEntity.ok(this.imageService.update(image));
		
	}
	
	@GetMapping("/getByCandidateId")
	public ResponseEntity<?> getByCandidateId(@Valid @RequestParam int candidateId){
		return ResponseEntity.ok(this.imageService.getByCandidateId(candidateId));
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?>  getAll() {
		return ResponseEntity.ok(this.imageService.getAll());
		
	}
	
	
	
	@GetMapping("/getById")
	public ResponseEntity<?>  getById(@Valid @RequestParam int id) {
		return ResponseEntity.ok(this.imageService.getById(id));
		
	}
	

}
