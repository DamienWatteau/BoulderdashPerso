package modele.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <h1>The BoulderDashBDDConnector Class.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 */
public class BoulderDashBDDConnector {

	  //Objet Connection
	  private static Connection connect;
	   
	  //Constructeur privé
	  private BoulderDashBDDConnector(){
	    
	  }
	   
	  
	  /**
	   * Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
	   *
	   * @return connect
	   *			connection with the database
	   */
	  public static Connection getInstance(){
		  if(connect == null){
			  try {
				  //String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
				  String JDBC_DRIVER = "com.mysql.jdbc.Driver";
					
				//Register JDBC driver
	            try {
					Class.forName(JDBC_DRIVER);
				} catch (ClassNotFoundException e) {
					
					// Affiche l'exception et l'etat de la pile d'execution au moment de son appel
					e.printStackTrace();
				} 
	            
				//URL de connexion
				  String url = "jdbc:mysql://localhost/boulderdash?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				  //Nom du user
				  String user = "root";
				  //Mot de passe de l'utilisateur
				  String passwd = "";
			      connect = DriverManager.getConnection(url, user, passwd);
			    } catch (SQLException e) {
			    	// Affiche l'exception et l'etat de la pile d'execution au moment de son appel
			    	e.printStackTrace();
			    }
		    System.out.println("INSTANCIATION DE LA CONNEXION SQL ! ");
		  }
		  else{
		    System.out.println("CONNEXION SQL EXISTANTE ! ");
		  }
		  return connect;   
		}
}