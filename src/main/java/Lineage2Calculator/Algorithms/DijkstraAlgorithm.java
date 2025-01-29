package Lineage2Calculator.Algorithms;

import Lineage2Calculator.Errors.ErrorHandling;
import Lineage2Calculator.DTOPathResult;
import Lineage2Calculator.Graph.Graph;

import java.util.*;

/**
 * The {@code DijkstraAlgorithm} class provides a method to find the cheapest teleport path
 * between towns using Dijkstra's algorithm.
 * <p>
 *     The algorithm calculates the minimum cost between the starting town and the destination town
 *     while considering all intermediate towns. It leverages a priority queue to ensure
 *     that towns with the lowest teleportation cost are prioritized.
 * </p>
 */
public class DijkstraAlgorithm {

/**
 * Finds the cheapest path between the starting town and destination town using Dijkstra's algorithm.
 * <p>
 *     This method takes a graph object and two town names (start and end) as parameters.
 *     It validates the existence of the towns in the graph, calculates the cheapest path
 *     and reconstructs the path.
 *</p>
 *
 * @param graph the {@link Graph} object representing the teleportation network.
 * @param startTown the name of starting town.
 * @param endTown the name of destination town.
 * @return a {@link DTOPathResult} object containing the cheapest path and the total cost of teleportation.
 * @throws IllegalArgumentException if the starting or destination town does not exist in graph or if they are the same.
 * @throws RuntimeException if no path can be found between the towns.
 */
    public static DTOPathResult findCheapestPath(Graph graph, String startTown, String endTown) {

        // Validate existence of startTown and endTown exist in the graph.
        ErrorHandling.validateTowns(graph, startTown, endTown);

        // The map that stores the lowest value (price) of reaching the city.
        Map<String, Integer> minCost = new HashMap<>();

        // The map that stores previously visited towns on the cheapest path (key - current town, value - previous town).
        Map<String, String> previousTown = new HashMap<>();

        // Stores towns which will be visited and prioritizes those with the lowest teleport price.
        PriorityQueue<String> queue = new PriorityQueue<>((town1, town2) -> minCost.get(town1) - minCost.get(town2));

        // Initialize teleportation cost for all towns as infinity and adds start town to queue with cost zero.
        for (String town : graph.getAdjacencyMap().keySet()) {
            minCost.put(town, Integer.MAX_VALUE);
        }
        minCost.put(startTown, 0);
        queue.add(startTown);

        // Main loop for Dijkstra's algorithm.
        while (!queue.isEmpty()) {
            String currentTown = queue.poll();

            if (currentTown.equals(endTown)) {
                break;
            }

            // Retrieves neighbors of current towns.
            Map<String, Integer> neighbors = graph.getNeighbors(currentTown);

            // Iterates through neighbors and updates cost.
            for (Map.Entry<String, Integer> entry : neighbors.entrySet()) {
                String neighbor = entry.getKey();
                int cost = entry.getValue();

                int newCost = minCost.get(currentTown) + cost;
                if (newCost < minCost.get(neighbor)) {
                    minCost.put(neighbor, newCost);
                    previousTown.put(neighbor, currentTown);
                    queue.add(neighbor);
                }
            }
        }

        // Reconstructs the path from destination town to starting town.
        List<String> path = new ArrayList<>();
        String step = endTown;
        while (step != null) {
            path.add(0, step);
            step = previousTown.get(step);
        }

        int totalCost = minCost.get(endTown);

        // Handles error when cannot find path from the start town to the destination town.
        if (totalCost == Integer.MAX_VALUE) {
            ErrorHandling.pathNotFound(startTown, endTown);
        }

        return DTOPathResult.forDijkstra(path, totalCost);
    }
}
