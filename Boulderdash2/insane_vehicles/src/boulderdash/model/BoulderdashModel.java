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

    /** The map. */
    private IMap map;

    /** The rockford. */
    private IMobile rockford;

    /**
     * Instantiates a new model.
     *
     * @param level
     *            the level name
     * @param rockfordStartX
     *            the rockford start X
     * @param rockford StartY
     *            the rockford start Y
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public BoulderdashModel(final String level, final int rockfordStartX, final int rockfordStartY)
            throws IOException {
        this.setMap(new Map(level));
        this.setRockford(new Rockford(rockfordStartX, rockfordStartY, this.getMap()));
    }

    /**
     * Get the map
     * 
     * @return map
     * 			the map
     */
    @Override
    public final IMap getMap() {
        return this.map;
    }

    /**
     * Sets the map.
     *
     * @param map
     *            the map to set
     */
    private void setMap(final IMap map) {
        this.map = map;
    }

    /**
     * Get the Rockford
     * 
     * @return rockford
     */
    @Override
    public final IMobile getMyRockford() {
        return this.rockford;
    }

    /**
     * Sets the rockford
     *
     * @param rockford
     *            the rockford to set
     */
    private void setRockford(final IMobile rockford) {
        this.rockford = rockford;
    }
}
