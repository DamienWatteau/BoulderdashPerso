package boulderdash.model.element.motionless;

import boulderdash.model.element.Permeability;
import boulderdash.model.element.Sprite;

/**
 * <h1>The Diamond Class.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 */
public class Diamond extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('[', "Diamond.png");

    /**
     * Instantiates a new diamond.
     */
    public Diamond() {
        super(SPRITE, Permeability.LOOTABLE);
    }
}
