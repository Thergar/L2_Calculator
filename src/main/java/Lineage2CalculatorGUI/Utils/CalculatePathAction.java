package Lineage2CalculatorGUI.Utils;

import Lineage2Calculator.DTO.BFSPathResult;
import Lineage2Calculator.DTO.DTOPathResult;
import Lineage2Calculator.DTO.DTOUserInput;
import Lineage2CalculatorGUI.API.Errors.ApiException;
import Lineage2CalculatorGUI.API.PathfindingApi;
import Lineage2CalculatorGUI.Scenes.CalculatorScene.Components.AlgorithmSelector;
import Lineage2CalculatorGUI.Scenes.CalculatorScene.Components.CitySelector;
import Lineage2CalculatorGUI.Scenes.CalculatorScene.Components.ResultBox;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Provides a factory method for creating an action handler
 * that calculates and displays a teleportation path based on user input.
 *
 * <p>
 * This class collects values from the UI components, sends them to the backend,
 * and displays either the pathfinding result or an error message.
 * </p>
 */
public class CalculatePathAction {

    /**
     * Creates an event handler that triggers the pathfinding process.
     *
     * <p>
     * When the returned handler is invoked (e.g., on a button click),
     * it gathers user input from the form, sends a request to the backend
     * using {@link PathfindingApi}, and updates the provided {@link ResultBox}
     * with the result or an error message.
     * </p>
     *
     * @param startCitySelector      the selector for the starting town
     * @param destinationCitySelector the selector for the destination town
     * @param algorithmSelector      the selector for the pathfinding algorithm
     * @param resultBox              the result display area
     * @return an {@code EventHandler<ActionEvent>} ready to be attached to a UI control
     */
    public static EventHandler<ActionEvent> calculateAction(
            CitySelector startCitySelector,
            CitySelector destinationCitySelector,
            AlgorithmSelector algorithmSelector,
            ResultBox resultBox) {

        return event -> {

            String startTown = startCitySelector.getTextField().getText();
            String destinationTown = destinationCitySelector.getTextField().getText();
            String algorithmType = algorithmSelector.getAlgorithmGroup().getSelectedToggle().getUserData().toString();
                
            // Request API to process user input.
            DTOUserInput userInput = new DTOUserInput(startTown, destinationTown, algorithmType);

            try {
                DTOPathResult result = PathfindingApi.processCalculate(userInput);

                StringBuilder output = new StringBuilder();
                output.append("Path: ").append(String.join(" -> ", result.getPath())).append("\n");
                output.append("Total cost: ").append(result.getTotalCost()).append(" adena");

                if (result instanceof BFSPathResult bfsPathResult) {
                    output.append("\nSteps: ").append(bfsPathResult.getSteps());
                }

                resultBox.getResultText().setText(output.toString());
            } catch (ApiException exception) {
                resultBox.getResultText().setText("Error: " + exception.getMessage());
            }


        };
    }
}
