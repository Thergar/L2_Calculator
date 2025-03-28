package Lineage2Calculator.Api.Controllers;

import Lineage2Calculator.Services.Algorithm.AlgorithmService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * REST controller class, responsible for displays algorithm names.
 */
@RestController
@RequestMapping("/api/algorithm")
@CrossOrigin(origins = "*")
public class AlgorithmController {

    private final AlgorithmService algorithmNameService;

    public AlgorithmController(AlgorithmService algorithmNameService) {
        this.algorithmNameService = algorithmNameService;
    }

    /**
     * Retrieves all available algorithm names
     *
     *  @return a set of available algorithm names.
     */
    @GetMapping("/names")
    public Set<String> getAllAlgorithmName() {
        return algorithmNameService.getAlgorithmNames();
    }
}
