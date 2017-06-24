package boulderdash.model;

import java.io.IOException;
import java.util.Observable;

import boulderdash.model.element.IElement;
import boulderdash.model.element.motionless.MotionlessElementsFactory;
import modele.dao.BddRequete;

/**
 * <h1>The Map Class.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 * 
 */
class Map extends Observable implements IMap {

    /** The width. */
    private int width;

    /** The height. */
    private int height;

    /** The on the map. */
    private IElement[][] onTheMap;
    
//    private final int score = 5;

    /**
     * Instantiates a new level.
     *
     * @param level
     *            level name
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    Map(final String levelName) throws IOException {
        super();
        this.loadLevel(levelName);
    }

    /**
     * Loads file.
     *
     * @param fileName
     *            the file name
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void loadLevel(final String levelName) throws IOException {

        this.setWidth(40);
        this.setHeight(22);
        this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
        BddRequete requete = new BddRequete ();
        String texte = requete.requestSelect(levelName);
        String ligne;

        int nbLignes = 22;
        int nbCol = 40;
        for (int lignCour = 0; lignCour < nbLignes; lignCour++){
            ligne = texte.substring(lignCour*42,(lignCour*42)+nbCol);
            //System.out.println(ligne);
            for(int colCour = 0; colCour < nbCol; colCour++){

                this.setOnTheMapXY(MotionlessElementsFactory.getFromFileSymbol(ligne.toCharArray()[colCour]), colCour, lignCour);

            }

        }
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IRoad#getWidth()
     */
    @Override
    public final int getWidth() {
        return this.width;
    }

    /**
     * Sets the width.
     *
     * @param width
     *            the new width
     */
    private void setWidth(final int width) {
        this.width = width;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IRoad#getHeight()
     */
    @Override
    public final int getHeight() {
        return this.height;
    }

    /**
     * Sets the height.
     *
     * @param height
     *            the new height
     */
    private void setHeight(final int height) {
        this.height = height;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IRoad#getOnTheRoadXY(int, int)
     */
    @Override
    public final IElement getOnTheMapXY(final int x, final int y) {
        return this.onTheMap[x][y];
    }

    /**
     * Sets the on the map XY.
     *
     * @param element
     *            the element
     * @param x
     *            the x
     * @param y
     *            the y
     */
    public void setOnTheMapXY(final IElement element, final int x, final int y) {
        this.onTheMap[x][y] = element;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IRoad#setMobileHasChanged()
     */
    @Override
    public final void setMobileHasChanged() {
        this.setChanged();
        this.notifyObservers();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IRoad#getObservable()
     */
    @Override
    public Observable getObservable() {
        return this;
    }
    
//    public int scoreNeeded (){
//    	return this.score;
//    }
}
