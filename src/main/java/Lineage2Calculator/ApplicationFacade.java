package Lineage2Calculator;

import Lineage2Calculator.DTO.DTOPathResult;
import Lineage2Calculator.Graph.Graph;
import Lineage2Calculator.DTO.DTOUserInput;
import Lineage2Calculator.InteractionManager.UserInteraction;
import Lineage2Calculator.Services.Algorithm.AlgorithmLoggerService;
import Lineage2Calculator.Services.Algorithm.AlgorithmService;
import Lineage2Calculator.Services.Algorithm.CalculateAlgorithmService;
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

    private final CalculateAlgorithmService calculateAlgorithmService;

    /**
     * Constructs an {@code ApplicationFacade} instance with the provided components.
     *
     * @param calculateAlgorithmService the service responsible for calculation.
     */
    public ApplicationFacade(CalculateAlgorithmService calculateAlgorithmService) {
        this.calculateAlgorithmService = calculateAlgorithmService;
    }

    /**
     * Finds a path based on user input and executes the selected pathfinding algorithm.
     *
     * @return {@link DTOPathResult} containing the pathfinding result.
     */
    public DTOPathResult findPath(String startTown, String endTown, String algorithmName) {
        return calculateAlgorithmService.calculatePath(startTown, endTown, algorithmName);
    }
}
