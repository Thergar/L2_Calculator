package Lineage2Calculator;

import Lineage2Calculator.DTO.DTOPathResult;
import Lineage2Calculator.Errors.CustomErrors.NoPathFoundException;
import Lineage2Calculator.Utils.BaseConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApplicationFacadeTest extends BaseConfiguration {

    @Autowired
    private ApplicationFacade applicationFacade;

    @Test
    void calculateShortestPath_BFS_validResult() {
        DTOPathResult result = applicationFacade.findPath("Goddard Castle Town", "Aden Castle Town", "BFS");

        assertNotNull(result);
        assertNotNull(result.getPath());
        assertFalse(result.getPath().isEmpty());
        assertEquals(8100, result.getTotalCost());
    }

    @Test
    void calculateShortestPath_Dijkstra_validResult() {
        DTOPathResult result = applicationFacade.findPath("Elven Village", "Dwarven Village", "Dijkstra");

        assertNotNull(result);
        assertNotNull(result.getPath());
        assertFalse(result.getPath().isEmpty());
        assertEquals(35000, result.getTotalCost());
    }

    @Test
    void calculateShortestPath_BFS_Dijkstra_noPathFound() {
        String startTown = "Dwarven Village";
        String endTown = "Aden Castle Town";

        NoPathFoundException exceptionBFS = assertThrows(
                NoPathFoundException.class,
                () -> applicationFacade.findPath(startTown, endTown, "BFS")
        );

        NoPathFoundException exceptionDijkstra = assertThrows(
                NoPathFoundException.class,
                () -> applicationFacade.findPath(startTown, endTown, "Dijkstra")
        );

        assertEquals("No path found from \"Dwarven Village\" to \"Aden Castle Town\".", exceptionBFS.getMessage());
        assertEquals("No path found from \"Dwarven Village\" to \"Aden Castle Town\".", exceptionDijkstra.getMessage());
    }

    @Test
    void calculateShortestPath_invalidAlgorithm() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> applicationFacade.findPath("Dion Castle Town", "Orc Village", "invalidAlgorithm")
        );

        assertEquals("The algorithm type \"invalidAlgorithm\" does not exist.", exception.getMessage());
    }

    @Test
    void calculateShortestPath_invalidTowns() {
        String invalidTown = "NonExistent Town";

        IllegalArgumentException startTownException = assertThrows(
                IllegalArgumentException.class,
                () -> applicationFacade.findPath(invalidTown, "Goddard Castle Town", "BFS")
        );

        IllegalArgumentException endTownException = assertThrows(
                IllegalArgumentException.class,
                () -> applicationFacade.findPath("Goddard Castle Town", invalidTown, "Dijkstra")
        );

        assertEquals("The town \"NonExistent Town\" does not exist in the graph.", startTownException.getMessage());
        assertEquals("The town \"NonExistent Town\" does not exist in the graph.", endTownException.getMessage());
    }

    @Test
    void calculateShortestPath_sameTowns() {
        String town = "Goddard Castle Town";

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> applicationFacade.findPath(town, town, "BFS")
        );

        assertEquals("Starting town and destination town cannot be the same.", exception.getMessage());
    }
}
