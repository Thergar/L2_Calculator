package l2calculator.REST.Controllers;

import l2calculator.Services.Algorithm.AlgorithmNameService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * backend.REST controller class, responsible for displays algorithm names.
 */
@RestController
@RequestMapping("/algorithm")
@CrossOrigin(origins = "*")
public class AlgorithmController {

    private final AlgorithmNameService algorithmNameService;

    public AlgorithmController(AlgorithmNameService algorithmNameService) {
        this.algorithmNameService = algorithmNameService;
    }

    /**
     * Retrieves all available algorithm names
     *
     *  @return a set of available algorithm names.
     */
    @GetMapping("/names")
    private Set<String> getAllAlgorithmName() {
        return algorithmNameService.getAlgorithmNames();
    }

    @GetMapping("/dijkstra")
    public String getDijkstraAlgorithm() {
        return "Dijkstra";
    }

    @GetMapping("/bfs")
    public String getBFSAlgorithm() {
        return "BFS";
    }
}
