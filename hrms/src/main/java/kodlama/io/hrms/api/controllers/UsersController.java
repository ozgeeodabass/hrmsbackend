package kodlama.io.hrms.api.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.core.entities.User;


@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user) {
		return ResponseEntity.ok(userService.add(user));
		
	}
	
	@GetMapping("/getByEmail")
	public ResponseEntity<?> getByEmail(@Valid @RequestParam String email) {
		return ResponseEntity.ok(this.userService.getByEmail(email));
	}
	

	

	
	

}
