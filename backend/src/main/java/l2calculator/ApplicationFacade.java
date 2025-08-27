package l2calculator;

import l2calculator.errors.InputValidator;
import l2calculator.services.algorithm.CalculateAlgorithmService;
import org.springframework.stereotype.Service;

/**
 * A {@code ApplicationFace} class provides facade design pattern for interacting with the teleportation system.
 * <p>
 *     This class hides the complexity of subsystems such as graph validation,
 *     algorithm dispatching, and data verification. It serves as the main
 *     entry point for pathfinding operations exposed to the rest of the application.
 * </p>
 */
@Service
public class ApplicationFacade {

    private final CalculateAlgorithmService calculateAlgorithmService;
    private final InputValidator inputValidator;

    /**
     * Constructs an {@code backend.ApplicationFacade} instance with the provided components.
     *
     * @param calculateAlgorithmService the component responsible for executing pathfinding algorithms
     * @param inputValidator the component responsible for validating user input before execution
     */
    public ApplicationFacade(CalculateAlgorithmService calculateAlgorithmService, InputValidator inputValidator) {
        this.calculateAlgorithmService = calculateAlgorithmService;
        this.inputValidator = inputValidator;
    }

    /**
     * Executes the teleportation pathfinding based on user input.
     *
     * <p>
     * The method validates the provided start town, destination town, and algorithm name,
     * and then delegates the actual path calculation to the algorithm service.
     * </p>
     *
     * @param startTown the name of the town where the path starts
     * @param endTown the name of the destination town
     * @param algorithmName the name of the selected pathfinding algorithm
     * @return a {@link DTOPathResult} representing the computed teleportation path and cost
     * @throws IllegalArgumentException if any input is invalid (handled by {@link InputValidator})
     */
    public DTOPathResult findPath(String startTown, String endTown, String algorithmName) {

        // Validate the existence of algorithm type.
        inputValidator.validateAlgorithmName(algorithmName);
        // Validate the existence of startTown.
        inputValidator.validateTownName(startTown);
        // Validate the existence of endTown.
        inputValidator.validateTownName(endTown);
        // Validate the existence of startTown and endTown exist in the graph.
        inputValidator.validateDistinctTowns(startTown, endTown);

        return calculateAlgorithmService.calculatePath(startTown, endTown, algorithmName);
    }
}
