package com.example.sprinkJwt;

import com.example.sprinkJwt.dto.UserDto;
import com.example.sprinkJwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SprinkJwtApplication implements CommandLineRunner {

	private final UserService userService;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public SprinkJwtApplication(UserService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(SprinkJwtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String email = "admin@example.com";
		// Vérifier si l'utilisateur existe déjà
		if (userService.findByEmail(email) == null) {
			UserDto userDto = new UserDto();
			userDto.setUsername("admin");
			userDto.setEmail(email);
			userDto.setPassword(passwordEncoder.encode("password"));

			// Enregistrer l'utilisateur dans la base de données
			userService.createUser(userDto);
		}
	}
}
