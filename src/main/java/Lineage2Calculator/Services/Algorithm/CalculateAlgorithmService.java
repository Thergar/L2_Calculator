package Lineage2Calculator.Services.Algorithm;

import Lineage2Calculator.DTO.DTOPathResult;
import Lineage2Calculator.Graph.Graph;
import Lineage2Calculator.Services.GraphBuilderService;
import org.springframework.stereotype.Service;

@Service
public class CalculateAlgorithmService {

    private final Graph graph;
    private final AlgorithmService algorithmService;

    /**
     * Constructs an {@code CalculateAlgorithmService} instance with the provided components.
     *
     * @param algorithm the service responsible for executing pathfinding algorithms.
     * @param graphBuilder the service responsible for building the graph representation.
     */
    public CalculateAlgorithmService(GraphBuilderService graphBuilder, AlgorithmService algorithm) {
        this.graph = graphBuilder.buildGraph();
        this.algorithmService = algorithm;
    }

    /**
     * Finds a path based on user input and executes the selected pathfinding algorithm.
     *
     * @return {@link DTOPathResult} containing the pathfinding result.
     */
    public DTOPathResult calculatePath(String startTown, String endTown, String algorithmName) {
        return algorithmService.getAlgorithm(algorithmName).algorithmPath(graph, startTown, endTown);
    }
}