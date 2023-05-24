package com.rtit.esilv.bin2.poo.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rtit.esilv.bin2.poo.dao.ConferenceDAO;
import com.rtit.esilv.bin2.poo.basics.ReportingConference;
import com.rtit.esilv.bin2.poo.basics.Conference;
import com.rtit.esilv.bin2.poo.basics.ConferenceOnline;
import com.rtit.esilv.bin2.poo.basics.Presentation;
import com.rtit.esilv.bin2.poo.basics.Session;
import com.rtit.esilv.bin2.poo.utils.Saisie;

public class TestConference {
	
    public static void main(String[] args) {
        // ATTENTION : Pour les saisie au clavier, vous pouvez utiliser
        // la classe Scanner oubien la classe Saisie
    	
    	ArrayList<Session> sess = new ArrayList<Session>();
        Conference conf = new Conference(sess, "CIRA", "BERLIN", 2022);
        int nbrSess = Saisie.lireEntier("Saisie le nombre de sessions : ");
        		
        for (int i = 0; i < nbrSess; i++) {
           String thematique = Saisie.lireChaine("Saisie le nom de la thématique : ");
           int jour = Saisie.lireEntier("Saisie le jour de la session : ");
           int mois = Saisie.lireEntier("Saisie le mois de la session : ");
           ArrayList<Presentation> press = new ArrayList<Presentation>();
           Session s = new Session(thematique, jour, mois, press);
           int nbrPres = Saisie.lireEntier("Saisie le nombre de présentation dans la session : ");
           
           
           for (int j = 0; j < nbrPres; j++) {
              String titreArticle = Saisie.lireChaine("\nSaisie le titre de l'article : ");
              String auteurs = Saisie.lireChaine("Saisie l'auteur de l'article : ");
              Presentation p = new Presentation(auteurs,
              titreArticle, mois, jour, "" + (j + 8) + " heures");
              s.addPresentation(p);
              
           }
           
           conf.addSession(s);
        }
        
        
    
        System.out.print(conf.getUneSession(0));
        
        String nomConference = Saisie.lireChaineConferenceOnline("Saisie le nom de la conférence en ligne : ");
        long password = Saisie.lireLong("Saisie le mot de passe de conférence en ligne: ");
        
        ConferenceOnline confOnline = new ConferenceOnline(nomConference, password);
        
        confOnline.setUrl();
        System.out.print(confOnline.getUrl());
        
        try {
			int result = ConferenceDAO.addConference(100, conf.getNom(), conf.getLieu(), conf.getAnnee()); //On crée une conférence d'id 1 
			if (result == 1) {
				System.out.println("La conférence a été ajouté avec succès !!!");
			} else {
				System.out.println("La conférence n'a pas été ajouté ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        try {
			int result = ConferenceDAO.addSession(101, conf.getUneSession(0).getSpecialite(), conf.getUneSession(0).getJour(), conf.getUneSession(0).getMois(),100); // On crée la 1ere session de la conférence 1
			if (result == 1) {
				System.out.println("La session a été ajouté avec succès !!!");
			} else {
				System.out.println("La session n'a pas été ajouté ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        try {
			int result = ConferenceDAO.addSession(102, conf.getUneSession(1).getSpecialite(), conf.getUneSession(1).getJour(), conf.getUneSession(1).getMois(), 100); // On créee la 2e session de la conférence 1
			if (result == 1) {
				System.out.println("La session a été ajouté avec succès !!!");
			} else {
				System.out.println("La session n'a pas été ajouté ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        try {
			int result = ConferenceDAO.addPresentation(103, conf.getUneSession(0).getUnePresentation(0).getAuteurs(), conf.getUneSession(0).getUnePresentation(0).getTitreArticle(), conf.getUneSession(0).getUnePresentation(0).getMois(), conf.getUneSession(0).getUnePresentation(0).getJour(), conf.getUneSession(0).getUnePresentation(0).getHeure(),101); //On crée la présentation 1 pour la session 1
			if (result == 1) {
				System.out.println("La présentation a été ajouté avec succès !!!");
			} else {
				System.out.println("La présentation n'a pas été ajouté ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
        try {
	        RandomAccessFile rf = new RandomAccessFile("./conference.dat", "rw");
			// cr�ation de la collection des conference
			ArrayList<Conference> cconf = new ArrayList<Conference>();
			// remplissage du vecteur avec des donn�es en dur (pour l'instant ....)
			 try {
					Conference confbyNom = ConferenceDAO.getConferenceByNom("CIRA");
					System.out.println("************* Affichage de la conférence *********** ");
					confbyNom.afficher();
					cconf.add(confbyNom);
				} catch (SQLException e) {
					e.printStackTrace();
			}
			
			
			
			
	        ReportingConference conference = new ReportingConference(cconf, rf);
			conference.creerConference();
	
				System.out.println("Nombre Total de confenrence dans le reportingConference: " + conference.getNbConference());
				conference.afficherConference(0);
				
				
		} catch (FileNotFoundException e) {
			System.out.println("Ds main TestConférence : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Ds main TestConférence : " + e.getMessage());
		}
    }
}

