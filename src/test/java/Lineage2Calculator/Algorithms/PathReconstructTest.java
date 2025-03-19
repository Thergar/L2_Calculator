package Lineage2Calculator.Algorithms;

import Lineage2Calculator.Errors.ErrorHandling;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PathReconstructTest {

    @Mock
    private ErrorHandling errorHandling;

    @InjectMocks
    private PathReconstruct pathReconstruct;

    Map<String, String> previousTowns;

    String A = "A";
    String B = "B";
    String C = "C";
    String D = "D";
    String E = "E";

    @BeforeEach
    void setUp() {
        previousTowns = new HashMap<>();
    }
    @Test
    void testReconstructPath_Successful() {

        previousTowns.put(A, null);
        previousTowns.put(B, A);
        previousTowns.put(C, B);
        previousTowns.put(D, C);
        previousTowns.put(E, D);

        List<String> expectedPath1 = List.of(A, B, C ,D, E);
        List<String> expectedPath2 = List.of(A, B, C);

        List<String> finalPath1 = pathReconstruct.reconstructPath(previousTowns, A, E);
        List<String> finalPath2 = pathReconstruct.reconstructPath(previousTowns, A, C);

        assertEquals(expectedPath1, finalPath1);
        assertEquals(expectedPath2, finalPath2);
    }

    @Test
    void testReconstructPath_NoPath() {

        previousTowns.put(A, null);
        previousTowns.put(B, A);
        previousTowns.put(C, B);

        doThrow(new IllegalArgumentException("No path found from \"" + A + "\" to \"" + D + "\"."))
                .when(errorHandling).pathNotFound(anyMap(), eq(A), eq(D));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> pathReconstruct.reconstructPath(previousTowns, A, D));

        assertEquals("No path found from \"" + A + "\" to \"" + D + "\".", exception.getMessage());
        verify(errorHandling).pathNotFound(previousTowns, A, D);
    }
}