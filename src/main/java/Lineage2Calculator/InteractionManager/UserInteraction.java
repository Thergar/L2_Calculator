package Lineage2Calculator.InteractionManager;

import Lineage2Calculator.DTO.DTOUserInput;
import Lineage2Calculator.Errors.ErrorHandling;
import Lineage2Calculator.Services.Algorithm.AlgorithmService;
import Lineage2Calculator.Services.TownService;
import org.springframework.stereotype.Component;


import java.util.Set;

/**
 * The {@code UserInput} class is responsible for managing user interactions.
 * <p>
 *     this class provides method to communicate with user.
 *     Then the input is packed into a {@link DTOUserInput} object for further processing.
 * </p>
 */
@Component
public class UserInteraction {

    /** Service for retrieving town data from the database. */
    private final TownService townService;

    /** Service for validating town names and handling errors in user interaction. */
    private final ErrorHandling errorHandling;

    /** Service for retrieving algorithm names. */
    private final AlgorithmService algorithmService;


    /**
     * Constructs a new {@code UserInteraction} instance with the required dependencies.
     *
     * @param townService the service for retrieving town data.
     * @param errorHandling the service for validating user input and throwing appropriate exceptions.
     */
    public UserInteraction(TownService townService, ErrorHandling errorHandling, AlgorithmService algorithmService) {
        this.townService = townService;
        this.errorHandling = errorHandling;
        this.algorithmService = algorithmService;
    }

    public DTOUserInput setUserChoice(String startTown, String endTown, String algorithmType) {
        Set<String> towns = townService.getAllTownNames();
        Set<String> algorithms = algorithmService.getAlgorithmNames();

        errorHandling.validateTownName(startTown, towns);
        errorHandling.validateTownName(endTown, towns);
        errorHandling.validateAlgorithmType(algorithmType, algorithms);

        return new DTOUserInput(startTown, endTown, algorithmType);
    }
}
