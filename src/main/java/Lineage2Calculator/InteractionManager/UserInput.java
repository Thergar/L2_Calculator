package Lineage2Calculator.InteractionManager;

/**
 * Class responsible for storing user inputs for the teleportation path Calculation.
 * <p>
 *     This class stores information about the starting town, destination town,
 *     and the type of algorithm to be used for path calculation.
 * </p>
 */
public class UserInput {

    /** The name of the starting town. */
    private final String startTown;

    /** The name of destination town. */
    private final String endTown;

    /** The algorithm type to be used for route calculation. */
    private final String algorithmName;

    /**
     * Construct a new {@code UserInput} instance with the specified starting town,
     * destination town and algorithm type.
     **
     * @param startTown the name of the starting town.
     * @param endTown the name of destination town.
     * @param algorithmName the type of algorithm.
     */
    public UserInput(String startTown, String endTown, String algorithmName) {
        this.startTown = startTown;
        this.endTown = endTown;
        this.algorithmName = algorithmName;
    }

    /**
     * Retrieves the value of the {@code startTown} variable.
     *
     * @return the name of starting town.
     */
    public String getStartTown() {
        return startTown;
    }

    /**
     * Retrieves the value of the {@code endTown} variable.
     * @return the name of destination town.
     */
    public String getEndTown() {
        return endTown;
    }

    /**
     * Retrieves the value of the {@code pathType} variable.
     *
     * @return the type of algorithm for path calculation.
     */
    public String getPathType() {
        return algorithmName;
    }
}
