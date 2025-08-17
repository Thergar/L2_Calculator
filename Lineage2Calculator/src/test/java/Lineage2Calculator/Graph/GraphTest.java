package Lineage2Calculator.Graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GraphTest {

    private Graph graph;

    String town1 = "Cracow";
    String town2 = "Łódź";

    @BeforeEach
    void setUp() {
        graph = new Graph();
    }

    @Test
    void getNeighbourIsEmpty() {
        graph.addTown(town1);

        assertTrue(graph.getNeighbors(town1).isEmpty());
        assertTrue(graph.getNeighbors("NonExist").isEmpty());
    }

    @Test
    void shouldNotDuplicateExistingTown() {
        graph.addTown(town1);
        graph.addTown(town1);

        assertEquals(1, graph.getAdjacencyMap().size());
    }

    @Test
    void addEdgeAndRetrieveMap() {
        int cost = 1125;

        graph.addTown(town1);
        graph.addTown(town2);

        graph.addEdge(town1, town2, cost);

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

        assertTrue(graph.containsTowns(town1));
        assertFalse(graph.containsTowns("falseTown"));
    }
}