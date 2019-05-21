package org.iut.douala.gestion.cours.GestionCours.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication().
			withUser("falonne").password("{noop}1234").roles("ADMIN");*/
		
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//http.formLogin();
		http
		.authorizeRequests()
		.antMatchers("/login/**").permitAll()
		.antMatchers(HttpMethod.POST).hasAuthority("ADMIN")
		.antMatchers(HttpMethod.PUT).hasAuthority("ADMIN")
		.antMatchers(HttpMethod.DELETE).hasAuthority("ADMIN")
		.antMatchers(HttpMethod.GET, "/enseignants/**").hasAuthority("ENSEIGNANT")
		.antMatchers(HttpMethod.GET, "/etudiants/**").hasAuthority("ETUDIANT")
		.anyRequest().authenticated();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		
		/*http.authorizeRequests().antMatchers("/login/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST).hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET).hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/enseignants/**").hasAuthority("ENSEIGNANT");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/etudiants/**").hasAuthority("ETUDIANT");*/
		//http.authorizeRequests().anyRequest().authenticated();
	}

}
