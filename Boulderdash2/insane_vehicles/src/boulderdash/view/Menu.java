package boulderdash.view;

import javax.swing.JOptionPane;

/**
 * <h1>The Menu Class.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 */
public class Menu {

		@SuppressWarnings("static-access")
		public String menuPseudo(){
		JOptionPane jop = new JOptionPane();
	    String nom = jop.showInputDialog(null, "Veuillez écrire votre pseudo !", "BoulderDash", JOptionPane.QUESTION_MESSAGE);
		
			return nom;
	    
		}
		
		@SuppressWarnings("static-access")
		public String menuLevel(){
			String[] levelname = {"Level 1", "Level 2", "Level 3", "Level 4", "Level 5"};
		    JOptionPane jop2 = new JOptionPane();
		    String level = (String)jop2.showInputDialog(null, 
		      "Veuillez indiquer un niveau !",
		      "Boulderdash",
		      JOptionPane.QUESTION_MESSAGE,
		      null,
		      levelname,
		      levelname[0]);
		    
		    	return level;
			}

	}