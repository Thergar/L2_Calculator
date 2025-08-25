package l2calculator.Errors;

/**
 * The {@code ApiException} class represents a custom runtime exception
 * used for handling HTTP errors returned by the backend API.
 *
 * <p>
 *     It encapsulates both the error message and the HTTP status code
 *     for more granular error handling in the client application.
 * </p>
 */
public class ApiException extends RuntimeException {

    private final int statusCode;

    /**
     * Constructs a new {@code ApiException} with the specified detail message and HTTP status code.
     *
     * @param message    the detail message describing the error
     * @param statusCode the HTTP status code returned by the backend
     */
    public ApiException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
