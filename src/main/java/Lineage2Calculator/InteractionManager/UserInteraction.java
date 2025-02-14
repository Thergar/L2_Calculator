package Lineage2Calculator.InteractionManager;

import Lineage2Calculator.Errors.ErrorHandling;
import Lineage2Calculator.Services.AlgorithmService;
import Lineage2Calculator.Services.TownService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * The {@code UserInput} class is responsible for managing user interactions.
 * <p>
 *     this class provides method to communicate with user.
 *     Then the input is packed into a {@link UserInput} object for further processing.
 * </p>
 */
@Component
public class UserInteraction {

    /** Service for retrieving town data from the database. */
    private final TownService townService;

    /** Scanner instance for reading user input. */
    private final Scanner scanner;

    /** Service for validating town names and handling errors in user interaction. */
    private final ErrorHandling errorHandling;

    private final AlgorithmService algorithmService;


    /**
     * Constructs a new {@code UserInteraction} instance with the required dependencies.
     *
     * @param townService the service for retrieving town data.
     * @param scanner the scanner for reading user input.
     * @param errorHandling the service for validating user input and throwing appropriate exceptions.
     */
    public UserInteraction(TownService townService, Scanner scanner, ErrorHandling errorHandling, AlgorithmService algorithmService) {
        this.townService = townService;
        this.scanner = scanner;
        this.errorHandling = errorHandling;
        this.algorithmService = algorithmService;
    }

    /**
     * Guides the user through the process of selecting a starting town, destination town, and algorithm type.
     *
     * <p>
     *     Displays available towns retrieved from database.
     * </p>
     * @return a {@link UserInput} object containing the user's validated selections.
     */
    public UserInput userChoice() {
        List<String> towns = townService.getAllTownNames();
        Set<String> algorithms = algorithmService.getAlgorithmNames();
        System.out.println("List of towns: " + String.join(", ", towns));

        String startTown = getUserTownSelection("Please select the town you are teleporting from:", towns);
        String endTown = getUserTownSelection("Please select your destination town:", towns);

        System.out.println("list of algorithms: " + String.join(", ", algorithms.stream().toList()));
        String algorithmName = getUserAlgorithmSelection("Now please select the path type: 'DijkstraAlgorithm' for shortest path or 'BFSAlgorithm' for fastest path.", algorithms);

        return new UserInput(startTown, endTown, algorithmName);
    }

    /**
     * Prompts the user to select a valid name from the provided list of towns.
     *
     * <p>
     *     Method display provided prompt message and validates the user's input.
     *     Method works in loop until a valid town is provided.
     * </p>
     * @param message the prompt message
     * @param validOptions the list of valid town names
     * @return a validate town name provided by the user
     */
    private String getUserTownSelection(String message, List<String> validOptions) {
        do {
            System.out.println(message);
            String userInput = scanner.nextLine().trim();

            if (isTownValid(userInput, validOptions)) {
                return userInput;
            } else {
                System.out.println("Invalid choice! Please select a valid town.");
            }
        } while (true);
    }

    /**
     * Validates town name.
     *
     * @param town town provided by user.
     * @param validOptions  list of available towns in graph.
     * @return True if town exists in graph otherwise return false.
     */
    private boolean isTownValid(String town, List<String> validOptions) {

        try {
            errorHandling.validateTownName(town, validOptions);
            return true;
        } catch (IllegalArgumentException e) {}
        return false;
    }

    /**
     * Prompts the user to select a valid algorithm from the provided set of algorithms.
     *
     * @param message the prompt message to display.
     * @param algorithms the set of available algorithms to choose from.
     * @return the name of selected algorithm.
     */
    private String getUserAlgorithmSelection(String message, Set<String> algorithms) {
         do {
             System.out.println(message);
             String userInput = scanner.nextLine().trim();

             if (isAlgorithmValid(userInput, algorithms)) {
                 return userInput;
             } else {
                 System.out.println("Invalid choice! Please select a valid algorithm.");
             }
         } while (true);
    }

    /**
     * Checks if the provided algorithm type is valid.
     *
     * @param algorithmType the type of algorithm provided by user.
     * @param algorithms the set of valid algorithm names.
     * @return true if the algorithm type is valid, false otherwise.
     */
    private boolean isAlgorithmValid(String algorithmType, Set<String> algorithms) {

        try {
            errorHandling.validateAlgorithmType(algorithmType, algorithms);
            return true;
        } catch (IllegalArgumentException e) {}
        return false;
    }
}
