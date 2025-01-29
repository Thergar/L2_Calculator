package Lineage2Calculator.Errors;

import Lineage2Calculator.Graph.Graph;

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
public class ErrorHandling {

    /**
     * Validates the starting town and destination town in the graph.
     * Ensure that both towns exists in the graph and are not the same.
     *
     * @param graph the graph containing towns and teleportation routes.
     * @param startTown the name of starting town.
     * @param endTown the name of destination town.
     */
    public static void validateTowns(Graph graph, String startTown, String endTown) {
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
    public static void pathNotFound(String startTown, String endTown) {
        throw new IllegalArgumentException("No path found from \"" + startTown + "\" to \"" + endTown + "\".");
    }
}
