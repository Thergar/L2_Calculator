package l2calculator.algorithms;


import l2calculator.errors.ErrorHandling;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Utility component responsible for reconstructing a path between towns based on traversal history.
 *
 * <p>
 *     This class uses a map of "previous town" references to rebuild the full path from a destination
 *     town back to the starting point. It is typically used by pathfinding algorithms
 *     such as BFS or Dijkstra after the graph traversal is complete.
 * </p>
 */
@Component
public class PathReconstruct {

    private final ErrorHandling errorHandling;

    public PathReconstruct(ErrorHandling errorHandling) {
        this.errorHandling = errorHandling;
    }

    /**
     * Reconstructs a complete path from the start town to the destination town based on the visited nodes map.
     *
     * <p>
     *     The map contains information about which town was visited before reaching another town,
     *     allowing reconstruction of the path by tracing backwards from the destination. If no path exists (the destination is not reachable),
     *     the method delegates error handling to {@link ErrorHandling#pathNotFoundError(Map, String, String)}.
     * </p>
     *
     * @param previousTown a map where key is a town name, and value is the preceding town.
     * @param endTown the name of the destination town.
     * @return a list of towns representing the path from the start to the destination.
     */

    protected List<String> reconstructPath(Map<String, String> previousTown, String startTown, String endTown) {

        LinkedList<String> path = new LinkedList<>();

        // Validate the input data using the error handling service
        errorHandling.pathNotFoundError(previousTown, startTown, endTown);

        String step = endTown;
        while (step != null) {
            path.addFirst(step);
            step = previousTown.get(step);
        }
        return path;
    }
}
