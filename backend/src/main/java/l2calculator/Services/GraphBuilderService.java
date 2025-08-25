package l2calculator.Services;

import l2calculator.Graph.Graph;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
     *  <p>
     *     This method retrieves the list of all towns and their associated teleportation data
     *     from the database using the {@link TownService}.
     *     For each town, it adds the town as graph node and creates edges between nodes based
     *     on teleport connections.
     * </p>
     *
     * @return a fully constructed {@link Graph} object containing all towns and teleport routes.
     */
    @Deprecated
    public Graph buildGraph() {
        Graph graph = new Graph();

        // Retrieve all towns from database.
        Set<String> allTowns = townService.getAllTownNames();

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

    /**
     * Builds a {@link Graph} starting from a specific town and including only towns
     * that are directly or indirectly reachable via teleport connections.
     * <p>
     *     This method initiates recursive graph construction, avoiding the need to load
     *     the entire teleportation network. It is particularly useful for calculating paths
     *     between specific locations without incurring overhead from unused data.
     * </p>
     *
     * @param town the starting town for building the partial graph.
     * @return a {@link Graph} containing only the subset of towns reachable from the given starting town.
     */
    public Graph buildGraphFrom(String town) {
        Graph graph = new Graph();

        Set<String> visited = new HashSet<>();

        buildGraphRecursive(graph, town, visited);

        return graph;
    }

    /**
     * Recursively traverses teleport connections starting from the given town and
     * adds nodes and edges to the provided {@link Graph} instance.
     * <p>
     *     This method ensures that each town is only visited once by maintaining
     *     a set of visited towns. It builds a connected component of the teleportation
     *     graph rooted at the specified starting point.
     * </p>
     *
     * @param graph   the {@link Graph} object being constructed.
     * @param town    the current town to process and expand.
     * @param visited a set of already visited town names to prevent cycles and redundant work.
     */
    private void buildGraphRecursive(Graph graph, String town, Set<String> visited) {
        if (visited.contains(town)) {
            return;
        }

        visited.add(town);
        graph.addTown(town);

        Map<String, Integer> teleportData = townService.getTeleportData(town);
        for (Map.Entry<String, Integer> entry : teleportData.entrySet()) {

            String connectedTown = entry.getKey();
            int cost = entry.getValue();

            graph.addEdge(town, connectedTown, cost);
            buildGraphRecursive(graph, connectedTown, visited);
        }
    }
}
