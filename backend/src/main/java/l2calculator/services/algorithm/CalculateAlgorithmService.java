package l2calculator.services.algorithm;

import l2calculator.graph.Graph;
import l2calculator.services.GraphBuilderService;
import l2calculator.DTOPathResult;
import org.springframework.stereotype.Service;

@Service
public class CalculateAlgorithmService {

    private final GraphBuilderService graphBuilder;
    private final AlgorithmNameService algorithmNameService;

    /**
     * Constructs an {@code CalculateAlgorithmService} instance with the provided components.
     *
     * @param algorithmNameService the service responsible for executing pathfinding algorithms.
     * @param graphBuilder the service responsible for building the graph representation.
     */
    public CalculateAlgorithmService(GraphBuilderService graphBuilder, AlgorithmNameService algorithmNameService) {
        this.graphBuilder = graphBuilder;
        this.algorithmNameService = algorithmNameService;
    }

    /**
     * Finds a path based on user input and executes the selected pathfinding algorithm.
     *
     * @return {@link DTOPathResult} containing the pathfinding result.
     */
    public DTOPathResult calculatePath(String startTown, String endTown, String algorithmName) {
        Graph graph = graphBuilder.buildGraphFrom(startTown);
        return algorithmNameService.getAlgorithm(algorithmName).algorithmPath(graph, startTown, endTown);
    }
}