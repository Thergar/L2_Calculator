package Lineage2Calculator.Algorithms;

import Lineage2Calculator.DTO.DTOPathResult;
import Lineage2Calculator.DTO.DTOPathResultFactory;
import Lineage2Calculator.Errors.ErrorHandling;
import Lineage2Calculator.Graph.Graph;
import org.springframework.stereotype.Component;

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
@Component
public class DijkstraAlgorithm implements PathfindingAlgorithm {

    private final PathReconstruct pathReconstruct;
    private final ErrorHandling errorHandling;

    public DijkstraAlgorithm(PathReconstruct pathReconstruct, ErrorHandling errorHandling) {
        this.pathReconstruct = pathReconstruct;
        this.errorHandling = errorHandling;
    }

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
    public DTOPathResult findCheapestPath(Graph graph, String startTown, String endTown) {

        // Validate existence of startTown and endTown exist in the graph.
        errorHandling.validateDistinctTowns(startTown, endTown);

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

    @Override
    public DTOPathResult algorithmPath(Graph graph, String startTown, String endTown){
        return findCheapestPath(graph, startTown, endTown);
    }
}
