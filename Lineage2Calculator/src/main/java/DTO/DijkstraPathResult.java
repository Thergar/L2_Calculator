package Lineage2Calculator.DTO;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("dijkstra")
public class DijkstraPathResult extends DTOPathResult {

    /**
     * Constructs a DTOPathResult with the entire path and total cost of dijkstra algorithm.
     *
     * @param path The path represented as a list of town names.
     * @param totalCost The total cost of the teleportation path.
     */
    protected DijkstraPathResult(List<String> path, int totalCost) {
        super(path, totalCost);
    }
}
