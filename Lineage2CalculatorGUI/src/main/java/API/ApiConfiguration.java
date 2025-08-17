package Lineage2CalculatorGUI.API;


import Lineage2CalculatorGUI.API.Errors.TextErrorHandler;
import org.springframework.web.client.RestTemplate;

/**
 * Provides centralized configuration for accessing the backend REST API.
 *
 * <p>
 * This class defines the base endpoint and initializes a shared {@link RestTemplate}
 * instance used by API-related classes to perform HTTP operations.
 * </p>
 */
public class ApiConfiguration {

    /**
     * Base URL of the backend API.
     */
    protected static final String BASE_URL = "http://localhost:8080";

    /**
     * Reusable HTTP client configured with a custom error handler.
     *
     * <p>
     * This {@code RestTemplate} handles API communication and applies a plain-text
     * error parser via {@link TextErrorHandler} for consistent error reporting.
     * </p>
     */
    protected static final RestTemplate restTemplate;

    // Static initializer block that configures the shared RestTemplate instance.
    static {
        restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new TextErrorHandler());
    }
}
