package l2calculator.Entities.TownRepository;

import java.util.List;


public interface TownRepositoryCustom {

    /**
     * Executes a dynamic query to retrieve town information (names and teleport prices)
     * from a specified table.
     *
     * @param tableName the name of the teleportation table to query.
     * @return a list of object arrays, where each array contains:
     *         [0] - the town name as a String,
     *         [1] - the teleportation price as an Integer.
     */
    List<Object[]> fetchTownDataWithDynamicTable(String tableName);
}
