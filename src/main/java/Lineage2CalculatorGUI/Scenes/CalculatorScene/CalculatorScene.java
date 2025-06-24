package Lineage2CalculatorGUI.Scenes.CalculatorScene;

import Lineage2CalculatorGUI.API.Errors.ApiException;
import Lineage2CalculatorGUI.API.PathfindingApi;
import Lineage2CalculatorGUI.Scenes.CalculatorScene.Components.*;
import Lineage2CalculatorGUI.Utils.CalculatePathAction;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * The {@code CalculatorScene} class represents the main view for calculating teleportation paths
 * between towns using different pathfinding algorithms.
 *
 * <p>
 * The view includes UI components for selecting the starting town, destination town,
 * pathfinding algorithm, and a button to trigger the calculation. Results are displayed
 * in a read-only text area.
 * </p>
 *
 * <p>
 * Communication with the backend is handled via the {@link PathfindingApi}, and interactions
 * are defined through {@link CalculatePathAction}.
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

        calculateButton.getCalculatorButton().disableProperty().bind(
                startCitySelector.isValid().not()
                        .or(destinationCitySelector.isValid().not())
                        .or(algorithmSelector.isValid().not()));


        try {
            calculateButton.getCalculatorButton().setOnAction(
                    CalculatePathAction
                            .calculateAction(startCitySelector, destinationCitySelector, algorithmSelector, resultBox));
        } catch (ApiException exception) {
            if (exception.getStatusCode() == 404) {
                resultBox.getResultText().setText(exception.getMessage());
            }
        }

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
