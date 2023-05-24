package com.rtit.esilv.bin2.poo.basics;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;

//Cette classe permet de créer un fichier structure conférence partir
//d'informations places dans un vecteur
//Elle propose également des méthodes pour lire et afficher 
//l'écran, les
//enregistrements du fichier

public class ReportingConference {
	private ArrayList<Conference> collectionConferences;
	private RandomAccessFile fichierConference;
	private int nbConferences;

	private static final int NB_CHARS_NOM = 255;
	private static final int NB_CHARS_LIEU = 255;
	private static final int NB_YEAR = 4;
	
	private static final String path = ".";

	// constructeurs
	
	/**
	 * Constructeur de la classe ReportingConference
	 * @param ArrayList<Conference> cemp, RandomAccessFile rf
	 */
	
	public ReportingConference(ArrayList<Conference> cemp, RandomAccessFile rf) {
		collectionConferences = cemp;
		fichierConference = rf;
		nbConferences = 0;

	}
	
	/**
	 * Constructeur de la classe ReportingConference sans les RandomAccessFile
	 * @param ArrayList<Conference> cemp
	 */

	public ReportingConference(ArrayList<Conference> cemp) {
		collectionConferences = cemp;
		nbConferences = 0;
		try {
			fichierConference = new RandomAccessFile(path + "./conference.dat", "rw");
		} catch (IOException e) {
			System.out.println("PB création fichier conference ds Constructeur" + e.getMessage());
		}
	}
	
	/**
	 * Méthode privée pour obtenir une chaine de longueur fixe.
	 * @param String chaine, int longueur
	 * @return chaineRes
	 */
	
	private String formatChaine(String chaine, int longueur) {
		String chaineRes;
		// on tronque si la taille de la chaine d�passe la
		// longueur indiqué
		if (chaine.length() >= longueur) {
			chaineRes = chaine.substring(0, longueur);
		} else {
			StringBuffer sb = new StringBuffer(chaine);
			// on complémente avec des espaces
			for (int i = 0; i < (longueur - chaine.length()); i++) {
				sb.append(' ');
			} // fin for
			chaineRes = sb.toString();
		} // fin else
		return chaineRes;
	}// fin formatChaine
	
	
	/**
	 * Recopie de la collection des conferences dans le fichier structuré
	 * @return chaineRes
	 * @throws IOException
	 */
	
	public void creerConference() throws IOException {
		Iterator it = collectionConferences.iterator();
		while (it.hasNext()) {
			Conference conf = (Conference) it.next();
			// Ecriture dans fichierAnnuaire
			fichierConference.writeChars(formatChaine(conf.getNom(), NB_CHARS_NOM));
			fichierConference.writeChars(formatChaine(conf.getLieu(), NB_CHARS_LIEU));
			fichierConference.writeInt(conf.getAnnee());
			nbConferences++;
		} // fin fin while
		System.out.println("ReportingConference crée avec succés !!!!");
	}// fin creerAnnuaire
	
	/**
	 * Méthode de lecture d'une chaine de caractère ds fichierConference
	 * @return chaine
	 * @throws IOException
	 */
	
	private String lireChaine(int nbcars) throws IOException {
		String chaine = "";
		for (int i = 0; i < nbcars; i++) {
			char c = fichierConference.readChar();
			chaine += c;
		}
		return chaine;
	}
	
	/**
	 * lecture d'un employe dans le fichier annuaire
	 * @param int pos
	 * @return conf
	 * @throws IOException
	 */
	
	private Conference lireUneConference(int pos) throws IOException {
		Conference conf = new Conference();
		//System.out.println("lecture de l'enregistrement à la position " + pos);
		//fichierAnnuaire.seek(pos * NB_OCTETS_ENREGISTREMENT);
		conf.setNom(lireChaine(NB_CHARS_NOM));
		conf.setLieu(lireChaine(NB_CHARS_LIEU));
		conf.setAnnee(fichierConference.readInt());
	

		return conf;
	}// fin lireUnEmploye
	
	/**
	 * Affiche une conférence
	 * @param int pos
	 * @throws IOException
	 */
	
	public void afficherConference(int pos) throws IOException {
		Conference conf = lireUneConference(pos);
		conf.afficher();
	}
	
	/**
	 * Récupère le nombre de conférences crées
	 * @return nbConference
	 */
	
	public int getNbConference() {
		return nbConferences;
	}

}