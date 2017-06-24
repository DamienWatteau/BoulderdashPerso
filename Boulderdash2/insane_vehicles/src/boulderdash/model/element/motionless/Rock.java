package boulderdash.model.element.motionless;

import boulderdash.model.element.Permeability;
import boulderdash.model.element.Sprite;

/**
 * <h1>The Class Rock.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 */
class Rock extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('{', "Rock.png");

    /**
     * Instantiates a new rock.
     */
    Rock() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
