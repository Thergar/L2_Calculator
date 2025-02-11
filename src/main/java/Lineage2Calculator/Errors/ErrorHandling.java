package Lineage2Calculator.Errors;

import Lineage2Calculator.Graph.Graph;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public void validateTownName(String town, List<String> validTown) {
        if (!validTown.contains(town)) {
            throw new IllegalArgumentException("The town \"" + town + "\" does not exist in the graph.");
        }
    }

    /**
     * Validates the starting town and destination town in the graph.
     * Ensure that both towns exists in the graph and are not the same.
     *
     * @param graph the graph containing towns and teleportation routes.
     * @param startTown the name of starting town.
     * @param endTown the name of destination town.
     */
    public void validatePathBetweenTowns(Graph graph, String startTown, String endTown) {
        if (!graph.containsTowns(startTown)) {
            throw new IllegalArgumentException("Starting town \"" + startTown + "\" does not exist in the graph.");
        } else if (!graph.containsTowns(endTown)) {
            throw new IllegalArgumentException("Destination town \"" + endTown + "\" does not exist in the graph.");
        } else if (startTown.equals(endTown)) {
            throw new IllegalArgumentException("Starting town and destination town cannot be the same.");
        }
    }

    /**
    * Throws exception when no path exist from starting town to destination town.
    *
    *  @param startTown the name of starting town.
    *  @param endTown the name of destination town.
    */
    public void pathNotFound(String startTown, String endTown) {
        throw new IllegalArgumentException("No path found from \"" + startTown + "\" to \"" + endTown + "\".");
    }
}
