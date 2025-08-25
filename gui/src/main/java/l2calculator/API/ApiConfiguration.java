package API;

import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.time.Duration;

/**
 * Provides centralized configuration for accessing the backend backend.REST API.
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

    protected static final RestClient client;

    static {
        var jdk = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();

        var rf = new JdkClientHttpRequestFactory(jdk);
        rf.setReadTimeout(Duration.ofSeconds(15));

        client = RestClient.builder()
                .baseUrl(BASE_URL)
                .requestFactory(rf)
                .build();
    }
}
