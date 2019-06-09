package org.sylwester.rest;

import static org.sylwester.util.Utils.mapNonNullProperties;

import org.sylwester.model.ApplicationUser;
import org.sylwester.model.dto.NewApplicationUserDTO;
import org.sylwester.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "rest/api/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping
	public @ResponseBody String addNewUser(@RequestBody NewApplicationUserDTO newUserDTO) {
		ApplicationUser newUser = new ApplicationUser();
		mapNonNullProperties(newUser, newUserDTO);
		userRepository.save(newUser);
		return "New user saved";
	}

	@GetMapping
	public @ResponseBody Iterable<ApplicationUser> getAllUsers() {
		return userRepository.findAll();
	}
}
