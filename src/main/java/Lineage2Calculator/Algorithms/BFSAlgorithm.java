package Lineage2Calculator.Algorithms;

import Lineage2Calculator.DTOPathResult.DTOPathResult;
import Lineage2Calculator.DTOPathResult.DTOPathResultFactory;
import Lineage2Calculator.Errors.ErrorHandling;
import Lineage2Calculator.Graph.Graph;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * The {@code BFSAlgorithm} class provides a method to find the shortest teleport path
 * between towns using Breadth-First Search (BFS) algorithm.
 * <p>
 *     The algorithm calculates the fastest path between the starting town and the destination town,
 *     considering all intermediate towns.
 * </p>
 */
@Component
public class BFSAlgorithm implements PathfindingAlgorithm {

    private final PathReconstruct pathReconstruct;
    private final ErrorHandling errorHandling;

    public BFSAlgorithm(PathReconstruct pathReconstruct, ErrorHandling errorHandling) {
        this.pathReconstruct = pathReconstruct;
        this.errorHandling = errorHandling;
    }

    /**
     * Finds the shortest path between the starting town and destination town using BFS algorithm.
     * <p>
     * This method takes a Graph object and two town names (start and end) as parameters.
     * It validates the existence of the towns in the graph, calculates the shortest path.
     * </p>
     *
     * @param graph     the {@link Graph} object representing the teleportation network.
     * @param startTown the name of starting town.
     * @param endTown   the name of destination town.
     * @return a {@link DTOPathResult} object containing the shortest path, total cost of teleportation
     * and the number of steps along path.
     * @throws IllegalArgumentException if the starting or destination town does not exist in graph or if they are the same.
     * @throws RuntimeException         if no path can be found between the towns.
     */
    public DTOPathResult findShortestPath(Graph graph, String startTown, String endTown) {

        // Validate the existence of startTown and endTown exist in the graph.
        errorHandling.validateDistinctTowns(startTown, endTown);

        // Initialize a queue for towns to visit. BFS requires operations on first and last elements.
        Queue<String> queue = new LinkedList<>();

        // Map to store previous town in the shortest path.
        Map<String, String> previousTown = new HashMap<>();

        // Map to store teleportation cost for each town.
        Map<String, Integer> minCosts = new HashMap<>();

        // Initializes the starting path with the start town, add it to visited Set, and set its initial cost as zero.
        queue.add(startTown);
        previousTown.put(startTown, null);
        minCosts.put(startTown, 0);

        // Main loop for BFS algorithm.
        while (!queue.isEmpty()) {

            //Retrieve and remove the first path from the queue. Sets last town at path list as "current Town" and gets path costs.
            String currentTown = queue.poll();

            // If the current town is the destination town, break out from loop.
            if (currentTown.equals(endTown)) {
                break;
            }

            // Iterate through each neighbor town and its teleportation cost.
            for (Map.Entry<String, Integer> neighborEntry : graph.getNeighbors(currentTown).entrySet()) {

                String neighbor = neighborEntry.getKey();
                int cost = neighborEntry.getValue();

                // If the neighbor has not been visited yet, add it to visited Set.
                if (!previousTown.containsKey(neighbor)) {
                    previousTown.put(neighbor, currentTown);

                    //  Calculates the new teleportation cost and store it in pathCost Map.
                    minCosts.put(neighbor, minCosts.get(currentTown) + cost);
                    queue.add(neighbor);
                }
            }
        }

        List<String> path = pathReconstruct.reconstructPath(previousTown, startTown, endTown);
        int totalCost = minCosts.get(endTown);
        int step = path.size() - 1;

        return DTOPathResultFactory.forBFS(path, totalCost, step);
    }

    @Override
    public DTOPathResult algorithmPath(Graph graph, String startTown, String endTown) {
        return findShortestPath(graph, startTown, endTown);
    }
}
