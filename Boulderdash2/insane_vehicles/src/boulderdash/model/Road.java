package boulderdash.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

import boulderdash.model.element.IElement;
import boulderdash.model.element.motionless.MotionlessElementsFactory;
import modele.dao.BddRequete;

/**
 * <h1>The Road Class.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 * 
 */
class Road extends Observable implements IRoad {

    /** The width. */
    private int          width;

    /** The height. */
    private int          height;

    /** The on the road. */
    private IElement[][] onTheRoad;

    /**
     * Instantiates a new road with the content of the file fileName.
     *
     * @param fileName
     *            the file name where the map of the road is
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    Road(final String fileName) throws IOException {
        super();
        this.loadFile(fileName);
    }

    /**
     * Loads file.
     *
     * @param fileName
     *            the file name
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void loadFile(final String fileName) throws IOException {

        this.setWidth(40);
        this.setHeight(22);
        this.onTheRoad = new IElement[this.getWidth()][this.getHeight()];
        BddRequete requete = new BddRequete ();
        String texte = requete.requestSelect(fileName);
        String ligne;

        int nbLignes = 22;
        int nbCol = 40;
        for (int lignCour = 0; lignCour < nbLignes; lignCour++){
            ligne = texte.substring(lignCour*42,(lignCour*42)+nbCol);
            //System.out.println(ligne);
            for(int colCour = 0; colCour < nbCol; colCour++){

                this.setOnTheRoadXY(MotionlessElementsFactory.getFromFileSymbol(ligne.toCharArray()[colCour]), colCour, lignCour);

            }

        }
        //System.out.println("fini");
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
    public final IElement getOnTheRoadXY(final int x, final int y) {
        return this.onTheRoad[x][y];
    }

    /**
     * Sets the on the road XY.
     *
     * @param element
     *            the element
     * @param x
     *            the x
     * @param y
     *            the y
     */
    public void setOnTheRoadXY(final IElement element, final int x, final int y) {
        this.onTheRoad[x][y] = element;
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
}
