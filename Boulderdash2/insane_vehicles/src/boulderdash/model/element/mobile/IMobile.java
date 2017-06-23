package boulderdash.model.element.mobile;

import java.awt.Point;

import boulderdash.model.element.IElement;
import fr.exia.showboard.IPawn;

/**
 * <h1>The Interface IMobile.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 * @see IPawn
 * @see IElement
 * 
 */
public interface IMobile extends IPawn, IElement {

    /**
     * Move up.
     */
    void moveUp();

    /**
     * Move left.
     */
    void moveLeft();

    /**
     * Move down.
     */
    void moveDown();

    /**
     * Move right.
     */
    void moveRight();

    /**
     * Do nothing.
     */
    void doNothing();
    
    void die();

    /**
     * Gets the x.
     *
     * @return the x
     */
    @Override
    int getX();

    /**
     * Gets the y.
     *
     * @return the y
     */
    @Override
    int getY();

    /**
     * Checks if is alive.
     *
     * @return the alive
     */
    Boolean isAlive();

    /**
     * Checks if the car crashed.
     *
     * @return the boolean
     */
    Boolean isCrashed();
    
    /**
     * Checks if the player won
     *
     * @return the boolean
     */
    Boolean isWon();
    
    /**
     * Check si il y a un loot
     *
     * @return the boolean
     */
    Boolean isLootable();
    
    /**
     * Check si le joueur est blocked
     *
     * @return the boolean
     */
    Boolean isBlocked();
    
    /**
     * Check si il peut creuser
     *
     * @return the boolean
     */
    Boolean isDesappear();


    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.IPawn#getPosition()
     */
    @Override
    Point getPosition();

}
