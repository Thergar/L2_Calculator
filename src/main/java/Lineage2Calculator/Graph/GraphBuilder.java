package Lineage2Calculator.Graph;

import Lineage2Calculator.DbServices.TownService;

import java.util.List;
import java.util.Map;

/**
 * A class responsible for building a graph representation of towns and teleport connections using data from {@link TownService}
 */
public class GraphBuilder {

/**
 * A service for retrieving data about towns and teleport connections from the database.
 */
    private final TownService townService;

/**
 * Constructs a {@code GraphBuilder} instance using the specified {@link TownService}.
 *
 * @param townService the service used to fetch town and teleport data.
 */
    public GraphBuilder(TownService townService) {
        this.townService = townService;
    }

/**
 * Builds and returns graph of all towns and teleport connections.
 * <p>
 *     This method retrieves the list of all towns and their corresponding teleport data
 *     (destination towns and teleportation costs) from the database using the {@link TownService}.
 *     Each town is added as node to the graph, and teleport connections are added as weighted edges.
 * </p>
 *
 * @return a {@link Graph} object containing all towns as nodes and teleport connections as weighted edges.
 */
    public Graph buildGraph() {
        Graph graph = new Graph();

        List<String> allTowns = townService.getAllTownNames();
        for (String town : allTowns) {
            graph.addTown(town);

            Map<String, Integer> teleportData = townService.getTeleportData(town);
            for (Map.Entry<String, Integer> entry : teleportData.entrySet()) {
                graph.addEdge(town, entry.getKey(), entry.getValue());
            }
        }

        return graph;
    }
}
