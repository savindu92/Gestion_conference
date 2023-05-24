package com.rtit.esilv.bin2.poo.basics;

import java.util.ArrayList;

public class Session {
	//Attributs
	private String specialite;
	private int jour;
	private int mois;
	private ArrayList<Presentation> presentations;
	//Constructeur 1
	
	/**
	 * Constructeur de la classe Session
	 * @param String specialite, int jour, int mois
	 */
	
	public Session(String specialite, int jour, int mois) {
		super();
		this.specialite = specialite;
		this.jour = jour;
		this.mois = mois;
	}
	
	/**
	 * Constructeur de la classe Session prenant en compte les présentations
	 * @param String specialite, int jour, int mois, ArrayList<Presentation> presentations
	 */
	
	public Session(String specialite, int jour, int mois, ArrayList<Presentation> presentations) {
		super();
		this.specialite = specialite;
		this.jour = jour;
		this.mois = mois;
		this.presentations = presentations;
	}
	
	/**
	 * Ajouter un objet présentation au vecteur
	 * @param Presentation p
	 */
	public void addPresentation(Presentation p) {
		presentations.add(p);
	}
	
	@Override
	/**
	 * Retourne une chaîne de caractères représentant la session avec ses attributs.
	 * @return Une chaîne de caractères représentant la session avec ses attributs.
	 */
	
	public String toString() {
		return "Session [specialite=" + specialite + ", jour=" + jour + ", mois=" + mois + ", presentations="
				+ presentations + "]";
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	
	public Presentation getUnePresentation(int i){ 
		return presentations.get(i);
	}
	
	public int getJour() {
		return jour;
	}

	public void setJour(int jour) {
		this.jour = jour;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public ArrayList<Presentation> getPresentations() {
		return presentations;
	}

	public void setPresentations(ArrayList<Presentation> presentations) {
		this.presentations = presentations;
	}
	
	
	
}