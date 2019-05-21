package org.iut.douala.gestion.cours.GestionCours.metier;


import java.util.List;

import org.iut.douala.gestion.cours.GestionCours.dao.CoursRepository;
import org.iut.douala.gestion.cours.GestionCours.dao.EnseignantRepository;
import org.iut.douala.gestion.cours.GestionCours.dao.EtudiantRepository;
import org.iut.douala.gestion.cours.GestionCours.entities.Cours;
import org.iut.douala.gestion.cours.GestionCours.entities.EtudiantsEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private EnseignantRepository enseignantRepository;
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	@Autowired
	private CoursRepository coursRepository;  
	
	public String[] castEtudiantsEmailToString( int id)
	{
		List<EtudiantsEmail> addresses = etudiantRepository.findEmailOfEtudiantsByIdCour(id);
		String[] emails = new String[addresses.size()];
		for(int i = 0; i < addresses.size(); i++)
		{
			
				emails[i] = addresses.get(i).getEmail();
			
		}
		return emails;
	}
	
	public void sendEmailToStudents(int id) throws MailException
	{
		Cours cours = coursRepository.findById(id).orElse(null);
		
		SimpleMailMessage Message = new SimpleMailMessage();
		Message.setTo(castEtudiantsEmailToString(id));
		Message.setSubject(" Nouveau cours programmé");
		Message.setText("vous aurez cours de "+cours.getCodeMatiere().getNomMatiere()+
				" le "+cours.getJour()+" dans la salle "+cours.getSalle()+" de "+cours.getHeureDeb()+
				"h à "+ cours.getHeureFin()+"h avec Mr "+cours.getMatricule().getNomEns()+" "+
				cours.getMatricule().getPrenomEns());
		mailSender.send(Message);
		
	}
	
	
	public void sendEmailToTeacher(int id) throws MailException
	{
		Cours cours = coursRepository.findById(id).orElse(null);
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(enseignantRepository.findEmailOfEnseignantByIdCour(id));
		mailMessage.setSubject(" Vous avez un nouveau cours programmé ");
		mailMessage.setText("vous aurez cours de "+cours.getCodeMatiere().getNomMatiere()+
				" le "+cours.getJour()+" dans la salle "+cours.getSalle()+" de "+cours.getHeureDeb()+
				"h à "+ cours.getHeureFin()+"h avec les etudiants de "+cours.getIdClass().getFiliere()+
				""+cours.getIdClass().getNiveau()+""+cours.getIdClass().getIdFormation().getIdFormation());
		mailSender.send(mailMessage);
	}
}
