package it.dstech.learning.security;

import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.dstech.learning.security.model.Role;
import it.dstech.learning.security.model.User;
import it.dstech.learning.security.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCreate {
	
	@Autowired
	private UserRepository userRepo;
	
	@Test
	public void createUserWithPasswordCryt() {
		String  password = "ciccio";
		User newUser = new User();
		
		newUser.setName("JUnitTestName");
		newUser.setActive(1);
		newUser.setEmail("junittest@email.it");
		newUser.setLastName("JUnitTestLastName");
		
		Role role = new Role();
		role.setRole("ADMIN");
		HashSet<Role> hashSet = new HashSet<Role>();
		hashSet.add(role);
		newUser.setRoles(hashSet);
		newUser.setPassword(password);
		
		userRepo.save(newUser);
		

	}
	
}
