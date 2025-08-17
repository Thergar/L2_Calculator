package Lineage2Calculator.Algorithms;

import Lineage2Calculator.DTO.BFSPathResult;
import Lineage2Calculator.DTO.DTOPathResult;
import Lineage2Calculator.Errors.CustomErrors.NoPathFoundException;
import Lineage2Calculator.Errors.ErrorHandling;
import Lineage2Calculator.Graph.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BFSAlgorithmTest {

    private Graph graph;

    private BFSAlgorithm bfsAlgorithm;

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

        graph.addEdge(A, B, 2);
        graph.addEdge(A, C, 2);
        graph.addEdge(B, C, 4);
        graph.addEdge(B, D, 5);
        graph.addEdge(D, E, 1);
        graph.addEdge(C, E, 4);

        bfsAlgorithm = new BFSAlgorithm(new PathReconstruct(new ErrorHandling()));
    }

    @Test
    @DisplayName("Test successful BFS Algorithm path")
    void testFindShortestPath_Successful() {

        DTOPathResult pathResult = bfsAlgorithm.findShortestPath(graph, A, E);

        assertEquals(List.of(A, C, E), pathResult.getPath());
        assertEquals(6, pathResult.getTotalCost());
        assertEquals(2, ((BFSPathResult) pathResult).getSteps());
    }

    @Test
    @DisplayName("Test BFS Algorithm throws error when no path was found")
    void testFindShortestPath_PathUnavailable() {

        assertThrows(NoPathFoundException.class,
                () -> bfsAlgorithm.findShortestPath(graph, A, F),
                "No path found from \"" + A + "\" to \"" + F + "\".");
    }
}
