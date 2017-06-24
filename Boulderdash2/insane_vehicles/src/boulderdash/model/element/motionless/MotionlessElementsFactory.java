package boulderdash.model.element.motionless;

/**
 * <h1>A factory to create MotionlessElements objects.</h1>
 *
 * @author Damien Watteau
 * @version 1.0
 */
public abstract class MotionlessElementsFactory {

    /** The Constant golem. */
    private static final Golem          golem          = new Golem();

    /** The Constant diamond. */
    private static final Diamond           diamond           = new Diamond();

    /** The Constant end. */
    private static final End   end   = new End();

    /** The Constant rock. */
    private static final Rock rock = new Rock();

    /** The Constant monster2. */
    private static final Monster2  monster2  = new Monster2();

    /** The Constant dig. */
    private static final Dig dig = new Dig();

    /** The Constant limit. */
    private static final Limit                LIMIT                = new Limit();

    /** The Constant way. */
    private static final Way             WAY             = new Way();

    /** The Constant monster. */
    private static final Monster            MONSTER            = new Monster();

    /**
     * The motionless elements is an array of all possible MotionlessElement.
     */
    private static MotionlessElement[]       motionlessElements  = {
        golem,
        diamond,
        end,
        rock,
        monster2,
        dig,
        WAY,
        MONSTER,
        LIMIT, };
    
    public static Diamond getDiamond(){
    	return diamond;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createGolem() {
        return golem;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDiamond() {
        return diamond;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createEnd() {
        return end;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createRock() {
        return rock;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createMonster2() {
        return monster2;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDig() {
        return dig;
    }

    /**
     * Creates a new macadam object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createWay() {
        return WAY;
    }

    /**
     * Creates a new obstacle object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createMonster() {
        return MONSTER;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createLimit() {
        return LIMIT;
    }

    /**
     * Gets the good MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return WAY;
    }
}
