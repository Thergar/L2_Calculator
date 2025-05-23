package Lineage2Calculator.REST.Controllers;

import Lineage2Calculator.Services.TownService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * REST controller class, handles towns related requests.
 */
@RestController
@RequestMapping("/api/towns")
@CrossOrigin(origins = "*")
public class TownController {

    private final TownService townService;

    public TownController(TownService townService) {
        this.townService = townService;
    }

    @GetMapping("/all")
    public Set<String> getAllTownsName() {
        return townService.getAllTownNames();
    }
}