package Lineage2CalculatorGUI.API;

import java.util.List;

/**
 * The {@code TownApi} class provides a method to fetch a list of town names
 * from the backend REST API.
 *
 * <p>
 * It is used to fill UI dropdowns such as start and destination selectors.
 * </p>
 */
public class TownApi extends ApiConfiguration {

    public static List<String> fetchTowns() {
        return restTemplate.getForObject(BASE_URL + "/towns/all", List.class);
    }
}
