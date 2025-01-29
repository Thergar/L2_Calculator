package Lineage2Calculator.Graph;

import java.util.HashMap;
import java.util.Map;

public class Graph {

/**
 * A Static map that stores structure of the graph and represents relations between towns and their teleports costs.
 * Key: the name of town.
 * Value: a map containing destination towns and the teleportation cost to each one.
 */
    private static Map<String, Map<String,Integer>> adjacencyMap;

/**
 * Constructor that initialize "adjacencyMap" as empty HashMap, when Graph constructor is created.
 */
    public Graph() {
        adjacencyMap = new HashMap<>();
    }

/**
 * Adds new town to the graph if it doesn't already exist.
 * The "townName" is used as the key and its value is initialized as an empty map.
 * @param townName the name of the town to add.
 */
    public void addTown(String townName) {
        adjacencyMap.putIfAbsent(townName, new HashMap<>());
    }

/**
 * Adds edge (connection) between two towns with the specified teleport cost.
 * Gets map for "fromTown" and puts into "toTown" as neighbor with the given cost.
 * "fromTown" must exist in the graph before this method is called, otherwise a NullPointerException will be thrown.
 *
 * @param fromTown the starting town.
 * @param toTown the destination town.
 * @param cost the teleportation cost between the towns.
 */
    public void addEdge(String fromTown, String toTown, int cost) {
        adjacencyMap.get(fromTown).put(toTown, cost);
    }

/**
 * Retrieves the neighbors of specified town and their teleportation cost.
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
    public boolean containsTowns(String townName) {
        return adjacencyMap.containsKey(townName);
    }
}