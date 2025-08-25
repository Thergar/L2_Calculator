package l2calculator.Errors.CustomErrors;

/**
 * Exception thrown when no valid path can be found between two towns.
 *
 * <p>
 * This runtime exception is typically thrown by pathfinding components such as
 * {@code PathReconstruct} when the destination town is unreachable from the starting point.
 * </p>
 */
public class NoPathFoundException extends RuntimeException {

    /**
     * Constructs a {@code NoPathFoundException} with a custom error message.
     *
     * @param message a descriptive message indicating the failure to find a path
     */
    public NoPathFoundException(String message) {
        super (message);
    }
}