package Lineage2Calculator;

import Lineage2Calculator.Enum.AlgorithmType;
import Lineage2Calculator.Graph.Graph;
import Lineage2Calculator.Graph.GraphBuilder;
import Lineage2Calculator.InteractionManager.UserInput;
import Lineage2Calculator.InteractionManager.UserInterface;
import Lineage2Calculator.MainApplication.AlgorithmExecution;

/**
 * A {@code ApplicationFace} class provides facade design pattern for interacting with the teleportation system.
 * <p>
 *     This class hides the underlying subsystems, like database access, graph building,
 *     or path calculation of selected algorithm type, by sharing simplified methods.
 * </p>
 */
public class ApplicationFacade {

/**
 * Executes the pathfinding algorithm specified by user.
 */
    private final AlgorithmExecution algorithmExecution;

/**
 * Builds the graph representation of teleportation routes between towns.
 */
    private final GraphBuilder graphBuilder;

/**
 * Manages the user interaction with application.
 */
    private final UserInterface userInterface;

/**
 * Constructs an {@code ApplicationFacade} instance with the provided components.
 *
 * @param algorithmExecution the service responsible for pathfinding algorithm specified in {@link AlgorithmExecution}.
 * @param graphBuilder the service responsible for building teleportation graph based on {@link GraphBuilder}.
 * @param userInterface the service responsible for interacting with the user using {@link UserInterface}.
 */
    public ApplicationFacade(AlgorithmExecution algorithmExecution, GraphBuilder graphBuilder, UserInterface userInterface) {
        this.algorithmExecution = algorithmExecution;
        this.graphBuilder = graphBuilder;
        this.userInterface = userInterface;
    }

/**
 * Runs the application logic to calculate the teleportation route based on details provided by user.
 * <p>
 * A {@link UserInterface#townChoice()} method, display list of towns and ask user to choose start town,
 * destination town as well as path type. Builds a {@link GraphBuilder#buildGraph()} graph representing the teleportation
 * routes between towns. Executes the selected algorithm {@link AlgorithmExecution#executeAlgorithm(AlgorithmType, Graph, String, String)},
 * to calculate the path.
 * </p>
 *
 * @return a {@link DTOPathResult} containing the result of the pathfinding operations.
 */
    public DTOPathResult runApplication() {
        UserInput userInput = userInterface.townChoice();

        Graph graph = graphBuilder.buildGraph();

        return algorithmExecution.executeAlgorithm(
                userInput.getPathType(),
                graph,
                userInput.getStartTown(),
                userInput.getEndTown());
    }
}
