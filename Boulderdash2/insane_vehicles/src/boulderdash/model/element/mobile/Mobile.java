package boulderdash.model.element.mobile;

import java.awt.Point;

import boulderdash.model.IMap;
import boulderdash.model.element.Element;
import boulderdash.model.element.IElement;
import boulderdash.model.element.Permeability;
import boulderdash.model.element.Sprite;
import boulderdash.model.element.motionless.Diamond;
import boulderdash.model.element.motionless.MotionlessElementsFactory;
import fr.exia.showboard.IBoard;

/**
 * <h1>The Mobile Class.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 * 
 */
abstract class Mobile extends Element implements IMobile {

    /**
     * The x.
     */
    private Point position;

    /** The alive. */
    private Boolean alive = true;

    /** The map. */
    private IMap map;

    /** The board. */
    private IBoard  board;

    /**
     * Instantiates a new mobile.
     *
     * @param sprite
     *            the sprite
     * @param map
     *            the map
     * @param permeability
     *            the permeability
     */
    Mobile(final Sprite sprite, final IMap map, final Permeability permeability) {
        super(sprite, permeability);
        this.setMap(map);
        this.position = new Point();
    }

    /**
     * Instantiates a new mobile.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param sprite
     *            the sprite
     * @param map
     *            the map
     * @param permeability
     *            the permeability
     */
    Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
        this(sprite, map, permeability);
        this.setX(x);
        this.setY(y);
    }

    /**
     * Move up
     */
    @Override
    public void moveUp() {
        this.setY(this.getY() - 1);
        this.setHasMoved();
    }

    /**
     * Move on the left
     */
    @Override
    public void moveLeft() {
        this.setX(this.getX() - 1);
        this.setHasMoved();
    }

    /**
     * Move down
     */
    @Override
    public void moveDown() {
        this.setY(this.getY() + 1);
        this.setHasMoved();
        
//        if(this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability()==Permeability.DISAPPEAR){
////        	this.getRoad().getOnTheRoadXY(this.getX(), this.getY()).setSprite(MotionlessElementsFactory.getDiamond().getSprite());
//        	
//        	 IElement audessus = this.getMap().getOnTheMapXY(this.getX(),this.getY());
////             audessus = new Diamond();
//             audessus.setSprite(MotionlessElementsFactory.getDiamond().getSprite());
             
        }
        

    /**
     * Move on the right
     */
    @Override
    public void moveRight() {
        this.setX(this.getX() + 1);
        this.setHasMoved();
    }

    /**
     * No move
     */
    @Override
    public void doNothing() {
        this.setHasMoved();
    }

    /**
     * Sets the has moved.
     */
    private void setHasMoved() {
        this.getMap().setMobileHasChanged();
    }

    /**
     * Get the player position
     * @return x
     * 			The x position
     */
    @Override
    public final int getX() {
        return this.getPosition().x;
    }

    /**
     * Sets the x.
     *
     * @param x
     *            the new x
     */
    public final void setX(final int x) {
        this.getPosition().x = x;
        if (this.isCrashed()) {
            this.die();
        }
    }

    /**
     * Get the player's position in X
     * 
     * @return y
     * 		  	The y position
     * 
     */
    @Override
    public final int getY() {
        return this.getPosition().y;
    }

    /**
     * Sets the y.
     *
     * @param y
     *            the new y, as the road is an infinite loop, there's a modulo
     *            based on the map height.
     */
    public final void setY(final int y) {
        this.getPosition().y = (y + this.getMap().getHeight()) % this.getMap().getHeight();
        if (this.isCrashed()) {
            this.die();
        }
    }

    /**
     * Gets the map.
     *
     * @return the map
     */
    public IMap getMap() {
        return this.map;
    }

    /**
     * Sets the map.
     *
     * @param map
     *            the new map
     */
    private void setMap(final IMap map) {
        this.map = map;
    }

    /**
     * Check if rockford is alive
     * @return boolean
     *				 				
     */
    @Override
    public Boolean isAlive() {
        return this.alive;
    }

    /**
     * Dies.
     */
    public void die() {
        this.alive = false;
        this.setHasMoved();
    }

    /**
     * Check if rockford crashed
     * @return boolean
     * 				0 : Alive, 1 : Dead
     * 
     */
    @Override
    public Boolean isCrashed() {
        return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.KILLING;
    }
    
    /**
     * Checks if the player won
     * @return boolean
     * 				0 : Looser, 1 : Winner	
     * 
     */
    public Boolean isWon() {
        return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.WIN;
    }
    
    /**
     * Checks if the player is blocked
     * 
     * @return boolean
     * 				0 : There isn't a wall, 1 : There is a wall
     */
    public Boolean isBlocked() {
        return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
    }
    
    /**
     * Checks if there is a loot
     * 
     * @return boolean
     * 				0 : There isn't a loot, 1 : There is a loot
     */
    public Boolean isLootable() {
        return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.LOOTABLE;
    }
    
    /**
     * Checks if he can dig
     * 
     * @return boolean
     * 				0 : Rockford dig, 1 : Rockford doesn't dig
     */
    public Boolean isDesappear() {
        return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.DISAPPEAR;
    }
    
    /**
     * Get the player position
     * 
     * @return position
     * 				the position to get
     */
    @Override
    public Point getPosition() {
        return this.position;
    }

    /**
     * Sets the position.
     *
     * @param position
     *            the position to set
     */
    public void setPosition(final Point position) {
        this.position = position;
    }

    /**
     * Gets the board.
     *
     * @return the board
     */
    protected IBoard getBoard() {
        return this.board;
    }

}
