package l2calculator.api;

import l2calculator.api.errors.ApiException;
import l2calculator.DTOPathResult;
import l2calculator.DTOUserInput;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;


/**
 * The {@code PathfindingApi} class sends a POST request to the backend
 * to calculate the teleport path using selected pathfinding algorithm.
 *
 * <p>
 * It takes the user's input (start town, destination town, and algorithm),
 * serializes it to JSON, and expects a {@link DTOPathResult} in response.
 * </p>
 */
public class PathfindingApi extends ApiConfiguration {

    /**
     * Sends a calculation request to the backend using the provided user input.
     *
     * @param userInput the data containing selected towns and algorithm.
     * @return a {@link DTOPathResult} containing the calculated path and cost.
     */
    public static DTOPathResult processCalculate(DTOUserInput userInput) {
        try {
            return client.post()
                    .uri("/pathfinding/calculate")
                    .body(userInput)
                    .retrieve()
                    .body(DTOPathResult.class);
        } catch (RestClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        } catch (ResourceAccessException e) {
            throw new ApiException("Cannot reach the server.", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}