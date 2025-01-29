package Lineage2Calculator.Enum;

import Lineage2Calculator.Algorithms.BFSAlgorithm;
import Lineage2Calculator.Algorithms.DijkstraAlgorithm;
import Lineage2Calculator.DTOPathResult;
import Lineage2Calculator.Graph.Graph;



public enum AlgorithmType {

    DIJKSTRA {

/**
 * Executes the {@link DijkstraAlgorithm#findCheapestPath(Graph, String, String)} method to find the cheapest path.
 * <p>
 *     This method uses Dijkstra's algorithm to calculate the cheapest path between
 *     the starting town and destination town in the given graph,
 *     and returns a {@link DTOPathResult} object.
 * </p>
 *
 * @return a {@link DTOPathResult} object containing details about dijkstra path.
 */
        @Override
        public DTOPathResult execute(Graph graph, String startTown, String endTown) {
            return DijkstraAlgorithm.findCheapestPath(graph, startTown, endTown);
        }

/**
 * Displays in console information about the path and total cost associated with that path.
 */
        @Override
        public void logResult(DTOPathResult result) {
            System.out.println("Cheapest path is: " + result.getPath());
            System.out.println("Total costs of path is: " + result.getTotalCost());
        }
    },


    BFS {

/**
 * Executes the {@link BFSAlgorithm#findShortestPath(Graph, String, String)} method to find the shortest path.
 * <p>
 *     This method uses BFS algorithm to calculate the shortest path between
 *     the starting town and the destination town in the given graph,
 *     and returns {@link DTOPathResult} object.
 * </p>
 *
 * @return a {@link DTOPathResult} object containing details about BFS path.
 */
        @Override
        public DTOPathResult execute(Graph graph, String startTown, String endTown){
            return BFSAlgorithm.findShortestPath(graph, startTown, endTown);
        }

/**
 * Displays in console information about the cheapest path and detail cost associated with that path.
 */
        @Override
        public void logResult(DTOPathResult result) {
            System.out.println("Cheapest path is: " + result.getPath());
            System.out.println("Total costs of path is: " + result.getTotalCost());
            System.out.println("Total steps of path: " + result.getSteps());
        }
    };

/**
 * Abstract method that must be implemented by each algorithm in the enum and returns DTOPathResult.
 * It calculates the path between the "startTown" and "endTown" in the given graph.
 *
 * @param graph Representing the connections between towns.
 * @param startTown The Name of starting town.
 * @param endTown The name of the destination town.
 * @return A DTOPathResult object containing details about given path.
 */
    public abstract DTOPathResult execute(Graph graph, String startTown, String endTown);

/**
 * Abstract method responsible for displays information associated with chosen path.
 *
 * @param result {@link DTOPathResult} object containing the details of the path.
 */
    public abstract  void logResult(DTOPathResult result);
}
