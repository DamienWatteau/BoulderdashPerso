package boulderdash.model.element;

import java.awt.Image;

import fr.exia.showboard.ISquare;

/**
 * <h1>The Interface IElement.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 * @see ISquare
 * 
 */
public interface IElement extends ISquare {

    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    Sprite getSprite();

    /**
     * Gets the permeability.
     *
     * @return the permeability
     */
    Permeability getPermeability();

    /**
     * Get image
     *
     * @return image
     */
    @Override
    Image getImage();
    
    /**
     * Sets the sprite.
     *
     * @param sprite
     *            the new sprite
     */
    void setSprite(final Sprite sprite);

}
