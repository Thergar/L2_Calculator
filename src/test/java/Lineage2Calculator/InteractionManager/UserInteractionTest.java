package Lineage2Calculator.InteractionManager;

import Lineage2Calculator.DTO.DTOUserInput;
import Lineage2Calculator.Errors.ErrorHandling;
import Lineage2Calculator.Services.AlgorithmNameService;
import Lineage2Calculator.Services.TownService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserInteractionTest {

    @Mock
    private TownService townService;

    @Mock
    private ErrorHandling errorHandling;

    @Mock
    private AlgorithmNameService algorithmNameService;

    @InjectMocks
    private UserInteraction userInteraction;

    private String startTown = "Heine";

    private String endTown = "Talking island Village";

    private String bfsAlgorithm = "BFSAlgorithm";

    private String wrongAlgorithm = "Dijkstra";

    @BeforeEach
    void setUp() {
        when(townService.getAllTownNames()).thenReturn(Set.of("Heine", "Gludio Castle Town", "Talking Island Village", "Dion Castle Town"));
        when(algorithmNameService.getAlgorithmNames()).thenReturn(Set.of("BFSAlgorithm", "DijkstraAlgorithm"));
    }

    @Test
    void setUserChoice_correct() {

        DTOUserInput userInput = userInteraction.setUserChoice(startTown, endTown, bfsAlgorithm);

        assertThat(userInput.getStartTown()).isEqualTo(startTown);
        assertThat(userInput.getEndTown()).isEqualTo(endTown);
        assertThat(userInput.getAlgorithmName()).isEqualTo(bfsAlgorithm);

        verify(errorHandling).validateTownName(startTown, Set.of("Heine", "Gludio Castle Town", "Talking Island Village", "Dion Castle Town"));
        verify(errorHandling).validateTownName(endTown, Set.of("Heine", "Gludio Castle Town", "Talking Island Village", "Dion Castle Town"));
        verify(errorHandling).validateAlgorithmType(bfsAlgorithm, Set.of("BFSAlgorithm", "DijkstraAlgorithm"));
    }

    @Test
    void setUserChoice_algorithmError() {

        doThrow(new IllegalArgumentException("The town \"" + wrongAlgorithm + "\" does not exist in the graph."))
                .when(errorHandling).validateAlgorithmType(wrongAlgorithm, Set.of("BFSAlgorithm", "DijkstraAlgorithm"));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userInteraction.setUserChoice(startTown, endTown, wrongAlgorithm);
        });

        assertThat("The town \"" + wrongAlgorithm + "\" does not exist in the graph.").isEqualTo(exception.getMessage());

        verify(errorHandling).validateAlgorithmType(wrongAlgorithm, Set.of("BFSAlgorithm", "DijkstraAlgorithm"));
    }
}

