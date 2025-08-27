package l2calculator.api;

import l2calculator.api.errors.ApiException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;

import java.util.List;

/**
 * The {@code TownApi} class provides a method to fetch a list of town names
 * from the backend.
 *
 * <p>
 * It is used to fill UI dropdowns such as start and destination selectors.
 * </p>
 */
public class TownApi extends ApiConfiguration {

    public static List<String> fetchTowns() {
        try {
            return client.get()
                    .uri("/towns/all")
                    .retrieve()
                    .body(new ParameterizedTypeReference<List<String>>() {});
        } catch (RestClientResponseException e) {
            throw new ApiException(e.getResponseBodyAsString(), e.getStatusCode());
        } catch (ResourceAccessException e) {
            throw new ApiException("Cannot connect to the backend.", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
