package Lineage2Calculator.Services.Algorithm;

import Lineage2Calculator.Algorithms.PathfindingAlgorithm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service class responsible for managing and retrieving instances of pathfinding algorithms.
 *
 * <p>
 *     This service maps and organizes all available implementations of {@link PathfindingAlgorithm}
 *     so they can be retrieved and utilized dynamically at runtime based on their names.
 *     The {@code algorithmMap} is constructed by scanning all algorithm implementations and registering
 *     them using their class simple names as keys, allowing for quick lookup.
 * </p>
 */
@Service
public class AlgorithmNameService {

    private final Map<String, PathfindingAlgorithm> algorithmMap;

    public AlgorithmNameService(List<PathfindingAlgorithm> algorithms) {
        this.algorithmMap = algorithms.stream()
                .collect(Collectors
                        .toMap(algorithm -> algorithm.getClass()
                                .getSimpleName(), algorithm -> algorithm));
    }

    /**
     * Retrieves the names of all registered pathfinding algorithms.
     *
     * @return a set of strings containing the names of available algorithms.
     */
    public Set<String> getAlgorithmNames() {
        return algorithmMap.keySet();
    }

    /**
     * Retrieves an algorithm by its name.
     *
     * @param algorithmName the name of the algorithm.
     * @return the selected {@link PathfindingAlgorithm}.
     * @throws IllegalArgumentException if the algorithm name is invalid.
     */
    public PathfindingAlgorithm getAlgorithm(String algorithmName) {
        return algorithmMap.get(algorithmName);
    }
}
