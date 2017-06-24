package boulderdash.model.element.mobile;

import java.awt.Point;

import boulderdash.model.element.IElement;
import fr.exia.showboard.IPawn;

/**
 * <h1>The Interface IMobile.</h1>
 *
 * @author Damien Watteau, Sophien Gardey
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
    
    /**
     * Do die
     */
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
     * 					0 : There isn't a wall, 1 : There is a wall
     */
    Boolean isCrashed();
    
    /**
     * Checks if the player won
     *
     * @return the boolean
     * 					0 : Looser, 1 : Winner
     */
    Boolean isWon();
    
    /**
     * Checks if there is a loot
     *
     * @return the boolean
     * 					0 : There isn't a loot, 1 : There is a loot
     */
    Boolean isLootable();
    
    /**
     * Checks if the player is blocked
     *
     * @return the boolean
     * 					
     */
    Boolean isBlocked();
    
    /**
     * Checks if he can dig
     *
     * @return the boolean
     * 					0 : Rockford dig, 1 : Rockford doesn't dig
     */
    Boolean isDesappear();

    /**
     * Get the player position
     */
    @Override
    Point getPosition();

}
