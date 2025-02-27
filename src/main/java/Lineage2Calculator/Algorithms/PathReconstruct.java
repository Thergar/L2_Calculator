package Lineage2Calculator.Algorithms;

import Lineage2Calculator.Errors.ErrorHandling;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The {@code PathReconstruct} class provides helper methods to reconstruct a path
 * from a given map of previous towns.
 */
@Component
public class PathReconstruct {

    private final ErrorHandling errorHandling;

    /**
     * Constructor for dependency injection.
     *
     * @param errorHandling the error handling service.
     */
    public PathReconstruct(ErrorHandling errorHandling) {
        this.errorHandling = errorHandling;
    }

     /**
     * Reconstructs a path based on the provided map of previous towns.
     * <p>
     * The map contains information about which town was visited before reaching another town,
     * allowing reconstruction of the path by tracing backwards from the destination.
     * </p>
     *
     * @param previousTown a map where key is a town name, and value is the preceding town.
     * @param endTown the name of the destination town.
     * @return a list of towns representing the path from the start to the destination.
     */
    protected List<String> reconstructPath(Map<String, String> previousTown, String startTown, String endTown) throws IllegalArgumentException {

        LinkedList<String> path = new LinkedList<>();

        // Validate the input data using the error handling service
        errorHandling.pathNotFound(previousTown, startTown, endTown);

        // Reconstruct the path by tracing backwards from the end town
        String step = endTown;
        while (step != null) {
            path.addFirst(step);
            step = previousTown.get(step);
        }

        return path;
    }
}
