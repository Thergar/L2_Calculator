package Lineage2Calculator.Utils;

import java.util.List;

/**
 * A Class {@code DTOPathResult} is data transfer object that represents a result of a pathfinding algorithm.
 * <p>
 *     This class encapsulates the result data and ensure that after creation result cannot be modified.
 * </p>
 */
public class DTOPathResult {

/**
 * The list of towns in the path.
 */
    private final List<String> path;

 /**
  * The total cost of the path.
  */
    private final int totalCost;

/**
 * The number of steps (teleportation transitions) for BFS algorithm.
 */
    private  int steps;

 /**
  * Constructs a DTOPathResult with the entire path and total cost of dijkstra algorithm.
  *
  * @param path The path represented as a list of town names.
  * @param totalCost The total cost of the teleportation path.
  */
    private DTOPathResult(List<String> path, int totalCost) {
        this.path = path;
        this.totalCost = totalCost;
    }

/**
 * Constructs a DTOPathResult with the entire path, total cost and number of steps for BFS algorithm.
 *
 * @param path The path represented as a list of town names.
 * @param totalCost The total cost of the teleportation path.
 * @param steps The number of teleportation steps taken to reach destination town
 */
    private DTOPathResult(List<String> path, int totalCost, int steps) {
        this.path = path;
        this.totalCost = totalCost;
        this.steps = steps;
    }

 /**
  * Creates a DTOPathResult for Dijkstra, including the path and total cost.
  *
  * @param path The list of towns on the route.
  * @param totalCost The total cost for the teleportation path.
  * @return A new DTOPathResult instance containing result for dijkstra algorithm
  */
    public static DTOPathResult forDijkstra(List<String> path, int totalCost) {
        return new DTOPathResult(path, totalCost);
    }

/**
 * Creates a DTOPathResult for BFS, including the path, total cost and the number of steps.
 *
 * @param path The list of towns on the route.
 * @param totalCost The total cost for the teleportation path.
 * @param steps The number of teleportation steps taken to reach destination town
 * @return A new DTOPathResult instance containing result for BFS algorithm.
 */
    public static DTOPathResult forBFS(List<String> path, int totalCost, int steps) {
        return new DTOPathResult(path, totalCost, steps);
    }

/**
 * Retrieves the route represented as list of towns.
 */
    public List<String> getPath() {
        return path;
    }

/**
 * Retrieves the total cost for the teleportation path.
 */
    public int getTotalCost() {
        return totalCost;
    }

/**
 * Retrieves the number of steps taken to reach destination town.
 */
    public int getSteps() {
        return steps;
    }
}
