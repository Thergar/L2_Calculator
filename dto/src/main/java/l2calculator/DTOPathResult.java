package l2calculator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

/**
 * DTO representing the result of a pathfinding algorithm.
 * <p>
 * Stores the route and total cost. Supports polymorphic JSON serialization, and class is designed to be immutable.
 * </p>
 *
 * @see DijkstraPathResult
 * @see BFSPathResult
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = DijkstraPathResult.class, name = "dijkstra"),
        @JsonSubTypes.Type(value = BFSPathResult.class, name = "bfs")
})
public abstract class DTOPathResult {

    private List<String> path;
    private int totalCost;

    /**
     * A Class {@code lineage2calculator.dto.DTOPathResult} is data transfer object that represents a result of a pathfinding algorithm.
     * <p>
     *     This class encapsulates the result data and ensure that after creation result cannot be modified.
     * </p>
     */
    public DTOPathResult(List<String> path, int totalCost) {
        this.path = path;
        this.totalCost = totalCost;
    }

    public DTOPathResult () {}

    /**
     * Retrieves the route represented as list of towns.
     */
    public List<String> getPath() {
        return path;
    }

    /**
     * Retrieves the total cost for the teleportation path.
     */
    public int getTotalCost() {
        return totalCost;
    }
}
