package Lineage2Calculator.Graph;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a graph structure where each node (town) neighbors (edges) represented by
 * a map of destination towns and teleportation costs.
 * */
@Component
public class Graph {

    /**
     * A data structure that stores the graph and representation.
     * <p>
     *     Key: the name of town (node).
     *     Value: a map containing neighbors as keys and the teleportation cost to each one as value.
     * </p>
     */
    private final Map<String, Map<String,Integer>> adjacencyMap;

    /**
     * Constructor that initializes the "adjacencyMap" as empty HashMap.
     */
    public Graph() {
        adjacencyMap = new HashMap<>();
    }

    /**
     * Adds a town (node) to the graph if it doesn't already exist.
     * <p>
     *     if the town already exists, no changes are made to the graph.
     *     The "townName" is used as the key and its value is initialized as an empty map.
     * </p>
     *
     * @param townName the name of the town to add.
     */
    public void addTown(String townName) {
        adjacencyMap.putIfAbsent(townName, new HashMap<>());
    }

    /**
     * Adds connection (edge) between two towns with the specified teleportation cost.
     *
     * <p>
     *     The starting town must already exist in the graph before calling this method.
     * </p>
     *
     * @param fromTown the starting town.
     * @param toTown the destination town.
     * @param cost the teleportation cost between the towns.
     */
    public void addEdge(String fromTown, String toTown, int cost) {
        adjacencyMap.get(fromTown).put(toTown, cost);
    }

/**
 * Retrieves the neighbors (connected nodes) of specified town and their associated teleportation cost.
 * If the town doesn't exist in the graph, an empty map is returned.
 *
 * @param townName the name of the town whose neighbors are to be retrieved.
 * @return a map of neighbors and their associated teleport costs.
 */
    public Map<String, Integer> getNeighbors(String townName) {
        return adjacencyMap.getOrDefault(townName, new HashMap<>());
    }

/**
 * Returns entire structure of the graph.
 *
 * @return the adjacency map representing graph.
 */
    public Map<String, Map<String, Integer>> getAdjacencyMap() {
        return adjacencyMap;
    }

/**
 * Checks if a given town exists in the graph.
 *
 * @param townName the town to check.
 * @return true if the town exists in the graph.
 */
    public boolean containsTown(String townName) {
        return adjacencyMap.containsKey(townName);
    }
}