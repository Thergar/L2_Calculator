package Lineage2CalculatorGUI.API;

/**
 * The {@code AlgorithmApi} class provides methods for fetching
 * pathfinding algorithm information from the backend REST API.
 *
 * <p>
 * It includes endpoints for retrieving available algorithms such as Dijkstra and BFS.
 * </p>
 */
public class AlgorithmApi extends ApiConfiguration {

    public static String fetchDijkstraAlgorithm() {
        return restTemplate.getForObject(BASE_URL + "/algorithm/dijkstra", String.class);
    }

    public static String fetchBFSAlgorithm() {
        return restTemplate.getForObject(BASE_URL + "/algorithm/bfs", String.class);
    }
}
