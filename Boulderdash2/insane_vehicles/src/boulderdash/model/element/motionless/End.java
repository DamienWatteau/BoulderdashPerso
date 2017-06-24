package boulderdash.model.element.motionless;

import boulderdash.model.element.Permeability;
import boulderdash.model.element.Sprite;

/**
 * <h1>The Class End.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 */
class End extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('(', "Door.png");

    /**
     * Instantiates a new end.
     */
    End() {
        super(SPRITE, Permeability.WIN);
    }
}
