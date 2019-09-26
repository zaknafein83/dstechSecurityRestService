package it.dstech.learning.security;

import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.dstech.learning.security.model.Ruoli;
import it.dstech.learning.security.model.Utente;
import it.dstech.learning.security.repository.UtenteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCreate {
	
	@Autowired
	private UtenteRepository userRepo;
	
	@Test
	public void createUserWithPasswordCryt() {
		String  password = "ciccio";
		Utente newUser = new Utente();
		
		newUser.setName("JUnitTestName");
		newUser.setActive(1);
		newUser.setEmail("junittest@email.it");
		newUser.setLastName("JUnitTestLastName");
		
		Ruoli role = new Ruoli();
		role.setRole("ADMIN");
		HashSet<Ruoli> hashSet = new HashSet<Ruoli>();
		hashSet.add(role);
		newUser.setRoles(hashSet);
		newUser.setPassword(password);
		
		userRepo.save(newUser);
		

	}
	
}
