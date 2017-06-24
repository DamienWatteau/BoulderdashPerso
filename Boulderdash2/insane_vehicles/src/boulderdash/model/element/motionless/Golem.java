package boulderdash.model.element.motionless;

import boulderdash.model.element.Permeability;
import boulderdash.model.element.Sprite;

/**
 * <h1>The Golem Class.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 */
class Golem extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(']', "golem.png");

    /**
     * Instantiates a new golem.
     */
    Golem() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
