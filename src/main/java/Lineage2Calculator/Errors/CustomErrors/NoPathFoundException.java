package Lineage2Calculator.Errors.CustomErrors;

public class NoPathFoundException extends RuntimeException {

    /**
     * Creates custom error in case when no path exists between given towns
     */
    public NoPathFoundException(String message) {
        super (message);
    }
}
