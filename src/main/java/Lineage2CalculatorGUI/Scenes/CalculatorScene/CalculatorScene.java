package Lineage2CalculatorGUI.Scenes.CalculatorScene;

import Lineage2Calculator.DTO.BFSPathResult;
import Lineage2Calculator.DTO.DTOPathResult;
import Lineage2Calculator.DTO.DTOUserInput;
import Lineage2CalculatorGUI.API.PathfindingApi;
import Lineage2CalculatorGUI.Scenes.CalculatorScene.Components.*;
import Lineage2CalculatorGUI.Utils.Validations.EmptyFieldChecker;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * The {@code CalculatorScene} class represents the main view for calculating teleportation paths
 * between towns using different pathfinding algorithms.
 *
 * <p>
 * The layout includes selectors for choosing the start and destination cities, algorithm options,
 * a button to trigger the calculation, and a result display area.
 * </p>
 *
 * <p>
 * The results are fetched via the {@link PathfindingApi} and displayed in a read-only text area.
 * </p>
 */
public class CalculatorScene {

    private final Scene calculatorScene;

    /**
     * Constructs the calculator scene and initializes all UI components, layout, and interactions.
     *
     * @param stage the primary application stage used to display this scene
     */
    public CalculatorScene(Stage stage) {

        CitySelector startCitySelector = new CitySelector("Select start city:");
        CitySelector destinationCitySelector = new CitySelector("Select destination city:");

        AlgorithmSelector algorithmSelector = new AlgorithmSelector();

        CalculatorButton calculateButton = new CalculatorButton("Calculate Path", 15);

        ResultBox resultBox = new ResultBox();


        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(50);
        gridPane.setVgap(50);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        gridPane.getColumnConstraints().addAll(col1, col2);

        gridPane.add(startCitySelector.getContainer(), 0, 0);
        gridPane.add(destinationCitySelector.getContainer(), 1, 0);
        gridPane.add(algorithmSelector.getContainer(), 0, 1);
        gridPane.add(calculateButton.getCalculatorButton(), 1, 1);
        gridPane.add(resultBox.getResultText(), 0, 2, 2, 1);



        // Handle calculate button action.
        calculateButton.getCalculatorButton().setOnAction(actionEvent -> {
                String startTown = startCitySelector.getCityComboBox().getValue();
                String destinationTown = destinationCitySelector.getCityComboBox().getValue();
                String algorithmType = algorithmSelector.getAlgorithmGroup().getSelectedToggle().getUserData().toString();

                DTOUserInput userInput = new DTOUserInput(startTown, destinationTown, algorithmType);
                PathfindingApi pathfindingApi = new PathfindingApi();

                // Request API to process user input.
                DTOPathResult result = PathfindingApi.processCalculate(userInput);

                // Build and display the result.
                StringBuilder output = new StringBuilder();
                output.append("Path: ").append(String.join(" -> ", result.getPath())).append("\n");
                output.append("Total cost: ").append(result.getTotalCost()).append(" adena");

                if (result instanceof BFSPathResult bfsPathResult) {
                    output.append("\nSteps: ").append(bfsPathResult.getSteps());
                }

                resultBox.getResultText().setText(output.toString());
        });

        // Create calculator scene.
        calculatorScene = new Scene(gridPane);
    }

    /**
     * Returns the configured calculator scene to be displayed.
     *
     * @return the main calculator {@link Scene}
     */
    public Scene getCalculatorScene() {
        return calculatorScene;
    }
}
