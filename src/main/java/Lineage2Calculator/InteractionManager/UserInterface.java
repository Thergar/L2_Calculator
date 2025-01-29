package Lineage2Calculator.InteractionManager;

import Lineage2Calculator.DbServices.TownService;
import Lineage2Calculator.Enum.AlgorithmType;

import java.util.Scanner;

/**
 * The {@code UserInput} class is responsible for managing user interactions.
 * <p>
 *     It provides method to display a list of towns from database, collect user input regarding the start town, destination town and the algorithm type.
 *     Then the input is packed into a {@link UserInput} object for further processing.
 * </p>
 */
public class UserInterface {

/** An instance of {@link TownService} for interacting with database to retrieve town list. */
    TownService townService = new TownService();

/** An instance of {@link Scanner} for reading user input from the console. */
    Scanner scanner = new Scanner(System.in);

/** The name of the starting town. */
    String startTown;

/** The name of the destination town. */
    String endTown;

/** The algorithm type to be used for route calculation. */
    AlgorithmType pathType;

/**
 * Displays a list of towns, collects user input for the starting town, destination town and the selected algorithm type,
 * and packages this data into a {@link UserInput} object.
 *
 * <p>
 *     Displays list of towns retrieved from the database using {@link TownService#getAllTownNames()},
 *     and asks user to input data.
 * </p>
 *
 * @return a {@link UserInput} object containing the user's starting town, destination town,
 * and algorithm type as defined in {@link AlgorithmType}.
 */
    public UserInput townChoice() {
        System.out.println("List of towns: " + townService.getAllTownNames());
        System.out.println("Please select from the list, town You are teleporting from: ");
        startTown = scanner.nextLine();
        System.out.println("Please select your destination town: ");
        endTown = scanner.nextLine();
        System.out.println("Now please select which path are you looking for: \"for shortest path type - DIJKSTRA\" or \"for fastest path type - BFS\"?");
        pathType = AlgorithmType.valueOf(scanner.nextLine());
        return new UserInput(startTown, endTown, pathType);
    }
}
