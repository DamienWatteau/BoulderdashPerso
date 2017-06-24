package boulderdash.model.element.motionless;

import boulderdash.model.element.Permeability;
import boulderdash.model.element.Sprite;

/**
 * <h1>The Limit Class.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 */
class Limit extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('X', "LimitBlock.png");

    /**
     * Instantiates a new limit.
     */
    Limit() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
