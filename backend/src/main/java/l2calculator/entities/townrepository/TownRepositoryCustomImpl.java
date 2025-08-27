package l2calculator.entities.townrepository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import l2calculator.entities.Town;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of custom repository functionality for the {@link Town}
 */
@Repository
public class TownRepositoryCustomImpl implements TownRepositoryCustom {

    /**
     * Injected entity manager for executing custom queries and managing persistence context.
     *
     * <p>
     *     This field is annotated with {@code @PersistenceContext}, which indicates that it will
     *     be automatically injected by the container with an instance of {@link EntityManager}.
     *     It allows direct execution of JPQL, native SQL queries, and transaction operations within
     *     the custom repository implementation.
     * </p>
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Executes a dynamic SQL query to retrieve town names and teleportation prices from the specified table.
     * The query joins the given table with the "town" table using the destination ID.
     *
     * @param tableName the name of the table to query, which must contain a "destination_id" column
     *                  to join with the "town" table.
     * @return a list of Object arrays, where each array contains the town name and price as the result
     *         of the query.
     */
    @Override
    public List<Object[]> fetchTownDataWithDynamicTable(String tableName) {

        String sqlQuery = "SELECT t.town_name, tp.price FROM " + tableName + " tp " + "JOIN town t ON tp.destination_id = t.town_id";

        return entityManager.createNativeQuery(sqlQuery).getResultList();
    }
}
