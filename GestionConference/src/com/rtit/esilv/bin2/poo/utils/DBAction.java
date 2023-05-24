package com.rtit.esilv.bin2.poo.utils;
/**

	La classe DBAction contient des méthodes pour gérer les actions de base de données telles que la création d'une connexion à une base de données MySQL,
	fermer la connexion et obtenir et définir les objets de connexion, d'instruction et d'ensemble de résultats.
	@author Taha RIDENE
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBAction {
  
  private static final String dbPath   = "jdbc:mysql://localhost:3306/bdconferences"; //N� de port mysql 3306, 8889 sous mac
  private static final String user     = "root";
  private static final String password = "root";
  private static Connection   con      = null;
  private static Statement    stm      = null;
  private static ResultSet    res      = null;
  private static int          erreur;

  /**

   *Etabli la connexion à la base de données mysql
   *@return une Exception si une erreur survient lors de la connexion, null sinon.
   */
  
  public static Exception DBConnexion() {
      try {
          Class.forName("com.mysql.jdbc.Driver").newInstance();
          con = DriverManager.getConnection(dbPath, user, password);
          stm = con.createStatement();
          return null;
      } catch (Exception e) {
          System.out.println("ERROR in Connexion to " + dbPath + " :" + e.getMessage());
          return e;
      }
  }
  
  /**

   *Ferme la connexion à la base de données
   *@return le code d'erreur
   */
  

  public static int DBClose() 
  {
      try {
          stm.close();
          con.close();
      } catch (Exception e) {
          System.out.println("ERROR in Connexion closure to " + dbPath + " : " + e.getMessage());
      }

      return erreur;
  }
  
  /**

   * Récupère la connexion
   * @return con
   */

  public static Connection getCon() {
      return con;
  }
  
  /**

   * Initialise la connexion
   * @return DBAction.con = con
   */

  public static void setCon(Connection con) {
      DBAction.con = con;
  }
  
  /**

   * Récupère le statement
   * @return stm
   */

  public static Statement getStm() {
      return stm;
  }
  
  /**

   * Initialise le statement
   * @return DBAction.stm = stm
   */

  public static void setStm(Statement stm) {
      DBAction.stm = stm;
  }
  
  /**

   * Récupère le résultat
   * @return res
   */

  public static ResultSet getRes() {
      return res;
  }
  
  /**

   * Initalise le résultat
   * @return DBAction.res = res
   */

  public static void setRes(ResultSet res) {
      DBAction.res = res;
  }
}


//~ Formatted by Jindent --- http://www.jindent.com
