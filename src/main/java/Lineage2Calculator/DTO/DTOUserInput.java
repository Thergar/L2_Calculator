package Lineage2Calculator.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class responsible for storing user inputs for the teleportation path Calculation.
 * <p>
 *     This class stores information about the starting town, destination town,
 *     and the type of algorithm to be used for path calculation.
 * </p>
 */
public class DTOUserInput {

    /** The name of the starting town. */
    @JsonProperty("startTown")
    private final String startTown;

    /** The name of destination town. */
    @JsonProperty("endTown")
    private final String endTown;

    /** The algorithm type to be used for route calculation. */
    @JsonProperty("algorithmName")
    private final String algorithmName;

    /**
     * Construct a new {@code UserInput} instance with the specified starting town,
     * destination town and algorithm type.
     **
     * @param startTown the name of the starting town.
     * @param endTown the name of destination town.
     * @param algorithmName the type of algorithm.
     */
    public DTOUserInput(@JsonProperty("startTown") String startTown,
                        @JsonProperty("endTown") String endTown,
                        @JsonProperty("algorithmName") String algorithmName) {
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
    public String getAlgorithmName() {
        return algorithmName;
    }
}
