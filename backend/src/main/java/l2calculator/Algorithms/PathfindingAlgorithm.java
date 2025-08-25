package l2calculator.Algorithms;


import l2calculator.Graph.Graph;
import l2calculator.DTOPathResult;

/**
 * The {@code PathfindingAlgorithm} interface defines the contract for implementing
 * various pathfinding algorithms to calculate paths between towns in a teleportation graph.
 */
public interface PathfindingAlgorithm {

     DTOPathResult algorithmPath(Graph graph, String startTown, String endTown);

     String getAlgorithmName();

}
