package org.iut.douala.gestion.cours.GestionCours.metier;

import org.iut.douala.gestion.cours.GestionCours.dao.AdministrateursRepository;
import org.iut.douala.gestion.cours.GestionCours.dao.EnseignantRepository;
import org.iut.douala.gestion.cours.GestionCours.dao.EtudiantRepository;
import org.iut.douala.gestion.cours.GestionCours.entities.Administrateurs;
import org.iut.douala.gestion.cours.GestionCours.entities.Enseignant;
import org.iut.douala.gestion.cours.GestionCours.entities.Etudiants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private EnseignantRepository enseignantRepository ;
	@Autowired
	private AdministrateursRepository administrateursRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Enseignant saveEnseignant(Enseignant enseignant) {
		String hashPwd = bCryptPasswordEncoder.encode(enseignant.getMotDePasse());
		enseignant.setMotDePasse(hashPwd);
		return enseignantRepository.save(enseignant);
	}

	@Override
	public Etudiants saveEtudiant(Etudiants etudiant) {
		String hashPwd = bCryptPasswordEncoder.encode(etudiant.getMotDePasse());
		etudiant.setMotDePasse(hashPwd);
		return etudiantRepository.save(etudiant);
	}

	@Override
	public Enseignant findEnseignantByMatricule(String matricule) {
		// TODO Auto-generated method stub
		return enseignantRepository.findById(matricule).orElse(null);
	}

	@Override
	public Etudiants findEtudiantByMatricule(String matricule) {
		// TODO Auto-generated method stub
		return etudiantRepository.findById(matricule).orElse(null);
	}

	@Override
	public Administrateurs saveAdministrateur(Administrateurs admin) {
		String hashPwd = bCryptPasswordEncoder.encode(admin.getMotDePasse());
		admin.setMotDePasse(hashPwd);
		return administrateursRepository.save(admin);
	}

	@Override
	public Administrateurs findAdministrateurByMatricule(String matricule) {
		// TODO Auto-generated method stub
		return administrateursRepository.findById(matricule).orElse(null);
	}
	
	
}
