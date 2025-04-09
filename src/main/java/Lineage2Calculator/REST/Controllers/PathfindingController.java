package Lineage2Calculator.REST.Controllers;

import Lineage2Calculator.ApplicationFacade;
import Lineage2Calculator.DTO.DTOPathResult;
import Lineage2Calculator.DTO.DTOUserInput;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller responsible for handling pathfinding requests.
 */
@RestController
@RequestMapping("api/pathfinding")
@CrossOrigin(origins = "*")
public class PathfindingController {

    private final ApplicationFacade applicationFacade;

    public PathfindingController(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @PostMapping("/calculate")
    public DTOPathResult calculatePath(@RequestBody DTOUserInput userInput) {
        return applicationFacade.findPath(userInput.getStartTown(), userInput.getEndTown(), userInput.getAlgorithmName());
    }
}
