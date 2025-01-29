package Lineage2Calculator.MainApplication;

import Lineage2Calculator.DTOPathResult;
import Lineage2Calculator.Enum.AlgorithmType;
import Lineage2Calculator.Graph.Graph;

/** Class responsible for executing pathfinding algorithm. */
public class AlgorithmExecution {

/** Executes the specified pathfinding algorithm to determine cheapest or fastest path between two towns.
 *
 * @param pathType the type of algorithm to use defined in {@link AlgorithmType}
 * @param graph the graph representing the teleportation network from {@link Graph}
 * @param startTown the name of starting town.
 * @param endTown the name od destination town.
 *
 * @return a {@link DTOPathResult} object containing details associated with selected {@code pathType}.
 */
    public  DTOPathResult executeAlgorithm(AlgorithmType pathType, Graph graph, String startTown, String endTown) {

            DTOPathResult result = pathType.execute(graph, startTown, endTown);
            pathType.logResult(result);
            return result;

    }
}

