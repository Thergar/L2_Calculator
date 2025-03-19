package Lineage2Calculator.Algorithms;

import Lineage2Calculator.DTO.DTOPathResult;
import Lineage2Calculator.Errors.ErrorHandling;
import Lineage2Calculator.Graph.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
public class BFSAlgorithmTest {

    @Mock
    private PathReconstruct pathReconstruct;

    @Mock
    private ErrorHandling errorHandling;

    @Mock
    private Graph graph;

    @InjectMocks
    private BFSAlgorithm bfsAlgorithm;

    String A = "A";
    String B = "B";
    String C = "C";
    String D = "D";
    String E = "E";

    @BeforeEach
    void setUp() {
        lenient().when(graph.getNeighbors(A)).thenReturn(Map.of(B, 1, C, 2));
        lenient().when(graph.getNeighbors(B)).thenReturn(Map.of(C, 4));
        lenient().when(graph.getNeighbors(C)).thenReturn(Map.of(E, 4));
    }

    @Test
    void testFindShortestPath_Successful() {

        when(pathReconstruct.reconstructPath(anyMap(), eq(A), eq(E)))
                .thenReturn(List.of(A, C, E));

        DTOPathResult result = bfsAlgorithm.findShortestPath(graph, A ,E);

        assertNotNull(result);
        assertEquals(List.of(A, C, E), result.getPath());
        assertEquals(6, result.getTotalCost());
        assertEquals(2, result.getSteps());
    }

    @Test
    void testFindShortestPath_PathUnavailable() {

        when(graph.getNeighbors(E)).thenReturn(Map.of(B, 5));
        when(graph.getNeighbors(D)).thenReturn(Map.of());

        System.out.println("Neighbors of A: " + graph.getNeighbors(A));
        System.out.println("Neighbors of B: " + graph.getNeighbors(B));
        System.out.println("Neighbors of C: " + graph.getNeighbors(C));
        System.out.println("Neighbors of E: " + graph.getNeighbors(E));
        System.out.println("Neighbors of D: " + graph.getNeighbors(D));

        doAnswer(invocation -> {
            System.out.println("reconstructPath called with " + invocation.getArgument(1) + " and " + invocation.getArgument(2));
            throw new IllegalArgumentException("No path found from \"" + A + "\" to \"" + D + "\".");
        }).when(pathReconstruct).reconstructPath(anyMap(), eq(A), eq(D));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> bfsAlgorithm.findShortestPath(graph, A, D));

        assertEquals("No path found from \"" + A + "\" to \"" + D + "\".", exception.getMessage());
    }

    @Test
    void testFindShortestPath_DuplicatedTown() {

        doThrow(new IllegalArgumentException("Starting town and destination town cannot be the same."))
                .when(errorHandling).validateDistinctTowns(A, A);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> bfsAlgorithm.findShortestPath(graph, A, A));

        assertEquals("Starting town and destination town cannot be the same.", exception.getMessage());
    }
}
