package Lineage2Calculator;

import Lineage2Calculator.DTO.DTOPathResult;
import Lineage2Calculator.Graph.Graph;
import Lineage2Calculator.DTO.DTOUserInput;
import Lineage2Calculator.InteractionManager.UserInteraction;
import Lineage2Calculator.Services.AlgorithmLoggerService;
import Lineage2Calculator.Services.AlgorithmNameService;
import Lineage2Calculator.Services.GraphBuilderService;
import org.springframework.stereotype.Service;

/**
 * A {@code ApplicationFace} class provides facade design pattern for interacting with the teleportation system.
 * <p>
 *     This class hides the underlying subsystems, like database access, graph building,
 *     or path calculation of selected algorithm type, by sharing simplified methods.
 * </p>
 */
@Service
public class ApplicationFacade {

    /**
     * Executes the pathfinding algorithm specified by user.
     */
    private final AlgorithmNameService algorithmService;

    /**
     * Builds the graph representation of teleportation routes between towns.
     */
    private final Graph graph;

    /**
     * Manages the user interaction with application.
     */
    private final UserInteraction userInteraction;

    /**
     * Provides logging functionality for algorithm-related operations.
     **/
    private final AlgorithmLoggerService loggerService;


    /**
     * Constructs an {@code ApplicationFacade} instance with the provided components.
     *
     * @param algorithmService the service responsible for executing pathfinding algorithms.
     * @param graphBuilder the service responsible for building the graph representation.
     * @param userInteraction the service responsible for interaction with the user.
     * @param loggerService the service for logging algorithm execution results.
     */
    public ApplicationFacade(AlgorithmNameService algorithmService, GraphBuilderService graphBuilder, UserInteraction userInteraction, AlgorithmLoggerService loggerService) {
        this.algorithmService = algorithmService;
        this.graph = graphBuilder.buildGraph();
        this.userInteraction = userInteraction;
        this.loggerService = loggerService;
    }

    /**
     * Finds a path based on user input and executes the selected pathfinding algorithm.
     *
     * @return {@link DTOPathResult} containing the pathfinding result.
     */
    public DTOPathResult findPath() {

        DTOUserInput userChoice = userInteraction.setUserChoice("Heine", "Town of Oren", "BFSAlgorithm");

        DTOPathResult result = algorithmService.getAlgorithm(userChoice.getAlgorithmName()).algorithmPath(graph, userChoice.getStartTown(), userChoice.getEndTown());

        loggerService.log(userChoice.getAlgorithmName(), result);

        return result;
    }
}
