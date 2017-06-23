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
	
	    // next() r�cupere la ligne
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
				System.out.println("Trouv�");
			}
	       
		  } catch (SQLException e) {
		    e.printStackTrace();
		  }
	}
	
	public String requestSelect(String level){

        try {

            // L'objet Statement permet d'ex�cuter des instructions SQL (Il interroge la base de donn�e et retourne les r�sultats)
            Statement st; 

            // L'objet ResultSet stocke les r�sultats de Statement (soit les donn�es de la BDD)
            ResultSet rst;

            st = BoulderDashBDDConnector.getInstance().createStatement();
            rst = st.executeQuery("SELECT * From maps WHERE map_name = '"+level+"'");
            // Retourne la premi�re ligne
            rst.next();

                // Retourne le code de la map provenant de la base de donn�e
                return rst.getString("map_code"); 

        } catch (Exception ex) {

            // Affiche l'exception et l'etat de la pile d'execution au moment de son appel
            ex.printStackTrace(); 
          }

        return null;
    }
}