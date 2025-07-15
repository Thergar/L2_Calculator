package Lineage2Calculator.Algorithms;

import Lineage2Calculator.DTO.DTOPathResult;
import Lineage2Calculator.DTO.DTOPathResultFactory;
import Lineage2Calculator.Errors.Helper.NoPathFoundException;
import Lineage2Calculator.Graph.Graph;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * The {@code DijkstraAlgorithm} class provides a method to find the cheapest teleport path
 * between towns using Dijkstra's algorithm.
 *
 * <p>
 * This algorithm finds the path with the lowest total teleportation cost from a starting town
 * to a destination town within a {@link Graph}, considering all possible intermediate towns.
 * A priority queue is used to explore towns in order of increasing cost.
 * </p>
 *
 */
@Component
public class DijkstraAlgorithm implements PathfindingAlgorithm {

    private final PathReconstruct pathReconstruct;

    /**
     * Constructs the BFS pathfinding algorithm with a path reconstruction helper.
     *
     * @param pathReconstruct utility used to reconstruct the full path from the traversal history
     */
    public DijkstraAlgorithm(PathReconstruct pathReconstruct) {
        this.pathReconstruct = pathReconstruct;
    }

    /**
     * Finds the cheapest path between the starting town and destination town using Dijkstra's algorithm.
     *
     * <p>
     *     The algorithm iteratively explores neighboring towns, updating the minimum teleportation
     *     cost as it finds cheaper routes. After the destination is reached, the shortest-cost path
     *     is reconstructed.
     * </p>
     *
     * <p>
     *     This method may throw an error if no path exists (thrown by {@link NoPathFoundException}).
     * </p>
     * @param graph the {@link Graph} object representing the teleportation network.
     * @param startTown the name of starting town.
     * @param endTown the name of destination town.
     * @return a {@link DTOPathResult} object containing the cheapest path and the total cost of teleportation.
     */
    public DTOPathResult findCheapestPath(Graph graph, String startTown, String endTown) {

        // The map that stores the lowest value (price) of reaching the city.
        Map<String, Integer> minCost = new HashMap<>();

        // The map that stores previously visited towns on the cheapest path (key - current town, value - previous town).
        Map<String, String> previousTown = new HashMap<>();

        // Stores towns which will be visited and prioritizes those with the lowest teleport price.
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((Map.Entry.comparingByValue()));

        // Initialize teleportation cost for all towns as infinity and adds start town to queue with cost zero.
        for (String town : graph.getAdjacencyMap().keySet()) {
            minCost.put(town, Integer.MAX_VALUE);
        }
        minCost.put(startTown, 0);
        queue.add(new AbstractMap.SimpleEntry<>(startTown, 0));

        // Lineage2Calculator.Main loop for Dijkstra's algorithm.
        while (!queue.isEmpty()) {
            Map.Entry<String, Integer> currentEntry = queue.poll();
            String currentTown = currentEntry.getKey();

            if (currentTown.equals(endTown)) {
                break;
            }

            // Retrieves neighbors of current towns.
            //Map<String, Integer> neighbors = graph.getNeighbors(currentTown);

            // Iterates through neighbors and updates cost.
            for (Map.Entry<String, Integer> neighborEntry : graph.getNeighbors(currentTown).entrySet()) {

                String neighbor = neighborEntry.getKey();
                int cost = neighborEntry.getValue();

                int newCost = minCost.get(currentTown) + cost;
                if (newCost < minCost.get(neighbor)) {
                    minCost.put(neighbor, newCost);
                    previousTown.put(neighbor, currentTown);
                    queue.add(new AbstractMap.SimpleEntry<>(neighbor, newCost));
                }
            }
        }

        // Reconstructs the path from destination town to starting town.
        List<String> path = pathReconstruct.reconstructPath(previousTown, startTown, endTown);
        int totalCost = minCost.get(endTown);

        return DTOPathResultFactory.forDijkstra(path, totalCost);
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
    public DTOPathResult algorithmPath(Graph graph, String startTown, String endTown){
        return findCheapestPath(graph, startTown, endTown);
    }

    @Override
    public String getAlgorithmName() {
        return "Dijkstra";
    }
}
