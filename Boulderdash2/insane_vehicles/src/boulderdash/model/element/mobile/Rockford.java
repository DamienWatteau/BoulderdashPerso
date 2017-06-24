package boulderdash.model.element.mobile;

import java.io.IOException;

import boulderdash.model.IMap;
import boulderdash.model.element.Permeability;
import boulderdash.model.element.Sprite;

/**
 * <h1>The Rockford Class.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 * 
 */
public class Rockford extends Mobile {

	/** The Constant SPRITE. */
    private static final Sprite sprite = new Sprite('H', "Rockford.png");

    /** The Constant spriteTurnLeft. */
    private static final Sprite spriteTurnLeft = new Sprite('H', "Left.png");

    /** The Constant spriteTurnRight. */
    private static final Sprite spriteTurnRight = new Sprite('H', "Right.png");
    
    /** The Constant spriteTurnRight. */
    private static final Sprite spriteUp = new Sprite('H', "Up.png");
    
    /** The Constant spriteTurnRight. */
    private static final Sprite spriteDown = new Sprite('H', "Down.png");

    /** The Constant spriteExplode. */
    private static final Sprite spriteDie   = new Sprite('H', "Die.png");

    /**
     * Instantiates a new rockford.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param road
     *            the map
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Rockford(final int x, final int y, final IMap map) throws IOException {
        super(x, y, sprite, map, Permeability.PENETRABLE); // BLOCKING 
        spriteTurnLeft.loadImage();
        spriteTurnRight.loadImage();
        spriteDie.loadImage();
        spriteUp.loadImage();
        spriteDown.loadImage();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
     */
    @Override
    public final void moveLeft() {
        super.moveLeft();
        this.setSprite(spriteTurnLeft);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveRight() {
        super.moveRight();
        this.setSprite(spriteTurnRight);
    }
    
    public final void moveUp() {
        super.moveUp();
        this.setSprite(spriteUp);
    }
    
    public final void moveDown() {
        super.moveDown();
        this.setSprite(spriteDown);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#die()
     */
    @Override
    public final void die() {
        super.die();
        this.setSprite(spriteDie);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#doNothing()
     */
    @Override
    public final void doNothing() {
        super.doNothing();
        this.setSprite(sprite);
    }
}
