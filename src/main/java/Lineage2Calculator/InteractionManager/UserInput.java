package Lineage2Calculator.InteractionManager;

import Lineage2Calculator.Enum.AlgorithmType;

/**
 * Class responsible for storing user inputs related to L2Calculator.
 * <p>
 *     This class holds information about the starting town, destination town,
 *     and the type of algorithm to be used for path calculation.
 * </p>
 */
public class UserInput {

/** The name of the starting town. */
    protected String startTown;

/** The name of destination town. */
    protected String endTown;

/** The algorithm type to be used for route calculation. */
    protected AlgorithmType pathType;

/**
 * Construct a new {@code UserInput} instance with the specified starting town,
 * destination town and algorithm type.
 *
 * @param startTown the name of the starting town.
 * @param endTown the name of destination town.
 * @param pathType the type of algorithm, as defined in {@link AlgorithmType}.
 * */
    public UserInput(String startTown, String endTown, AlgorithmType pathType) {
        this.startTown = startTown;
        this.endTown = endTown;
        this.pathType = pathType;
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
 * */
    public AlgorithmType getPathType() {
        return pathType;
    }
}
