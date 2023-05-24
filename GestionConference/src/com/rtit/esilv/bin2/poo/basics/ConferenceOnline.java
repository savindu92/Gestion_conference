package com.rtit.esilv.bin2.poo.basics;

public class ConferenceOnline {
    private String nomConference;
    private long password;
    private String url;
    
    /**
     * Constructeur de la classe ConferenceOnline.
     * @param String nomConference, long password2
     */
    
	public ConferenceOnline(String nomConference, long password2) {
		super();
		this.nomConference = nomConference;
		this.password = password2;
	}

	public String getNomConference() {
		return nomConference;
	}

	public void setNomConference(String nomConference) {
		this.nomConference = nomConference;
	}

	public long getPassword() {
		return password;
	}

	public void setPassword(long password) {
		this.password = password;
	}
	
	/**
	 * Récupère l'url
	 * @return Une chaîne de caractères représentant la conférence avec ses attributs.
	 */

	public String getUrl() {
		return url;
	}
	
	/**
	 * Retourne l'url
	 * @return l'url sous la forme https://[nomConference]-online.zoom.us/[password];
	 */

	public void setUrl() {
		this.url = "https://" + this.nomConference + "-online.zoom.us/" + this.password;
	}

	
   

	
    
    

}