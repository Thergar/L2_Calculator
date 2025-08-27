package l2calculator.scenes.calculatorscene;

import l2calculator.api.PathfindingApi;
import l2calculator.scenes.calculatorscene.components.AlgorithmSelector;
import l2calculator.scenes.calculatorscene.components.CalculatorButton;
import l2calculator.scenes.calculatorscene.components.CitySelector;
import l2calculator.scenes.calculatorscene.components.ResultBox;
import l2calculator.scenes.utils.CalculatePathAction;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Objects;

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
        // UI components initialization.
        CitySelector startCitySelector = new CitySelector("Select start city:");
        CitySelector destinationCitySelector = new CitySelector("Select destination city:");

        AlgorithmSelector algorithmSelector = new AlgorithmSelector();

        CalculatorButton calculateButton = new CalculatorButton("Calculate Path", 15);

        ResultBox resultBox = new ResultBox();

        // Layout configuration.
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

        // Button action and validation.
        calculateButton.getCalculatorButton().disableProperty().bind(
                startCitySelector.isValid().not()
                        .or(destinationCitySelector.isValid().not())
                        .or(algorithmSelector.isValid().not()));

        calculateButton.getCalculatorButton().setOnAction(
                    CalculatePathAction
                            .calculateAction(startCitySelector, destinationCitySelector, algorithmSelector, resultBox));

        StackPane root = new StackPane();

        // Background image setup.
        Image backgroundImage = new Image(Objects.requireNonNull(getClass().getResource("/images/L2_map_C4.jpg")).toExternalForm());
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setPreserveRatio(false);
        backgroundImageView.setSmooth(true);
        StackPane.setAlignment(backgroundImageView, javafx.geometry.Pos.CENTER);

        root.getChildren().addAll(backgroundImageView, gridPane);

        root.setMinWidth(800);
        root.setMinHeight(700);
        root.setPrefWidth(1000);
        root.setPrefHeight(800);

        // Calculator scene.
        calculatorScene = new Scene(root, 1000, 800);

        // Bind background to scene size
        backgroundImageView.fitWidthProperty().bind(calculatorScene.widthProperty());
        backgroundImageView.fitHeightProperty().bind(calculatorScene.heightProperty());
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
