package Lineage2CalculatorGUI.API;

/**
 * The {@code ApiConfiguration} class holds shared configuration
 * for connecting to the backend REST API.
 *
 * <p>
 * It defines the base URL for API requests and initializes the {@link RestTemplate} instance.
 * </p>
 */
import org.springframework.web.client.RestTemplate;

public class ApiConfiguration {

    /**
     * Base URL of the backend API.
     */
    protected static final String BASE_URL = "http://localhost:8080/api";

    /**
     * Shared {@code RestTemplate} instance used by all API classes to communicate with the backend REST API.
     *
     * <p>
     * The {@code RestTemplate} is a synchronous HTTP client provided by the Spring Framework.
     * It supports standard HTTP methods such as GET, POST, PUT, and DELETE,
     * and simplifies the process of sending requests and processing responses.
     * </p>
     */
    protected static final RestTemplate restTemplate = new RestTemplate();
}
