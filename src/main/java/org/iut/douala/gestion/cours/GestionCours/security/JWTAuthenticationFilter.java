package org.iut.douala.gestion.cours.GestionCours.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iut.douala.gestion.cours.GestionCours.entities.Administrateurs;
import org.iut.douala.gestion.cours.GestionCours.entities.Enseignant;
import org.iut.douala.gestion.cours.GestionCours.entities.Etudiants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}

	/*@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		Etudiants etudiant;
		Administrateurs admin;
		Enseignant enseignant;
		User user;
		
		try {
			 etudiant =  new ObjectMapper().readValue(request.getInputStream(), Etudiants.class);
			user = new User(etudiant.getMatriculeEtud(), etudiant.getMotDePasse(),null);
				
		}
		catch (Exception e) {
			try {
				admin =  new ObjectMapper().readValue(request.getInputStream(), Administrateurs.class);
				user = new User(admin.getMatricule(), admin.getMotDePasse(), null);
			
			}
			catch (Exception exception) {
				try {
					enseignant =  new ObjectMapper().readValue(request.getInputStream(), Enseignant.class);
					user = new User(enseignant.getMatriculeEns(), enseignant.getMotDePasse(), null);
					
				}
				catch(Exception excep) {
					throw new RuntimeException(excep);
				}
			}
			
		}
		
		System.out.println("information de l'utilisateur qui tente de se connecter");
		System.out.println("userName"+user.getUsername());
		System.out.println("pass"+user.getPassword());
		
		return authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	}	*/
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		Etudiants etudiant;
		try {
			etudiant =  new ObjectMapper().readValue(request.getInputStream(), Etudiants.class);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		System.out.println("information de l'utilisateur qui tente de se connecter");
		System.out.println("userName"+etudiant.getMatriculeEtud());
		System.out.println("pass"+etudiant.getMotDePasse());
		
		return authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(etudiant.getMatriculeEtud(), etudiant.getMotDePasse()));
	}	
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, 
			FilterChain chain, Authentication authResult) throws IOException, ServletException {
		
		User user = (User) authResult.getPrincipal();
		String jwt = Jwts.builder()
				.setSubject(user.getUsername())
				.setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
				.claim("roles", user.getAuthorities())
				.compact();
		response.addHeader(SecurityConstants.TOKEN_HEADER, SecurityConstants.TOKEN_PREFIX+jwt);

	}

}
