package boulderdash.model;

import java.io.IOException;

import boulderdash.model.element.mobile.IMobile;
import boulderdash.model.element.mobile.Rockford;

/**
 * <h1>The Class BoulderdashModel.</h1>
 * 
 * @author Damien Watteau
 * @version 1.0
 * 
 */
public class BoulderdashModel implements IBoulderdashModel {

    /** The road. */
    private IMap   map;

    /** The my vehicle. */
    private IMobile rockford;

    /**
     * Instantiates a new insane vehicles model.
     *
     * @param fileName
     *            the file name
     * @param myVehicleStartX
     *            the my vehicle start X
     * @param myVehicleStartY
     *            the my vehicle start Y
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public BoulderdashModel(final String level, final int rockfordStartX, final int rockfordStartY)
            throws IOException {
        this.setRoad(new Map(level));
        this.setRockford(new Rockford(rockfordStartX, rockfordStartY, this.getRoad()));
    }

    /* (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IInsaneVehiclesModel#getRoad()
     */
    @Override
    public final IMap getRoad() {
        return this.map;
    }

    /**
     * Sets the road.
     *
     * @param road
     *            the road to set
     */
    private void setRoad(final IMap map) {
        this.map = map;
    }

    /* (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IInsaneVehiclesModel#getMyVehicle()
     */
    @Override
    public final IMobile getMyRockford() {
        return this.rockford;
    }

    /**
     * Sets the my vehicle.
     *
     * @param myVehicle
     *            the myVehicle to set
     */
    private void setRockford(final IMobile rockford) {
        this.rockford = rockford;
    }

}
