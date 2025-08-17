package Lineage2Calculator.Services;

import Lineage2Calculator.Graph.Graph;
import Lineage2Calculator.Utils.BaseConfiguration;
import Lineage2Calculator.Utils.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@IntegrationTest
public class GraphBuilderServiceTest extends BaseConfiguration {

    @Autowired
    private GraphBuilderService graphBuilderService;

    @Test
    void buildGraphFrom_RecurseCorrectlyData() {
        String Dion = "Dion Castle Town";

        Graph graph = graphBuilderService.buildGraphFrom(Dion);


        assertNotNull(graph);
        assertTrue(graph.containsTowns("Goddard Castle Town"));
        assertTrue(graph.containsTowns("Dwarven Village"));
        assertEquals(2, graph.getNeighbors(Dion).size());
        assertEquals(3, graph.getNeighbors("Goddard Castle Town").size());
        assertTrue(graph.getNeighbors(Dion).containsKey("Aden Castle Town"));
        assertTrue(graph.getNeighbors(Dion).containsKey("Goddard Castle Town"));
    }

    @Test
    void buildGraphFrom_EmptyTown_ReturnsEmptyGraph() {
        String dwarven = "Dwarven Village";

        Graph graph = graphBuilderService.buildGraphFrom(dwarven);

        assertTrue(graph.getNeighbors(dwarven).isEmpty());
    }

    @Test
    void buildGraphFrom_AllTownsFromStartTown() {
        String goddard = "Goddard Castle Town";

        Graph graph = graphBuilderService.buildGraphFrom(goddard);

        Map<String, Map<String, Integer>> expectedTowns = Map.of(
                "Dwarven Village", Map.of(),
                "Aden Castle Town", Map.of(
                        "Dion Castle Town", 52000,
                        "Goddard Castle Town", 8100
                ),
                "Dion Castle Town", Map.of(
                        "Aden Castle Town", 52000,
                        "Goddard Castle Town", 71000
                ),
                "Goddard Castle Town", Map.of(
                        "Dwarven Village", 38000,
                        "Aden Castle Town", 8100,
                        "Dion Castle Town", 71000
                )
        );

        assertEquals(expectedTowns, graph.getAdjacencyMap());
        assertFalse(graph.containsTowns("Elven Village"));
    }
}
