package com.rtit.esilv.bin2.poo.utils;

import java.io.*;
public class Saisie {
	//M�thodes
	
	/**
	 * Lit une chaîne de caractères à partir de la console.
	 * @param message le message à afficher avant de lire la chaîne.
	 * @return la chaîne lue à partir de la console.
	 */
	
	public static String lireChaine(String message){
	 	String ligne = null;
	 	try{
	 		//conversion d'un flux binaire en un flux de caract�res (caract�res Unicode)
	 		InputStreamReader isr = new InputStreamReader(System.in);
	 		//construction d'un tampon pour optimiser la lecture du flux de caract�res
	 		BufferedReader br = new BufferedReader(isr);
	 		System.out.print(message);
	 		// lecture d'une ligne
	 		ligne = br.readLine();
	 	}
	 	catch (IOException e){
	 		System.err.println(e.getMessage());
	 	}
	 	return ligne;
	 }// fin lireChaine
	
	/**
	 * Lit un entier à partir de la console.
	 * @param message le message à afficher avant de lire l'entier.
	 * @return l'entier lu à partir de la console.
	 */
	
	 public static int lireEntier(String message){
	 	return Integer.parseInt(lireChaine(message));
	 }
	 
	 /**
	  * Lit un long à partir de la console.
	  * @param message le message à afficher avant de lire le long.
	  * @return le long lu à partir de la console.
	  */
	 
	 public static long lireLong(String message){
         return Long.parseLong(lireChaine(message));
	 }
	 
	 /**
	  * Lit une chaîne de caractères à partir de la console pour une conférence en ligne.
	  * @param message le message à afficher avant de lire la chaîne.
	  * @return la chaîne lue à partir de la console.
	  */
	 
	 public static String lireChaineConferenceOnline(String message){
         String ligne = null;
            try {
                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                boolean valide = false;
                while (!valide) {
                    System.out.print(message);
                    ligne = br.readLine();
                    // Vérification de la chaîne
                    if (ligne.contains(",") || ligne.contains(" ") || ligne.contains(";") || ligne.contains("\n") || ligne.contains("\\") || ligne.contains("#")) {
                        System.out.println("La chaîne ne doit pas contenir les caractères : , ;#\\\\n");
                    } else {
                        valide = true;
                    }
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
            return ligne;
     }
	 
	 /**
	  * Lit un nombre réel à partir de la console.
	  * @param message le message à afficher avant de lire le nombre réel.
	  * @return le nombre réel lu à partir de la console.
	  */

	 public static double lireReel(String message){
	 	return Double.parseDouble(lireChaine(message));
	 }
}
