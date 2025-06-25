package Lineage2CalculatorGUI.API.Errors;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * The {@code TextErrorHandler} class extends {@link DefaultResponseErrorHandler}
 * to customize error handling of HTTP responses returned by the backend API.
 *
 * <p>
 *     Instead of using default exception types, this class reads the response body
 *     as plain text and wraps it into a custom {@link ApiException} that includes the
 *     HTTP status code and the textual message for display in the UI.
 * </p>
 */
public class TextErrorHandler extends DefaultResponseErrorHandler {

    /**
     * Handles HTTP error responses by extracting the response body as plain text
     * and throwing an {@link ApiException} containing the message and status code.
     *
     * <p>
     * If the response body cannot be read, a generic message is returned instead.
     * </p>
     *
     * @param response the HTTP response containing the error
     * @throws ApiException always thrown to propagate the error with details
     */
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        try {
            String errorMessage = new String(response.getBody().readAllBytes(), StandardCharsets.UTF_8);
            throw new ApiException(errorMessage, response.getStatusCode().value());
        } catch (IOException e) {
            throw new ApiException("Unexpected error occurred while reading error response.", response.getStatusCode().value());
        }
    }
}
