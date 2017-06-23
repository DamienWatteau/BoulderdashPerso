package boulderdash;

import java.io.IOException;
import boulderdash.controller.BoulderdashController;
import boulderdash.controller.IBoulderdashController;
import boulderdash.model.BoulderdashModel;
import boulderdash.model.IBoulderdashModel;
import boulderdash.view.BoulderdashView;
import boulderdash.view.Menu;
import modele.dao.BddRequete;

/**
 * <h1>The InsaneVehicles Class.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 * 
 */
public abstract class Main {

    /** The Constant startX. */
    private static final int startX = 2;

	/** The Constant startY. */
	private static final int startY = 2;
	

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public static void main(final String[] args) throws IOException, InterruptedException {
		
		Menu menu = new Menu();
		BddRequete requete = new BddRequete();
		String level;
		
		// Inscrit le joueur dans la base de donnée
		requete.user(menu.menuPseudo());
		
		// Recupere le choix du niveau
  	   	level = menu.menuLevel();
  	   	
		final IBoulderdashModel model = new BoulderdashModel(level, startX, startY);
		final BoulderdashView view = new BoulderdashView(model.getRoad(), model.getMyRockford());
		final IBoulderdashController controller = new BoulderdashController(view, model);
		view.setOrderPerformer(controller.getOrderPeformer());
		
		controller.play();
	}
}
