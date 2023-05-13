package com.curso.spring.boot;

import com.curso.spring.boot.web.model.UserModel;
import com.curso.spring.boot.web.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

@SpringBootApplication
public class DemoMvc2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoMvc2Application.class, args);
	}
	/*private void criarSuperAdministrador( UserService usuarioService) {
		// Creating an Admin and Adding Role Admin
		UserModel user = new UserModel(null, "admin", "gestaoviagens@gmail.com",
				"12345", "admin");
		usuarioService.cadastraruser(user);
	}

	 */
}
