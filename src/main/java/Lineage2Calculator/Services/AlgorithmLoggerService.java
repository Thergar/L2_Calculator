package Lineage2Calculator.Services;

import Lineage2Calculator.DTO.DTOPathResult;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Consumer;

/**
 * Service responsible for logging algorithm results.
 */
@Component
public class AlgorithmLoggerService {


    private void commonLog(String algorithmName, DTOPathResult result) {
        System.out.println("Using " + algorithmName + " algorithm");
        System.out.println("Path: " + result.getPath());
        System.out.println("Total cost of the path: " + result.getTotalCost() + " adena");
    }

   private final Map<String, Consumer<DTOPathResult>> logStrategies = Map.of(
           "DijkstraAlgorithm", result -> commonLog("Dijkstra", result),
           "BFSAlgorithm", result -> {
               commonLog("BFS", result);
               System.out.println("Number of steps: " + result.getSteps());
           }
   );

    public void log(String algorithmName, DTOPathResult result) {
       logStrategies.get(algorithmName).accept(result);
    }
}
