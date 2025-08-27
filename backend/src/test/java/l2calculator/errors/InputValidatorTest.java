package l2calculator.errors;

import l2calculator.services.algorithm.AlgorithmNameService;
import l2calculator.services.TownService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InputValidatorTest {

    @Mock
    private TownService townService;

    @Mock
    private AlgorithmNameService algorithmNameService;

    private final ErrorHandling errorHandling = new ErrorHandling();

    private InputValidator inputValidator;

    String startTown = "StartTown";
    String endTown = "EndTown";
    String invalidTown = "InvalidTown";

    String algorithmName1 = "Dijkstra";
    String algorithmName2 = "BFS";
    String invalidAlgorithmName = "UnknownAlgorithm";

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator(townService, algorithmNameService, errorHandling);
    }

    @Test
    @DisplayName("Provide valid user input for pathfinding")
    void testValidInput() {

        when(townService.getAllTownNames()).thenReturn(Set.of(startTown, endTown));
        when(algorithmNameService.getAlgorithmNames()).thenReturn(Set.of(algorithmName1, algorithmName2));

        assertDoesNotThrow(() -> inputValidator.validateTownName(startTown));
        assertDoesNotThrow(() -> inputValidator.validateTownName(endTown));

        assertDoesNotThrow(() -> inputValidator.validateAlgorithmName(algorithmName1));
        assertDoesNotThrow(() -> inputValidator.validateAlgorithmName(algorithmName2));
    }

    @Test
    @DisplayName("Should throw exception for invalid town name")
    void testInvalidTownName() {
        when(townService.getAllTownNames()).thenReturn(Set.of(startTown, endTown));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateTownName(invalidTown);
        });

        assertEquals("The town \"" + invalidTown + "\" does not exist in the graph.", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw exception for invalid algorithm name")
    void testInvalidAlgorithmName() {
        when(algorithmNameService.getAlgorithmNames()).thenReturn(Set.of(algorithmName1, algorithmName2));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateAlgorithmName(invalidAlgorithmName);
        });

        assertEquals("The algorithm type \"" + invalidAlgorithmName + "\" does not exist.", exception.getMessage());
    }

    @Test
    @DisplayName("Should pass distinct town name")
    void testDistinctTowns() {

        assertDoesNotThrow(() -> inputValidator.validateDistinctTowns(startTown, endTown));
    }

    @Test
    @DisplayName("Should throw exception for identical start and end towns")
    void testIdenticalStartAndEndTowns() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateDistinctTowns(startTown, startTown);
        });

        assertEquals("Starting town and destination town cannot be the same.", exception.getMessage());
    }
}
