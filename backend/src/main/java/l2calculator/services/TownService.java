package l2calculator.services;

import l2calculator.entities.Town;
import l2calculator.entities.townrepository.TownRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class responsible for interacting with the database to retrieve town and teleportation data.
 */
@Service
public class TownService {

    private final TownRepository townRepository;


    public TownService(TownRepository townRepository) {
        this.townRepository = townRepository;
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
     *
     * Retrieves a set of all towns from database.
     *
     * @return a set containing every town name from database.
     */
    public Set<String> getAllTownNames() {
        return townRepository.findAll().stream()
                .map(Town::getTownName)
                .collect(Collectors.toSet());
    }

    /**
     * Method to retrieve town from the database based on its ID.
     *
     * @param townId the ID of the town to retrieve.
     * @return an {@link Optional} containing the {@link Town} entity if found or empty {@link Optional}.
     */
    public Optional<Town> getTownById(Long townId) {
        return townRepository.findById(townId);
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
    @Transactional
    public Map<String, Integer> getTeleportData(String townName) {

        Map<String,Integer> result = new HashMap<>();

        // Convert the town name into the corresponding teleportation table.
        String tableName = matchTownNameWithTableName(townName);

        // Executes the query and map the results to the list of objects.
        //JPA doesn't guarantee that retrieved result will be matched with Object[].class.
        List<Object[]> teleportData = townRepository.fetchTownDataWithDynamicTable(tableName);

        //Iterates through each row of the teleport data list, extracting destination town and cost, and puts them into result map.
        for (Object[] row : teleportData) {
            String destinationTown = (String) row[0];
            Integer cost = ((Number) row[1]).intValue();
            result.put(destinationTown, cost);
        }

        return result;
    }
}
