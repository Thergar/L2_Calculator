package Lineage2CalculatorGUI.API;

import Lineage2Calculator.DTO.DTOPathResult;
import Lineage2Calculator.DTO.DTOUserInput;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.awt.*;

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

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<DTOUserInput> request = new HttpEntity<>(userInput, headers);

        return restTemplate.postForObject(BASE_URL + "/pathfinding/calculate", userInput, DTOPathResult.class);
    }
}