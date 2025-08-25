package l2calculator.Errors;

import l2calculator.Errors.CustomErrors.NoPathFoundException;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Centralized helper component for throwing consistent exceptions during input validation
 * and pathfinding operations.
 *
 * <p>
 *     This class encapsulates reusable error scenarios such as invalid town names, unknown algorithm types,
 *     duplicate start and end towns, or unreachable destinations. It is typically invoked from validation
 *     or algorithmic logic to ensure meaningful error reporting.
 * </p>
 *
 */
@Component
public class ErrorHandling {

    /**
     * Throws an exception indicating that the specified town is not present in the graph.
     *
     * @param town the name of the invalid town
     * @throws IllegalArgumentException always thrown to indicate the town does not exist
     */
    public void invalidTownNamesError(String town) {
        throw new IllegalArgumentException("The town \"" + town + "\" does not exist in the graph.");
    }

    /**
     * Throws an exception when the selected algorithm name is unsupported.
     *
     * @param algorithmType the invalid algorithm type
     * @throws IllegalArgumentException always thrown to indicate the algorithm type is unknown
     */
    public void invalidAlgorithmTypeError(String algorithmType) {
        throw new IllegalArgumentException("The algorithm type \"" + algorithmType + "\" does not exist.");
    }

    /**
     * Throws an exception when the starting and destination towns are identical.
     *
     * @throws IllegalArgumentException always thrown when towns are the same
     */
    public void sameTownsError() {
        throw new IllegalArgumentException("Starting town and destination town cannot be the same.");
    }

    /**
     * Throws an exception if the destination town is unreachable from the starting town.
     *
     * <p>
     *     This method checks whether {@code endTown} is present in the {@code previousTown} map,
     *     which typically represents the result of a BFS or Dijkstra traversal.
     * </p>
     *
     * @param previousTown the map containing traversal history
     * @param startTown the name of the starting town
     * @param endTown the name of the destination town
     * @throws NoPathFoundException if no valid path leads to the destination
     */
    public void pathNotFoundError(Map<String, String> previousTown, String startTown, String endTown) {
        if (!previousTown.containsKey(endTown)) {
            throw new NoPathFoundException("No path found from \"" + startTown + "\" to \"" + endTown + "\".");
        }
    }
}
