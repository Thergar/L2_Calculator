package Lineage2Calculator.Algorithms;

import Lineage2Calculator.Errors.ErrorHandling;
import Lineage2Calculator.Errors.Helper.NoPathFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

public class PathReconstructTest {

    private PathReconstruct pathReconstruct;

    Map<String, String> previousTowns;

    String A = "A";
    String B = "B";
    String C = "C";
    String D = "D";
    String E = "E";
    String F = "F"; // Non-existing town for testing

    @BeforeEach
    void setUp() {
        pathReconstruct = new PathReconstruct(new ErrorHandling());
        previousTowns = new HashMap<>();

        previousTowns.put(A, null);
        previousTowns.put(B, A);
        previousTowns.put(C, B);
        previousTowns.put(D, C);
        previousTowns.put(E, D);
    }

    @Test
    @DisplayName("Successfully reconstructs path.")
    void testReconstructPath_Successful() {

        List<String> expectedPath1 = List.of(A, B, C ,D, E);
        List<String> expectedPath2 = List.of(A, B, C);

        List<String> finalPath1 = pathReconstruct.reconstructPath(previousTowns, A, E);
        List<String> finalPath2 = pathReconstruct.reconstructPath(previousTowns, A, C);

        assertEquals(expectedPath1, finalPath1);
        assertEquals(expectedPath2, finalPath2);
    }

    @Test
    @DisplayName("Throws NoPathFoundException error when no path is found.")
    void testReconstructPath_NoPath() {

        assertThrows(NoPathFoundException.class,
                () -> pathReconstruct.reconstructPath(previousTowns, A, F),
                "No path found from \"" + A + "\" to \"" + F + "\".");


    }
}