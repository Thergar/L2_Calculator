package Lineage2Calculator.DTO;

import java.util.List;

/**
 * Factory class for creating {@link DTOPathResult} instances.
 * <p>
 *     Provides static factory methods for creating algorithm-specific result DTOs,
 *     such as Dijkstra and BFS implementations.
 * </p>
 */
public class DTOPathResultFactory  {

    /**
     * Creates a {@link DijkstraPathResult} DTO instance.
     */
    public static DTOPathResult forDijkstra(List<String> path, int totalCOst) {
        return new DijkstraPathResult(path, totalCOst);
    }

    /**
     * Creates a {@link BFSPathResult} DTO instance.
     */
    public static DTOPathResult forBFS(List<String> path, int totalCost, int steps) {
        return new BFSPathResult(path, totalCost, steps);
    }
}
