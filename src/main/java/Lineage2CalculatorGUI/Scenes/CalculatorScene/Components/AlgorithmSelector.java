package Lineage2CalculatorGUI.Scenes.CalculatorScene.Components;

import Lineage2CalculatorGUI.API.AlgorithmApi;
import Lineage2CalculatorGUI.Utils.Validations.FieldValidation;
import javafx.beans.property.BooleanProperty;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * The {@code AlgorithmSelector} class provides a UI component for selecting
 * a pathfinding algorithm.
 *
 * <p>
 * This component provides two radio buttons grouped under a single toggle:
 * one for the Dijkstra algorithm ("Cheapest path") and another for the BFS algorithm ("Fastest path").
 * The selection is validated and a message is shown if no option is selected.
 * </p>
 */
public class AlgorithmSelector {

    private final VBox container;
    private final ToggleGroup algorithmGroup;
    private final Label validationMessage;
    private final BooleanProperty valid;

    /**
     * Initializes the algorithm selector UI component, including radio buttons,
     * labels, and validation message display.
     */
    public AlgorithmSelector() {
        this.algorithmGroup = new ToggleGroup();

        Label algorithmLabel = new Label("Select path type:");
        algorithmLabel.setFont(new Font(15));

        this.validationMessage = new Label();
        this.validationMessage.setVisible(false);

        RadioButton dijkstra = createAlgorithmButton("Cheapest path", 15);
        dijkstra.setUserData(AlgorithmApi.fetchDijkstraAlgorithm());
        dijkstra.setToggleGroup(algorithmGroup);

        RadioButton bfs = createAlgorithmButton("Fastest path", 15);
        bfs.setUserData(AlgorithmApi.fetchBFSAlgorithm());
        bfs.setToggleGroup(algorithmGroup);

        this.valid = FieldValidation.algorithmValidation(algorithmGroup, validationMessage);

        this.container = new VBox(10, algorithmLabel, dijkstra, bfs, validationMessage);
    }

    /**
     * Creates a {@link RadioButton} with the given label and font size.
     *
     * @param userFriendlyAlgorithmName the label to display on the radio button.
     * @param pathTypeFont the font size to apply to the button's text.
     * @return a configured {@code RadioButton} instance.
     */
    private RadioButton createAlgorithmButton(String userFriendlyAlgorithmName, double pathTypeFont) {

        RadioButton algorithmButton = new RadioButton(userFriendlyAlgorithmName);
        algorithmButton.setFont(new Font(pathTypeFont));

        return algorithmButton;
    }

    /**
     * Returns the toggle group associated with the algorithm radio buttons.
     */
    public ToggleGroup getAlgorithmGroup() {
        return algorithmGroup;
    }

    /**
     * Returns the container node that holds the UI elements for this component.
     */
    public VBox getContainer() {
        return container;
    }

    public BooleanProperty isValid() {
        return valid;
    }

    public Label getValidationMessage() {
        return validationMessage;
    }
}
