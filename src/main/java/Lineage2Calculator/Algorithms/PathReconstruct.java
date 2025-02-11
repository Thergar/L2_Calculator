package Lineage2Calculator.Algorithms;

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

    protected List<String> reconstructPath(Map<String, String> previousTown, String endTown) {

        LinkedList<String> path = new LinkedList<>();
        String step = endTown;
        while (step != null) {
            path.addFirst(step);
            step = previousTown.get(step);
        }
        return path;
    }
}
