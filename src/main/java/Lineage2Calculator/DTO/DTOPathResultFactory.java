package Lineage2Calculator.DTO;

import java.util.List;

public class DTOPathResultFactory  {

    public static DTOPathResult forDijkstra(List<String> path, int totalCOst) {
        return new DijkstraPathResult(path, totalCOst);
    }

    public static DTOPathResult forBFS(List<String> path, int totalCost, int steps) {
        return new BFSPathResult(path, totalCost, steps);
    }
}
