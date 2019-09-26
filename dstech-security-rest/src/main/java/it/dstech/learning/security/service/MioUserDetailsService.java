package it.dstech.learning.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.dstech.learning.security.model.MioUserDetails;
import it.dstech.learning.security.model.Utente;
import it.dstech.learning.security.repository.UtenteRepository;

@Service
public class MioUserDetailsService implements UserDetailsService{

	
	@Autowired
	private UtenteRepository usersRepository;
	
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Utente> optionalUsers = usersRepository.findByName(username);
        optionalUsers
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUsers
                .map(MioUserDetails::new).get();
    }
}
