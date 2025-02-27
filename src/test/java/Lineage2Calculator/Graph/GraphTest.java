package Lineage2Calculator.Graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {

    private Graph graph = new Graph();

    private Map<String, Map<String,Integer>> adjacencyMap;

    String town1 = "Cracow";
    String town2 = "Łódź";

    @BeforeEach
    void setUp() {
        adjacencyMap = new HashMap<>();
    }

    @Test
    void addTownToMap() {

        graph.addTown(town1);
        graph.addTown(town2);

        assertTrue(graph.getAdjacencyMap().containsKey(town1));
        assertTrue(graph.getAdjacencyMap().containsKey(town2));
    }

    @Test
    void shouldNotDuplicateExistingTown() {

        graph.addTown(town1);
        graph.addTown(town1);

        int size = graph.getAdjacencyMap().size();

        assertEquals(1, size);
    }

    @Test
    void addEdgeAndRetrieveMap() {

        int cost = 1125;

        graph.addTown(town1);
        graph.addTown(town2);

        graph.addEdge(town1, town2, cost);

        adjacencyMap = graph.getAdjacencyMap();

        assertTrue(graph.getAdjacencyMap().containsKey(town1));
        assertEquals(Map.of(town2, cost), graph.getAdjacencyMap().get(town1));

    }

    @Test
    void returnEmptyNeighbor() {

        assertTrue(graph.getNeighbors(town1).isEmpty());
    }

    @Test
    void checkIfTownExists() {

        graph.addTown(town1);

        assertTrue(graph.containsTown(town1));
        assertFalse(graph.containsTown("falseTown"));
    }
}
