package kodlama.io.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.LinkService;
import kodlama.io.hrms.entities.Link;

@RestController
@RequestMapping("/api/links")
public class LinksContoller {

	
	private LinkService linkService;

	@Autowired
	public LinksContoller(LinkService linkService) {
		super();
		this.linkService = linkService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Link link) {
		
		return ResponseEntity.ok(this.linkService.add(link));
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody Link link) {
		return ResponseEntity.ok(this.linkService.delete(link));
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody Link link) {
		return ResponseEntity.ok(this.linkService.update(link));
		
	}
	
	@PostMapping("/addAll")
	public ResponseEntity<?> addAll(@Valid @RequestBody List<Link> links) {
		
		return ResponseEntity.ok(this.linkService.addAll(links));
		
	}
	
	
	@PostMapping("/getAllByCandidateId")
	public ResponseEntity<?> getAllByCandidateId(@Valid @RequestParam int candidateId) {
		
		return ResponseEntity.ok(this.linkService.getAllByCandidateId(candidateId));
		
	}
	
	
	
}
