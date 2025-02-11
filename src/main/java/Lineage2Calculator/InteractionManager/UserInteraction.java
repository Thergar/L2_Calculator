package Lineage2Calculator.InteractionManager;

import Lineage2Calculator.Errors.ErrorHandling;
import Lineage2Calculator.Services.TownService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

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


    /**
     * Constructs a new {@code UserInteraction} instance with the required dependencies.
     *
     * @param townService the service for retrieving town data.
     * @param scanner the scanner for reading user input.
     * @param errorHandling the service for validating user input and throwing appropriate exceptions.
     */
    public UserInteraction(TownService townService, Scanner scanner, ErrorHandling errorHandling) {
        this.townService = townService;
        this.scanner = scanner;
        this.errorHandling = errorHandling;
    }

    /**
     * Guides the user through the process of selecting a starting town, destination town, and algorithm type.
     *
     * <p>
     *     Displays available towns retrieved from database.
     * </p>
     * @return a {@link UserInput} object containing the user's validated selections.
     */
    public UserInput townChoice() {
        List<String> towns = townService.getAllTownNames();
        System.out.println("List of towns: " + String.join(", ", towns));

        String startTown = getUserSelection("Please select the town you are teleporting from:", towns);
        String endTown = getUserSelection("Please select your destination town:", towns);
        String algorithmName = getAlgorithmSelection();

        return new UserInput(startTown, endTown, algorithmName);
    }

    /**
     * Prompts the user to select a valid town from the provided list.
     *
     * <p>
     *     Method display provided prompt message and validates the user's input.
     *     Method works in loop until a valid town is provided.
     * </p>
     * @param message the prompt message
     * @param validOptions the list of valid town names
     * @return a validate town name provided by the user
     */
    private String getUserSelection(String message, List<String> validOptions) {
        do {
            System.out.println(message);
            String userInput = scanner.nextLine().trim();

            if (isValidTown(userInput, validOptions)) {
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
    private boolean isValidTown(String town, List<String> validOptions) {

        try {
            errorHandling.validateTownName(town, validOptions);
            return true;
        } catch (IllegalArgumentException e) {}
        return false;
    }

    /**
     * Prompts the user to select a valid algorithm type.
     *
     * @return the chosen algorithm name
     */
     private String getAlgorithmSelection() {
        String algorithm;
        do {
            System.out.println("Now please select the path type: 'Dijkstra' for shortest path or 'BFS' for fastest path.");
            algorithm = scanner.nextLine().trim();
            if (!algorithm.equals("DijkstraAlgorithm") && !algorithm.equals("BFSAlgorithm")) {
                System.out.println("Invalid choice! Type 'DijkstraAlgorithm' or 'BFSAlgorithm'.");
            }
        } while (!algorithm.equals("DijkstraAlgorithm") && !algorithm.equals("BFSAlgorithm"));
        return algorithm;
    }
}
