package org.iut.douala.gestion.cours.GestionCours.restServices;

import org.iut.douala.gestion.cours.GestionCours.metier.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class MailSenderRestService {

	@Autowired
	private MailService mailService;
	
	@RequestMapping(value="/send-email-to-teacher/{id}", method = RequestMethod.GET)
	public String mailSenderToTeacher(@PathVariable int id)
	{
		try
		{
			mailService.sendEmailToTeacher(id);
		}
		catch(MailException mailException)
		{
			System.out.println(mailException);
		}
		
		return "le mail a été envoyé avec succès";
	}
	
	@RequestMapping(value="/send-email-to-students/{idCour}", method = RequestMethod.GET)
	public String mailSenderToStudents(@PathVariable int idCour)
	{
		try
		{
			mailService.sendEmailToStudents(idCour);
		}
		catch(MailException mailException)
		{
			System.out.println(mailException);
		}
		
		return "le mail a été envoyé avec succès";
	}
}
