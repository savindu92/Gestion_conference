package com.rtit.esilv.bin2.poo.basics;

public class Presentation {
//Attributs
	private String auteurs;
	private String titreArticle;
	private int mois;
	private int jour;
	private String heure;
	//Constructeur
	
	/**
     * Constructeur de la classe Présentation
     * @param String auteurs, String titreArticle, int mois, int jour, String heure
     */
	
	public Presentation(String auteurs, String titreArticle, int mois, int jour, String heure) {
		super();
		this.auteurs = auteurs;
		this.titreArticle = titreArticle;
		this.mois = mois;
		this.jour = jour;
		this.heure = heure;
	}
	
	@Override
	
	/**
	 * Retourne une chaîne de caractères représentant la présentation avec ses attributs.
	 * @return Une chaîne de caractères représentant la présentation avec ses attributs.
	 */
	
	public String toString() {
		return "Presentation [auteurs=" + auteurs + ", titreArticle=" + titreArticle + ", mois=" + mois + ", jour=" + jour
				+ ", heure=" + heure + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public String getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(String auteurs) {
		this.auteurs = auteurs;
	}

	public String getTitreArticle() {
		return titreArticle;
	}

	public void setTitreArticle(String titreArticle) {
		this.titreArticle = titreArticle;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getJour() {
		return jour;
	}

	public void setJour(int jour) {
		this.jour = jour;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}
	
	
}
