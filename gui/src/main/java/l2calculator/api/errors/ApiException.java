package l2calculator.api.errors;

import org.springframework.http.HttpStatusCode;

/**
 * The {@code ApiException} class represents a custom runtime exception
 * used for handling HTTP errors returned by the backend.
 *
 * <p>
 *     It encapsulates both the error message and the HTTP status code
 *     for more granular error handling in the client application.
 * </p>
 */
public class ApiException extends RuntimeException {

    private final HttpStatusCode statusCode;

    /**
     * Constructs a new {@code ApiException} with the specified detail message and HTTP status code.
     *
     * @param message    the detail message describing the error
     * @param statusCode the HTTP status code returned by the backend
     */
    public ApiException(String message, HttpStatusCode statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }
}
