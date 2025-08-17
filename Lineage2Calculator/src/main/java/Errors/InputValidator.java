package Lineage2Calculator.Errors;

import Lineage2Calculator.Services.Algorithm.AlgorithmNameService;
import Lineage2Calculator.Services.TownService;
import org.springframework.stereotype.Component;

/**
 * Performs validation of user input before executing pathfinding logic.
 *
 * <p>
 *     This component ensures that selected towns and algorithms are valid.
 *     It checks for non-existent towns, unknown algorithm types, and disallows identical start and end towns.
 *     Upon validation failure, exceptions are delegated to the {@link ErrorHandling} component.
 * </p>
 *
 */
@Component
public class InputValidator {

    private final TownService townService;
    private final AlgorithmNameService algorithmNameService;
    private final ErrorHandling errorHandling;

    /**
     * Constructs an input validator with access to town and algorithm repositories.
     *
     * @param townService service for accessing known towns
     * @param algorithmNameService service for accessing supported algorithm names
     * @param errorHandling centralized exception handler for validation failures
     */
    public InputValidator(TownService townService, AlgorithmNameService algorithmNameService, ErrorHandling errorHandling) {
        this.townService = townService;
        this.algorithmNameService = algorithmNameService;
        this.errorHandling = errorHandling;
    }

    /**
     * Validates whether the given town exists in the system.
     *
     * @param town the name of the town to validate
     * @throws IllegalArgumentException if the town is not found
     */
    public void validateTownName(String town) {
        if (!townService.getAllTownNames().contains(town)) {
            errorHandling.invalidTownNamesError(town);
        }
    }

    /**
     * Validates whether the specified algorithm name is supported.
     *
     * @param algorithmName the name of the algorithm to validate
     * @throws IllegalArgumentException if the algorithm is unknown
     */
    public void validateAlgorithmName(String algorithmName) {
        if (!algorithmNameService.getAlgorithmNames().contains(algorithmName)) {
            errorHandling.invalidAlgorithmTypeError(algorithmName);
        }
    }

    /**
     * Validates that the starting and destination towns are not the same.
     *
     * @param startTown the starting town
     * @param endTown the destination town
     * @throws IllegalArgumentException if both towns are equal
     */
    public void validateDistinctTowns(String startTown, String endTown) {
        if (startTown.equals(endTown)) {
            errorHandling.sameTownsError();
        }
    }
}
