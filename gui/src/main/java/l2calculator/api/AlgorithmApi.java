package l2calculator.api;

import l2calculator.api.errors.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;

/**
 * The {@code AlgorithmApi} class provides methods for fetching
 * pathfinding algorithm information from the backend.
 *
 * <p>
 * It includes endpoints for retrieving available algorithms such as Dijkstra and BFS.
 * </p>
 */
public class AlgorithmApi extends ApiConfiguration {

    public static String fetchDijkstraAlgorithm() {
        try {
            return client.get()
                    .uri("/algorithm/dijkstra")
                    .retrieve()
                    .body(String.class);
        } catch (RestClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        } catch (ResourceAccessException e) {
            throw new ApiException("Cannot reach the server.", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    public static String fetchBFSAlgorithm() {
        try {
            return client.get()
                    .uri("/algorithm/bfs")
                    .retrieve()
                    .body(String.class);
        } catch (RestClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        } catch (ResourceAccessException e) {
            throw new ApiException("Cannot reach the server.", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
