package Lineage2Calculator.Algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PathReconstructor {

    protected static List<String> reconstructPath(Map<String, String> previousTown, String endTown) {

        LinkedList<String> path = new LinkedList<>();
        String step = endTown;
        while (step != null) {
            path.addFirst(step);
            step = previousTown.get(step);
        }
        return path;
    }
}
