package com.rtit.esilv.bin2.poo.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rtit.esilv.bin2.poo.basics.Conference;
import com.rtit.esilv.bin2.poo.basics.ReportingConference;
import com.rtit.esilv.bin2.poo.utils.DBAction;

public class ConferenceDAO {

	/**
	 * Ajoute une conférence à la table conference de la BDD 
	 * 
	 * @param int id_conferences, String nom, String lieu, int annee
	 * @return : result
	 * @throws SQLException
	 */
	public static int addConference(int id_conferences, String nom, String lieu, int annee)
			throws SQLException {
		// initialisation de variables & objets
		int result = 0;
		// connexion à la DB
		DBAction.DBConnexion();
		// ecriture de la requête
		String requete = "INSERT INTO conference (id_conferences, nom, lieu, annee) VALUES ('" + 
		id_conferences + "','" + nom + "','" + lieu + "','" + annee + "')";
		// executer un ordre de type executeUpdate à partir d'un statement recupéré de
		// la connexion
		result = DBAction.getStm().executeUpdate(requete);
		// fermeture de la connexion
		DBAction.DBClose();

		return result;
	}
	
	/**
	 * Ajoute une session à la table session de la BDD 
	 * 
	 * @param int session_id, String specialite, int jour, int mois, int id_conferences
	 * @return : result
	 * @throws SQLException
	 */
	public static int addSession(int session_id, String specialite, int jour, int mois, int id_conferences)
			throws SQLException {
		// initialisation de variables & objets
		int result = 0;
		// connexion à la DB
		DBAction.DBConnexion();
		// ecriture de la requête
		String requete = "INSERT INTO session (session_id, specialite, jour, mois, id_conferences) VALUES ('" + 
		session_id + "','" + specialite + "','" + jour + "','"+ mois + "','" +id_conferences + "')";
		// executer un ordre de type executeUpdate à partir d'un statement recupéré de
		// la connexion
		result = DBAction.getStm().executeUpdate(requete);
		// fermeture de la connexion
		DBAction.DBClose();

		return result;
	}
	
	/**
	 * Ajoute une présentation à la table présentation de la BDD 
	 * 
	 * @param int id_presentation, String auteur, String titreArticle, int mois, int jour, String heure, int session_id
	 * @return : result
	 * @throws SQLException
	 */
	
	public static int addPresentation(int id_presentation, String auteur, String titreArticle, int mois, int jour, String heure, int session_id)
			throws SQLException {
		// initialisation de variables & objets
		int result = 0;
		// connexion à la DB
		DBAction.DBConnexion();
		// ecriture de la requête
		String requete = "INSERT INTO presentation (id_presentation, auteur, titreArticle, mois, jour, heure, session_id) VALUES ('" + 
		id_presentation + "','" + auteur + "','" + titreArticle + "','" + mois + "','" + jour + "','" + heure + "','"+ session_id + "')";
		// executer un ordre de type executeUpdate à partir d'un statement recupéré de
		// la connexion
		result = DBAction.getStm().executeUpdate(requete);
		// fermeture de la connexion
		DBAction.DBClose();

		return result;
	}
	
	/**
	 * Récupère une liste de toutes les conférences 
	 * 
	 * @return : conferences
	 * @throws SQLException
	 */
	public static ArrayList<Conference> getAllConference() throws SQLException {
	    // 1. se connecter à la bd
	    DBAction.DBConnexion();
	    // 2. construire une requête SELECT pour récupérer toutes les lignes de la table conference
	    String requete = "SELECT * FROM conferences";
	    // 3. exécuter la requête SELECT et récupérer un ResultSet
	    ResultSet result = DBAction.getStm().executeQuery(requete);
	    // 4. parcourir le ResultSet pour créer des objets Conference et les ajouter à une ArrayList
	    ArrayList<Conference> conferences = new ArrayList<>();
	    while (result.next()) {
	        Conference conf = new Conference();
	        conf.setNom(result.getString("nom"));
	        conf.setLieu(result.getString("lieu"));
	        conf.setAnnee(result.getInt("annee"));
	        conferences.add(conf);
	    }
	    // 5. fermer le ResultSet et la connexion
	    if (!result.isClosed()) {
	        result.close();
	    }
	    DBAction.DBClose();
	    // 6. retourner l'ArrayList de la conference
	    return conferences;
	}
	
	/**
	 * Récupère une conférence depuis la base de donées grace a son nom 
	 * @param String nom
	 * @return : conf
	 * @throws SQLException
	 */
	
	public static Conference getConferenceByNom(String nom) throws SQLException {
		// 0. déclarer les objets temporaires
		Conference conf = new Conference();
		// 1. se connecter à la bd
		DBAction.DBConnexion();
		// construire une requête
		String requete = "SELECT * FROM conference WHERE nom ='" + nom + "'";
		// 2. récupérer un statement
		// 3. executer la requête de selection
		// 4. récupérer un resultSet à partir d'une requête
		ResultSet result = DBAction.getStm().executeQuery(requete);
		// 5. parcourir le resultSet
		if (result.next()) {		
			conf.setNom(result.getString(2));
			conf.setLieu(result.getString(3));
			conf.setAnnee(result.getInt(4));
			// 6. cloture du resultSet
			if (!result.isClosed()) {
				result.close();
			}
		} else {
			conf = null;
		}
		// 7. cloture de la connexion
		DBAction.DBClose();
		return conf;
	}

	

}