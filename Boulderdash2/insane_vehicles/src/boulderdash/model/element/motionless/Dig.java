package boulderdash.model.element.motionless;

import boulderdash.model.element.Permeability;
import boulderdash.model.element.Sprite;

/**
 * <h1>The Class Dig.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 */
class Dig extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(')', "Dig.png");

    /**
     * Instantiates a new dig.
     */
    Dig() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
