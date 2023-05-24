package com.rtit.esilv.bin2.poo.basics;

import java.util.ArrayList;

public class Conference {
	// Attributs
	private ArrayList<Session> sessions;
	private String nom;
	private String lieu;
	private int annee;
	// Constructeur
	
	/**
	 * Constructeur avec paramètres pour initialiser les attributs nom, lieu et année de la classe conférence.
	 * @param nom Nom de la conférence.
	 * @param lieu Lieu de la conférence.
	 * @param annee Année de la conférence.
	 */
	
	public Conference(String nom, String lieu, int annee) {
		super();
		this.nom = nom;
		this.lieu = lieu;
		this.annee = annee;
	}
	
	/**
	 * Constructeur vide de conference
	 */
	
	public Conference() {
		super();
	}
	
	/**
	 * Constructeur avec paramètres pour initialiser tous les attributs.
	 * @param sessions Liste des sessions de la conférence.
	 * @param nom Nom de la conférence.
	 * @param lieu Lieu de la conférence.
	 * @param annee Année de la conférence.
	 */
	
	public Conference(ArrayList<Session> sessions, String nom, String lieu, int annee) {
		super();
		this.sessions = sessions;
		this.nom = nom;
		this.lieu = lieu;
		this.annee = annee;
	}
	
	/**
	 * Ajoute une session à la liste des sessions de la conférence.
	 * @param s La session à ajouter.
	 */

	public void addSession(Session s){ 
		sessions.add(s);
	}
	
	/**
	 * Retourne une session de la liste des sessions de la conférence.
	 * @param i L'index de la session à retourner.
	 * @return La session correspondante à l'index i.
	 */
	
	public Session getUneSession(int i){ 
		return sessions.get(i);
	}
	
	@Override
	/**
	 * Retourne une chaîne de caractères représentant la conférence avec ses attributs.
	 * @return Une chaîne de caractères représentant la conférence avec ses attributs.
	 */
	
	public String toString() {
		return "Conference [nom=" + nom + ", lieu=" + lieu + ", annee=" + annee + "]";
	}

	public ArrayList<Session> getSessions() {
		return sessions;
	}

	public void setSessions(ArrayList<Session> sessions) {
		this.sessions = sessions;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	public void afficher() {
		System.out.println("Nom de la conférence : " + nom);
		System.out.println("Lieu de la conférence : " + lieu);
		System.out.println("Annee de la conférence : " + annee);
		
	}
}