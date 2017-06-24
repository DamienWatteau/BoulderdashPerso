package boulderdash.model;

import boulderdash.model.element.mobile.IMobile;

/**
 * <h1>The Interface IBoulderdashModel.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 * 
 */
public interface IBoulderdashModel {

    /**
     * Gets the map.
     *
     * @return the map
     */
    IMap getMap();

    /**
     * Gets the rockford.
     *
     * @return the rockford
     */
    IMobile getMyRockford();

}
