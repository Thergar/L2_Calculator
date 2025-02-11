package Lineage2Calculator.Algorithms;

import Lineage2Calculator.Utils.DTOPathResult;
import Lineage2Calculator.Graph.Graph;

/**
 * The {@code PathfindingAlgorithm} interface defines the contract for implementing
 * various pathfinding algorithms to calculate paths between towns in a teleportation graph.
 */
public interface PathfindingAlgorithm {

     DTOPathResult algorithmPath(Graph graph, String startTown, String endTown);

}
