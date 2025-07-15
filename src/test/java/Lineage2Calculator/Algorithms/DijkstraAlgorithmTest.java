package Lineage2Calculator.Algorithms;

import Lineage2Calculator.DTO.DTOPathResult;
import Lineage2Calculator.Errors.ErrorHandling;
import Lineage2Calculator.Errors.Helper.NoPathFoundException;
import Lineage2Calculator.Graph.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DijkstraAlgorithmTest {

    private Graph graph;

    private DijkstraAlgorithm dijkstraAlgorithm;

    String A = "A";
    String B = "B";
    String C = "C";
    String D = "D";
    String E = "E";
    String F = "F"; // Non-existing town for testing

    @BeforeEach
    void setUp() {

        graph = new Graph();

        graph.addTown(A);
        graph.addTown(B);
        graph.addTown(C);
        graph.addTown(D);
        graph.addTown(E);

        graph.addEdge(A, B, 1);
        graph.addEdge(A, C, 3);
        graph.addEdge(A, D, 12);
        graph.addEdge(B, C, 1);
        graph.addEdge(C, E, 7);
        graph.addEdge(D, E, 1);

        dijkstraAlgorithm = new DijkstraAlgorithm(new PathReconstruct(new ErrorHandling()));
    }

    @Test
    @DisplayName("Test successful Dijkstra Algorithm path")
    void testFindCheapestPath_Successful() {

        DTOPathResult pathResult = dijkstraAlgorithm.findCheapestPath(graph, A, E);

        assertEquals(List.of(A, B, C, E), pathResult.getPath());
        assertEquals(9, pathResult.getTotalCost());
    }

    @Test
    @DisplayName("Test Dijkstra Algorithm throws error when no path was found")
    void testFindCheapestPath_PathUnavailable() {

        assertThrows(NoPathFoundException.class,
                () -> dijkstraAlgorithm.findCheapestPath(graph, A, F),
                "No path found from \"" + A + "\" to \"" + F + "\".");
    }
}
