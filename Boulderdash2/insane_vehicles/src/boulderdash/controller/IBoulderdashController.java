package boulderdash.controller;

/**
 * <h1>The Interface IBoulderdasController.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 * @see IOrderPerformer
 * 
 */
public interface IBoulderdashController {

    /**
     * Play.
     *
     * @throws InterruptedException
     *             the interrupted exception
     */
    void play() throws InterruptedException;

    /**
     * Gets the order peformer.
     *
     * @return the order peformer
     */
    IOrderPerformer getOrderPeformer();
}
