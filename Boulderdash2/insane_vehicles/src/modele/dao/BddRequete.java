package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import boulderdash.controller.BoulderdashController;

/**
 * <h1>The BddRequete Class.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 */
public class BddRequete {
	
	/**
	 * User request
	 *
	 * @param nom
	 *			The name of the player
	 */
	public void user (String nom){

		try {
			// The Statement object execute SQL instructions (it asks the database and it returns results)
		    Statement state = BoulderDashBDDConnector.getInstance().createStatement();
	
		    // The ResultSet object store Statement results (datas of the database)
		    ResultSet result = state.executeQuery("SELECT * FROM players");
		    
		    int ID = 0;
		    String nomBDD = " ";
		    int nbrcolumn = 0;
		    
		    result.last();
		    nbrcolumn = result.getRow();
		
		    result.beforeFirst();
		    do{
		    	result.next();
		    	ID = result.getInt(1);
		    	nomBDD =result.getString(2);
		    }while(!(nom.equals(nomBDD)) && (ID != nbrcolumn));
		    
			if(!nom.equals(nomBDD)){
				System.out.println("ERROR");
				Statement state2 = BoulderDashBDDConnector.getInstance().createStatement();

			    state2.executeUpdate("INSERT INTO players (player_name) VALUES ('"+nom+"') ");
				
			}
			else{
				System.out.println("Trouvé");
			}
	       
		  } catch (SQLException e) {
			  
			// Show the exeption and the execution stack status at the moment of his call
		    e.printStackTrace();
		  }
	}
	
	/**
	 * Request select
	 *
	 * @param level
	 *			The level
	 * @return map_code
	 * 				The code of the map
	 */	
	public String requestSelect(String level){

        try {

        	// The Statement object execute SQL instructions (it asks the database and it returns results)
            Statement st; 

            // The ResultSet object store Statement results (datas of the database)
            ResultSet rst;

            st = BoulderDashBDDConnector.getInstance().createStatement();
            rst = st.executeQuery("SELECT * From maps WHERE map_name = '"+level+"'");
            
            // Return the first line
            rst.next();

            	// Return the map code from the database
                return rst.getString("map_code"); 

        } catch (Exception ex) {

        	// Show the exeption and the execution stack status at the moment of his call
            ex.printStackTrace(); 
          }

        return null;
    }
	
//	public void requestScore (int ID_player, int ID_map){
//		
//		try {
//				Statement state3 = BoulderDashBDDConnector.getInstance().createStatement();
//
//			    //state2.executeUpdate("INSERT INTO players (player_name) VALUES ('"+nom+"') ");
//			    //state3.executeUpdate("INSERT INTO play (player_score, player_time, ID_player, ID_map) VALUES ("+score+", null,"+ID_player+","+ID_map+");");
//				//state3.executeUpdate("INSERT INTO play (player_score, player_time, ID_player, ID_map) VALUES ("+this.controller.getScore()+", null,"+ID_player+","+ID_map+");");
//	       
//		  } catch (SQLException e) {
//		    e.printStackTrace();
//		  }
//	}
}
	
