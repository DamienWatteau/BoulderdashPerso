package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BddRequete {
	
	public void user (String nom){

		try {

	    Statement state = BoulderDashBDDConnector.getInstance().createStatement();


	    ResultSet result = state.executeQuery("SELECT * FROM players");
	    
	    int ID = 0;
	    String nomBDD = " ";
	    int nbrcolumn = 0;
	    
	    
	    result.last();
	    nbrcolumn = result.getRow();
	
	    // next() récupere la ligne
	    result.beforeFirst();
		    do{
		    	result.next();
		    	ID = result.getInt(1);
		    	nomBDD =result.getString(2);
		    }while(!(nom.equals(nomBDD)) && (ID != nbrcolumn));

		   //String sql = "{call insert_player("+nom+")}";
		    
			if(!nom.equals(nomBDD)){
				System.out.println("ERROR");
				Statement state2 = BoulderDashBDDConnector.getInstance().createStatement();

			    state2.executeUpdate("INSERT INTO players (player_name) VALUES ('"+nom+"') ");
				
			}
			else{
				System.out.println("Trouvé");
			}
	       
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
	}
	
	public String requestSelect(String level){

        try {

            // L'objet Statement permet d'exécuter des instructions SQL (Il interroge la base de donnée et retourne les résultats)
            Statement st; 

            // L'objet ResultSet stocke les résultats de Statement (soit les données de la BDD)
            ResultSet rst;

            st = BoulderDashBDDConnector.getInstance().createStatement();
            rst = st.executeQuery("SELECT * From maps WHERE map_name = '"+level+"'");
            // Retourne la première ligne
            rst.next();

                // Retourne le code de la map provenant de la base de donnée
                return rst.getString("map_code"); 

        } catch (Exception ex) {

            // Affiche l'exception et l'etat de la pile d'execution au moment de son appel
            ex.printStackTrace(); 
          }

        return null;
    }
}