package Lineage2Calculator;

import Lineage2Calculator.Graph.Graph;
import Lineage2Calculator.InteractionManager.UserInput;
import Lineage2Calculator.InteractionManager.UserInteraction;
import Lineage2Calculator.Services.AlgorithmLoggerService;
import Lineage2Calculator.Services.AlgorithmService;
import Lineage2Calculator.Services.GraphBuilderService;
import Lineage2Calculator.Utils.DTOPathResult;
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
    private final AlgorithmService algorithmService;

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
    public ApplicationFacade(AlgorithmService algorithmService, GraphBuilderService graphBuilder, UserInteraction userInteraction, AlgorithmLoggerService loggerService) {
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

        UserInput userChoice = userInteraction.userChoice();

        DTOPathResult result = algorithmService.getAlgorithm(userChoice.getPathType()).algorithmPath(graph, userChoice.getStartTown(), userChoice.getEndTown());

        loggerService.log(userChoice.getPathType(), result);

        return result;
    }
}
