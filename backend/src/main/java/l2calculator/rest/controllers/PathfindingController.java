package l2calculator.rest.controllers;

import l2calculator.ApplicationFacade;
import l2calculator.DTOPathResult;
import l2calculator.DTOUserInput;
import org.springframework.web.bind.annotation.*;

/**
 * backend.REST Controller responsible for handling pathfinding requests.
 */
@RestController
@RequestMapping("/pathfinding")
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
