package l2calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class DTOPathResultFactoryTest {

    String town1 = "Dion";
    String town2 = "Gludin";
    String town3 = "Heine";

    int totalCost = 5500;

    List<String> path;

    @BeforeEach
    void setUp() {
        path = Arrays.asList(town1, town2, town3);
    }
    @Test
    @DisplayName("Should create a lineage2calculator.dto.DTOPathResult for Dijkstra algorithm")
    void testForDijkstra_Successful() {

        DTOPathResult result = DTOPathResultFactory.forDijkstra(path, totalCost);

        assertInstanceOf(DijkstraPathResult.class, result);
        assertEquals(path, result.getPath());
        assertEquals(totalCost, result.getTotalCost());
    }

    @Test
    @DisplayName("Should create a lineage2calculator.dto.DTOPathResult for BFS algorithm")
    void testForBFS_Successful() {

        int steps = 2;

        DTOPathResult result = DTOPathResultFactory.forBFS(path, totalCost, steps);

        assertInstanceOf(BFSPathResult.class, result);
        assertEquals(path, result.getPath());
        assertEquals(5500, result.getTotalCost());
        assertEquals(steps, ((BFSPathResult) result).getSteps());
    }

    @Test
    @DisplayName("Should handle empty path for Dijkstra")
    void forDijkstra_emptyPath() {
        DTOPathResult result = DTOPathResultFactory.forDijkstra(List.of(), 0);

        assertEquals(0, result.getPath().size());
        assertEquals(0, result.getTotalCost());
    }

    @Test
    @DisplayName("Should handle empty path for BFS")
    void forBFS_emptyPath() {
        DTOPathResult result = DTOPathResultFactory.forBFS(List.of(), 0, 0);

        assertEquals(0, result.getPath().size());
        assertEquals(0, result.getTotalCost());
        assertEquals(0, ((BFSPathResult) result).getSteps());
    }
}