package Lineage2Calculator.Services;

import Lineage2Calculator.Graph.Graph;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * A service class responsible for constructing a {@link Graph} representing towns and teleportation routes
 * using data retrieved from database.
 *
 *<p>
 *     Service uses the {@link TownService} to fetch town names and teleportation data,
 *     and then creates a {@link Graph} object where each town (node) is connected to others (edges)
 *     with associated teleportation costs.
 *</p>
 */
@Service
public class GraphBuilderService {

    /**
     * A service dependency providing methods for retrieving town and teleportation data from the database.
     */
    private final TownService townService;

    /**
     * Constructs a new {@code GraphBuilder} instance with the specified {@link TownService}.
     *
     * @param townService the service used to fetch town and teleport data.
     */
    public GraphBuilderService(TownService townService) {
        this.townService = townService;
    }

/**
 * Builds a {@link Graph} containing nodes and weighted edges.
 * <p>
 *     This method retrieves the list of all towns and their associated teleportation data
 *     from the database using the {@link TownService}.
 *     For each town, it adds the town as graph node and creates edges between nodes based
 *     on teleport connections.
 * </p>
 *
 * @return a fully constructed {@link Graph} object containing all towns and teleport routes.
 */
    public Graph buildGraph() {
        Graph graph = new Graph();

        // Retrieve all towns from database.
        List<String> allTowns = townService.getAllTownNames();

        // Add each town and its connections to the graph.
        for (String town : allTowns) {
            graph.addTown(town);

            // Retrieve and add teleport connections for each town.
            Map<String, Integer> teleportData = townService.getTeleportData(town);
            for (Map.Entry<String, Integer> entry : teleportData.entrySet()) {
                graph.addEdge(town, entry.getKey(), entry.getValue());
            }
        }

        return graph;
    }
}
