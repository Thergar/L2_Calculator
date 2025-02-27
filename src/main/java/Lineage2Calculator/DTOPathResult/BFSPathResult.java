package Lineage2Calculator.DTOPathResult;

import java.util.List;

public class BFSPathResult extends DTOPathResult {

    /**
     * The number of steps (teleportation transitions) for BFS algorithm.
     */
    private final int steps;

    /**
     * Creates a DTOPathResult for BFS, including the path, total cost and the number of steps.
     *
     * @param path The list of towns on the route.
     * @param totalCost The total cost for the teleportation path.
     * @param steps The number of teleportation steps taken to reach destination town
     * @return A new DTOPathResult instance containing result for BFS algorithm.
     */
    protected BFSPathResult(List<String> path, int totalCost, int steps) {
        super(path, totalCost);
        this.steps = steps;
    }

    /**
     * Retrieves the number of steps taken to reach destination town.
     */
    @Override
    public int getSteps() {
        return steps;
    }
}
