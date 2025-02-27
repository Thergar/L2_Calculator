package Lineage2Calculator.Algorithms;

import Lineage2Calculator.DTOPathResult.DTOPathResult;
import Lineage2Calculator.Errors.ErrorHandling;
import Lineage2Calculator.Graph.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DijkstraAlgorithmTest {

    @Mock
    private PathReconstruct pathReconstruct;

    @Mock
    private ErrorHandling errorHandling;

    @Mock
    private Graph graph;

    @InjectMocks
    private DijkstraAlgorithm dijkstraAlgorithm;

    String A = "A";
    String B = "B";
    String C = "C";
    String D = "E";

    @BeforeEach
    void setUp() {
        lenient().when(graph.getNeighbors(A)).thenReturn(Map.of(B, 1, C, 2, D, 12));

        lenient().when(graph.getAdjacencyMap()).thenReturn(
                Map.of(
                        A, Map.of(B, 1, C, 2, D, 12),
                        B, Map.of(C, 1),
                        C, Map.of(D, 7),
                        D, Map.of()
                )
        );
    }

    @Test
    void testFindCheapestPath_Successful() {

        when(graph.getNeighbors(B)).thenReturn(Map.of(C, 1));
        when(graph.getNeighbors(C)).thenReturn(Map.of(D, 7));

        when(pathReconstruct.reconstructPath(anyMap(), eq(A), eq(D)))
                .thenReturn(List.of(A, B, C, D));

        DTOPathResult result = dijkstraAlgorithm.findCheapestPath(graph, A, D);

        assertNotNull(result);
        assertEquals(List.of(A, B, C, D), result.getPath());
        assertEquals(9, result.getTotalCost());
    }

    @Test
    void testFindCheapestPath_PathUnavailable() {

        when(graph.getNeighbors(D)).thenReturn(Map.of());

        doThrow(new IllegalArgumentException("No path found from \"" + D + "\" to \"" + A + "\"."))
                .when(pathReconstruct).reconstructPath(anyMap(), eq(D), eq(A));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> dijkstraAlgorithm.findCheapestPath(graph, D, A));

        assertEquals("No path found from \"" + D + "\" to \"" + A + "\".", exception.getMessage());
    }

    @Test
    void testFindCheapestPath_DuplicatedTown() {

        doThrow(new IllegalArgumentException("Starting town and destination town cannot be the same."))
                .when(errorHandling).validateDistinctTowns(C, C);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> dijkstraAlgorithm.findCheapestPath(graph, C, C));

        assertEquals("Starting town and destination town cannot be the same.", exception.getMessage());
    }
}
