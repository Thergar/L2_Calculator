package Lineage2Calculator.DTO;

import java.util.List;

public class DTOPathResult {

    private final List<String> path;
    private final int totalCost;

    /**
     * A Class {@code DTOPathResult} is data transfer object that represents a result of a pathfinding algorithm.
     * <p>
     *     This class encapsulates the result data and ensure that after creation result cannot be modified.
     * </p>
     */
    public DTOPathResult(List<String> path, int totalCost) {
        this.path = path;
        this.totalCost = totalCost;
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
}
