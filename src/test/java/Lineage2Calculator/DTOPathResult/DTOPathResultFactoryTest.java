package Lineage2Calculator.DTOPathResult;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class DTOPathResultFactoryTest {

    String town1 = "Cracow";
    String town2 = "Rzeszów";
    String town3 = "Myslenice";

    int totalCost = 5500;

    List<String> path;


    @BeforeEach
    void setUp() {
        path = List.of(town1, town2, town3);
    }

    @Test
    void forDijkstra_Test() {

        DTOPathResult result = DTOPathResultFactory.forDijkstra(path, totalCost);

        assertInstanceOf(DijkstraPathResult.class, result);
        assertEquals(List.of("Cracow", "Rzeszów", "Myslenice"), result.getPath());
        assertEquals(5500, result.getTotalCost());
    }

    @Test
    void forBFS_Test() {

        int steps = 2;

        DTOPathResult result = DTOPathResultFactory.forBFS(path, totalCost, steps);

        assertInstanceOf(BFSPathResult.class, result);
        assertEquals(List.of("Cracow", "Rzeszów", "Myslenice"), result.getPath());
        assertEquals(5500, result.getTotalCost());
        assertEquals(2, result.getSteps());
    }
}
