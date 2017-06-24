package boulderdash.model.element;

import java.awt.Image;

import fr.exia.showboard.ISquare;

/**
 * <h1>The Element Class.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 * @see ISquare
 * 
 */
public abstract class Element implements IElement {

    /** The sprite. */
    private Sprite sprite;

    /** The permeability. */
    private Permeability permeability;

    /**
     * Instantiates a new element.
     *
     * @param sprite
     *            the sprite
     * @param permeability
     *            the permeability
     */
    public Element(final Sprite sprite, final Permeability permeability) {
        this.setSprite(sprite);
        this.setPermeability(permeability);
    }

    /**
     * Get Sprite
     * @return sprite
     */
    @Override
    public final Sprite getSprite() {
        return this.sprite;
    }

    /**
     * Sets the sprite.
     *
     * @param sprite
     *            the new sprite
     */
    public final void setSprite(final Sprite sprite) {
        this.sprite = sprite;
    }
    
    
    /**
     * Get the permeability of the block.
     *
     * @return permeability
     */
    @Override
    public final Permeability getPermeability() {
        return this.permeability;
    }

    /**
     * Sets the permeability.
     *
     * @param permeability
     *            the new permeability
     */
    private void setPermeability(final Permeability permeability) {
        this.permeability = permeability;
    }

    /**
     * Get image
     *
     * @return image
     */
    @Override
    public final Image getImage() {
        return this.getSprite().getImage();
    }
}
