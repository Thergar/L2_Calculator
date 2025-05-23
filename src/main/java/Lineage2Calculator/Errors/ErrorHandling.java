package Lineage2Calculator.Errors;

import Lineage2Calculator.Errors.CustomErrors.NoPathFoundException;
import Lineage2Calculator.Graph.Graph;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The {@code ErrorHandling} class provides methods for validating
 * towns and handling errors related to teleportation path. It ensures that the provided towns are valid and throws
 * defined exceptions when certain conditions are not met.
 *
 * <p>
 *     This class is intended to be used together with the {@link Graph} class
 *     to validate inputs and manages errors.
 * </p>
 */
@Component
public class ErrorHandling {


    /**
     * Validates if the provided town name exists in the list of towns.
     *
     * <p>
     *     Throws an exception and message if the town name is invalid.
     * </p>
     * @param town the name of town to validate.
     * @param validTown list of valid town names.
     * @throws IllegalArgumentException if the town name does not exist in the validTown list.
     */
    public void validateTownName(String town, Set<String> validTown) {
        if (!validTown.contains(town)) {
            throw new IllegalArgumentException("The town \"" + town + "\" does not exist in the graph.");
        }
    }

    /**
     * Validates if the provided algorithm type exists in the set of supported algorithm types.
     *
     * @param algorithmType the name of the algorithm type to validate.
     * @param algorithmNames a set of valid algorithm names.
     * @throws IllegalArgumentException if the provided algorithm type does not exist in the set of valid algorithm names.
     */
    public void validateAlgorithmType(String algorithmType, Set<String> algorithmNames) {
        if (!algorithmNames.contains(algorithmType)) {
            throw new IllegalArgumentException("The algorithm type \"" + algorithmType + "\" does not exist.");
        }
    }

    /**
     * Validates the starting town and destination.
     * Ensure that both towns are not the same.
     *
     * @param startTown the name of starting town.
     * @param endTown the name of destination town.
     */
    public void validateDistinctTowns(String startTown, String endTown) {
        if (startTown.equals(endTown)) {
            throw new IllegalArgumentException("Starting town and destination town cannot be the same.");
        }
    }

    /**
    * Throws exception when no path exist from starting town to destination town.
    *
    *  @param startTown the name of starting town.
    *  @param endTown the name of destination town.
    */
    public void pathNotFound(Map<String, String> previousTown, String startTown, String endTown) {
        if (!previousTown.containsKey(endTown)) {
            throw new NoPathFoundException("No path found from \"" + startTown + "\" to \"" + endTown + "\".");
        }
    }
}
