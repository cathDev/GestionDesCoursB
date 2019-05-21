package org.iut.douala.gestion.cours.GestionCours.metier;

import java.util.ArrayList;
import java.util.Collection;

import org.iut.douala.gestion.cours.GestionCours.entities.Etudiants;
import org.iut.douala.gestion.cours.GestionCours.entities.Administrateurs;
import org.iut.douala.gestion.cours.GestionCours.entities.Enseignant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private AccountService accountService; 
	
	@Override
	public UserDetails loadUserByUsername(String matricule) throws UsernameNotFoundException {
		UserDetails user;
		Collection<GrantedAuthority> authority = new ArrayList<>();
		try {
			Etudiants etudiant =  accountService.findEtudiantByMatricule(matricule);
			user = new User(etudiant.getMatriculeEtud(), etudiant.getMotDePasse(),authority);
			authority.add(new SimpleGrantedAuthority("ETUDIANT"));	
		}
		catch (Exception e) {
			try {
				Administrateurs admin = accountService.findAdministrateurByMatricule(matricule);
				user = new User(admin.getMatricule(), admin.getMotDePasse(), authority);
				authority.add(new SimpleGrantedAuthority("ENSEIGNANT"));
				authority.add(new SimpleGrantedAuthority("ETUDIANT"));
				authority.add(new SimpleGrantedAuthority("ADMIN"));
			}
			catch (Exception exception) {
				try {
					Enseignant enseignant = accountService.findEnseignantByMatricule(matricule);
					user = new User(enseignant.getMatriculeEns(), enseignant.getMotDePasse(), authority);
					authority.add(new SimpleGrantedAuthority("ENSEIGNANT"));
				}
				catch(Exception excep) {
					throw new UsernameNotFoundException("pas d'utilisateur avec ce matricule");
				}
			}
		}
		return new User(user.getUsername(), user.getPassword(),authority);
	}
	
}
