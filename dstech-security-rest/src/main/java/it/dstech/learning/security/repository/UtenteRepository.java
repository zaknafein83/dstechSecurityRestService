package it.dstech.learning.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.dstech.learning.security.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Integer>{
	
	 Optional<Utente> findByName(String username);
}
