package boulderdash.model;

import boulderdash.model.element.mobile.IMobile;

/**
 * <h1>The Interface IInsaneVehiclesModel.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 */
public interface IBoulderdashModel {

    /**
     * Gets the road.
     *
     * @return the road
     */
    IRoad getRoad();

    /**
     * Gets the my vehicle.
     *
     * @return the myVehicle
     */
    IMobile getMyVehicle();

}
