package Lineage2Calculator.DTOPathResult;

import java.util.List;

public class DTOPathResultFactory {

    public static DTOPathResult forDijkstra(List<String> path, int totalCost) {
        return new DijkstraPathResult(path,totalCost);
    }

    public static DTOPathResult forBFS(List<String> path, int totalCst, int steps) {
        return new BFSPathResult(path, totalCst, steps);
    }
}
