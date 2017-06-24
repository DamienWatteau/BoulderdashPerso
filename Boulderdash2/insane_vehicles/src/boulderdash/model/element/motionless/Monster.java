package boulderdash.model.element.motionless;

import boulderdash.model.element.Permeability;
import boulderdash.model.element.Sprite;

/**
 * <h1>The Class Monster.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 */
class Monster extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('^', "Monster.png");

    /**
     * Instantiates a new monster.
     */
    Monster() {
        super(SPRITE, Permeability.KILLING);
    }
}
