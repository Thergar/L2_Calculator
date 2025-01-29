package Lineage2Calculator.DbServices;

import Lineage2Calculator.Utils.JpaConfig;
import jakarta.persistence.EntityManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service class responsible for interacting with the database to retrieve town and teleportation data.
 * Uses the {@link EntityManager} class for database queries and operations.
 */
public class TownService {

    private final EntityManager entityManager;

/**
 * Constructs the {@link TownService} object by initializing the {@link EntityManager}.
 * The {@link EntityManager} is generated using configuration from the {@link JpaConfig} class.
 */
    public TownService() {
        this.entityManager = JpaConfig.createEntityManager();
    }

/**
 * Method that converts town name to a valid database table name, by replacing spaces underscore and appending a suffix.
 *
 * @param townName the name of the town to be matched with corresponding table name in database.
 * @return the modified town name that matches the database naming rule.
 */
    private String matchTownNameWithTableName(String townName) {
        return townName.replace(" ", "_") + "_teleports";
    }

/**
 * Helper method that creates an SQL query string to retrieve destination town names and prices.
 * <p>
 *     The query joins the town table ("town_name" alias "t") with the corresponding teleport table ("tableName" alias "tp"),
 *     based on the foreign key "tp.destination_id" and the primary key "t.town_id".
 * </p>
 *
 * @param tableName the name of the teleportation table, derived from the entered town name.
 * @return the constructed SQL query as a string.
 */
    private String createTeleportQuery(String tableName) {
        return "SELECT t.town_name, tp.price FROM " + tableName + " tp JOIN Town t ON tp.destination_id = t.town_id";
    }

/**
 * Retrieves list of all towns from database using.
 * <p>
 *     Method that uses SQL query to fetch all towns name from the "Town" table.
 * </p>
 *
 * @return a list containing every town name from database.
 */
    public List<String> getAllTownNames() {
        String query = "SELECT t.townName FROM Town t";
        return entityManager.createQuery(query, String.class).getResultList();
    }

/**
 * Method to retrieve town from the database based on its ID.
 *
 * @param townId the ID of the town to retrieve.
 * @return an {@link Optional} containing the {@link Town} entity if found or empty {@link Optional}.
 */
    public Optional<Town> getTownById(Long townId) {
        return Optional.ofNullable(entityManager.find(Town.class, townId));
    }

/**
 * Retrieves teleport destinations data and their costs from the teleport table for a given town name.
 * <p>
 *     The results are stored in a {@link Map} where the key is the destination town,
 *     and the value is the cost of the teleportation.
 * </p>
 *
 * @param townName the name of the town for which teleportation data is being retrieved.
 * @return a {@link Map} with the destination town names as keys and teleportation costs as values.
 */
    public Map<String, Integer> getTeleportData(String townName) {

        Map<String,Integer> result = new HashMap<>();

// Convert the town name into the corresponding teleportation table.
        String tableName = matchTownNameWithTableName(townName);

// Creates the SQL query to retrieve teleportation data.
        String query = createTeleportQuery(tableName);

// Executes the query and map the results to the list of objects.
        //JPa doesn't guarantee that retrieved result will be matched with Object[].class.
        List<Object[]> teleportData = entityManager.createNativeQuery(query, Object[].class).getResultList();

//Iterates through each row of the teleport data list, extracting destination town and cost, and puts them into result map.
        for (Object[] row : teleportData) {
            String destinationTown = (String) row[0];
            Integer cost = ((Number) row[1]).intValue();
            result.put(destinationTown, cost);
        }

        return result;
    }
}
