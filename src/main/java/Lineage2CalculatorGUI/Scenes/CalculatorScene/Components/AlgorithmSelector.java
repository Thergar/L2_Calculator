package Lineage2CalculatorGUI.Scenes.CalculatorScene.Components;

import Lineage2CalculatorGUI.API.AlgorithmApi;
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
 * It creates two radio buttons: one for selecting the cheapest path (Dijkstra algorithm)
 * and another for the fastest path (BFS algorithm).
 * Buttons are grouped using a {@link ToggleGroup} to ensure only one option
 * is selected at a time.
 * </p>
 */
public class AlgorithmSelector {

    private final VBox container;
    private final ToggleGroup algorithmGroup;

    public AlgorithmSelector() {
        this.algorithmGroup = new ToggleGroup();

        Label algorithmLabel = new Label("Select path type:");
        algorithmLabel.setFont(new Font(15));

        RadioButton dijkstra = createAlgorithmButton("Cheapest path", 15);
        dijkstra.setUserData(AlgorithmApi.fetchDijkstraAlgorithm());
        dijkstra.setToggleGroup(algorithmGroup);

        RadioButton bfs = createAlgorithmButton("Fastest path", 15);
        bfs.setUserData(AlgorithmApi.fetchBFSAlgorithm());
        bfs.setToggleGroup(algorithmGroup);

        this.container = new VBox(10, algorithmLabel, dijkstra, bfs);
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
}
