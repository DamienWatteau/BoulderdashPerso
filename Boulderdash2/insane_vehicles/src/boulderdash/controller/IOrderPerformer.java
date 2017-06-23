package boulderdash.controller;

import java.io.IOException;

/**
 * <h1>The Interface IOrderPerformed.</h1>
 * 
 * @author Damien Watteau
 * @version 1.0
 */
public interface IOrderPerformer {

    /**
     * Order perform.
     *
     * @param userOrder
     *            the user order
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    void orderPerform(UserOrder userOrder) throws IOException;

}
