package Lineage2Calculator.Services;

import Lineage2Calculator.Algorithms.BFSAlgorithm;
import Lineage2Calculator.Algorithms.DijkstraAlgorithm;
import Lineage2Calculator.DTO.DTOPathResult;
import Lineage2Calculator.DTO.DTOUserInput;
import Lineage2Calculator.Graph.Graph;
import Lineage2Calculator.Services.Algorithm.AlgorithmNameService;
import Lineage2Calculator.Services.Algorithm.CalculateAlgorithmService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculateAlgorithmServiceTest {

    @Mock
    private GraphBuilderService graphBuilderService;

    @Mock
    private Graph graph;

    @Mock
    private BFSAlgorithm bfsAlgorithmMock;

    @Mock
    private DijkstraAlgorithm dijkstraAlgorithmMock;

    @Mock
    private DTOPathResult dtoPathResultMock;

    private AlgorithmNameService algorithmNameService;

    private CalculateAlgorithmService calculateAlgorithmService;

    @BeforeEach
    void setUp() {
        when(graphBuilderService.buildGraph()).thenReturn(graph);
        when(bfsAlgorithmMock.getAlgorithmName()).thenReturn("BFS");
        when(dijkstraAlgorithmMock.getAlgorithmName()).thenReturn("Dijkstra");

        algorithmNameService = new AlgorithmNameService(List.of(bfsAlgorithmMock, dijkstraAlgorithmMock));
        calculateAlgorithmService = new CalculateAlgorithmService(graphBuilderService, algorithmNameService);
    }

    @Test
    void testCalculatePathWithDijkstra() {
        DTOUserInput input = new DTOUserInput("startTown", "destinationTown", "Dijkstra");

        when(dijkstraAlgorithmMock.algorithmPath(graph, input.getStartTown(), input.getEndTown())).thenReturn(dtoPathResultMock);

        DTOPathResult result = calculateAlgorithmService.calculatePath(input.getStartTown(), input.getEndTown(), input.getAlgorithmName());

        assertEquals(dtoPathResultMock, result);
        verify(dijkstraAlgorithmMock).algorithmPath(graph, input.getStartTown(), input.getEndTown());
        verify(bfsAlgorithmMock, never()).findShortestPath(any(), any(), any());
    }

    @Test
    void testCalculatePathWithBFS() {
        DTOUserInput input = new DTOUserInput("startTown", "destinationTown", "BFS");

        when(bfsAlgorithmMock.algorithmPath(graph, input.getStartTown(), input.getEndTown())).thenReturn(dtoPathResultMock);

        DTOPathResult result = calculateAlgorithmService.calculatePath(input.getStartTown(), input.getEndTown(), input.getAlgorithmName());

        assertEquals(dtoPathResultMock, result);
        verify(bfsAlgorithmMock).algorithmPath(graph, input.getStartTown(), input.getEndTown());
        verify(dijkstraAlgorithmMock, never()).findCheapestPath(any(), any(), any());
    }

    @Test
    void testInvalidAlgorithmName() {
        DTOUserInput input = new DTOUserInput("startTown", "destinationTown", "Invalid");

        assertThrows(NullPointerException.class, () -> {
            calculateAlgorithmService.calculatePath(input.getStartTown(), input.getEndTown(), input.getAlgorithmName());
        });
    }
}
