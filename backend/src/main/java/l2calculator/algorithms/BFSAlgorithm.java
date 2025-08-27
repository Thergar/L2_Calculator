package l2calculator.algorithms;


import l2calculator.graph.Graph;
import l2calculator.DTOPathResult;
import l2calculator.DTOPathResultFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * The {@code BFSAlgorithm} class provides a method to find the shortest teleport path
 * between towns using Breadth-First Search (BFS) algorithm.
 *
 * <p>
 *     The algorithm calculates the fastest path between the starting town and the destination town,
 *     considering all intermediate towns.
 * </p>
 */
@Component
public class BFSAlgorithm implements PathfindingAlgorithm {

    private final PathReconstruct pathReconstruct;

    /**
     * Constructs the BFS pathfinding algorithm with a path reconstruction helper.
     *
     * @param pathReconstruct utility used to reconstruct the full path from the traversal history
     */
    public BFSAlgorithm(PathReconstruct pathReconstruct) {
        this.pathReconstruct = pathReconstruct;
    }

    /**
     * Finds the shortest path between the starting town and destination town using BFS algorithm.
     *
     * <p>
     *     The algorithm explores the teleportation network in layers, ensuring the fastest route
     *     (in terms of steps, not necessarily cost) is returned. It keeps track of visited towns,
     *     calculates intermediate costs, and reconstructs the path after reaching the destination.
     * </p>
     *
     * @param graph     the {@link Graph} object representing the teleportation network.
     * @param startTown the name of starting town.
     * @param endTown   the name of destination town.
     * @return a {@link DTOPathResult} object containing the shortest path, total cost of teleportation
     * and the number of steps along path.
     */
    public DTOPathResult findShortestPath(Graph graph, String startTown, String endTown) {

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

        //Lineage2Calculator.backend.Main loop for BFS algorithm.
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

    /**
     * Standard interface method to return a BFS-based teleportation path.
     *
     * @param graph     the teleportation graph
     * @param startTown the starting town
     * @param endTown   the destination town
     * @return the calculated path and related metadata
     */
    @Override
    public DTOPathResult algorithmPath(Graph graph, String startTown, String endTown) {
        return findShortestPath(graph, startTown, endTown);
    }

    @Override
    public String getAlgorithmName() {
        return "BFS";
    }
}
