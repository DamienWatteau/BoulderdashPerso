package boulderdash.model.element.motionless;

import boulderdash.model.element.Permeability;
import boulderdash.model.element.Sprite;

/**
 * <h1>The Class Monster2.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 */
class Monster2 extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('}', "poule.png");

    /**
     * Instantiates a new monster2.
     */
    Monster2() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
