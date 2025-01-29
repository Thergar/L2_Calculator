package Lineage2Calculator.Algorithms;

import Lineage2Calculator.Errors.ErrorHandling;
import Lineage2Calculator.DTOPathResult;
import Lineage2Calculator.Graph.Graph;

import java.util.*;

/**
 * The {@code BFSAlgorithm} class provides a method to find the shortest teleport path
 * between towns using Breadth-First Search (BFS) algorithm.
 * <p>
 *     The algorithm calculates the fastest path between the starting town and the destination town,
 *     considering all intermediate towns.
 * </p>
 */
public class BFSAlgorithm {

/**
 * Finds the shortest path between the starting town and destination town using BFS algorithm.
 * <p>
 *     This method takes a Graph object and two town names (start and end) as parameters.
 *     It validates the existence of the towns in the graph, calculates the shortest path.
 *</p>
 *
 * @param graph the {@link Graph} object representing the teleportation network.
 * @param startTown the name of starting town.
 * @param endTown the name of destination town.
 * @return a {@link DTOPathResult} object containing the shortest path, total cost of teleportation
 *         and the number of steps along path.
 * @throws IllegalArgumentException if the starting or destination town does not exist in graph or if they are the same.
 * @throws RuntimeException if no path can be found between the towns.
 */
    public static DTOPathResult findShortestPath (Graph graph, String startTown, String endTown) {

        // Validate the existence of startTown and endTown exist in the graph.
        ErrorHandling.validateTowns(graph, startTown, endTown);

        // Initialize a queue for towns to visit. BFS requires operations on first and last elements.
        Queue<List<String>> queue = new LinkedList<>();

        // Set for visited towns to avoid revisiting the same town.
        Set<String> visited = new HashSet<>();

        // Map to store teleportation cost for each path.
        Map<List<String>, Integer> pathCosts = new HashMap<>();

        // Initializes the starting path with the start town, add it to visited Set, and set its initial cost as zero.
        List<String> startPath = Collections.singletonList(startTown);
        queue.add(startPath);
        visited.add(startTown);
        pathCosts.put(startPath, 0);

        // Main loop for BFS algorithm.
        while (!queue.isEmpty()) {

            //Retrieve and remove the first path from the queue. Sets last town at path list as "current Town" and gets path costs.
            List<String> path = queue.poll();
            String currentTown = path.get(path.size() - 1);
            int totalCost = pathCosts.get(path);

            // If the current town is the destination, return the DTOPathResult with detail associated with BFS algorithm.
            if (currentTown.equals(endTown)) {
                return DTOPathResult.forBFS(path, totalCost,path.size() -1);
            }

            // Iterate through each neighbor town and its teleportation cost.
            for (Map.Entry<String, Integer> neighborEntry : graph.getNeighbors(currentTown).entrySet()) {
                String neighbor = neighborEntry.getKey();
                int cost = neighborEntry.getValue();

                // If the neighbor has not been visited yet, add it to visited Set.
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);

                    // Create a new path by adding the neighbor to the current path.
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.add(newPath);

                    //  Calculates the new teleportation cost and store it in pathCost Map.
                    int newCost = totalCost + cost;
                    pathCosts.put(newPath, newCost);
                }
            }
        }

        // Handles error when cannot find path from the start town to the destination town.
        return DTOPathResult.forBFS(Collections.emptyList(), -1, -1);
    }
}
