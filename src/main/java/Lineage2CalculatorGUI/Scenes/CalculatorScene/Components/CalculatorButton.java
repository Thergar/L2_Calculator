package Lineage2CalculatorGUI.Scenes.CalculatorScene.Components;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

/**
 * Represents a styled calculator button used in the calculator UI.
 *
 * <p>
 * This class encapsulates a JavaFX {@link Button} with configurable text and font size,
 * making it reusable across calculator-related views.
 * </p>
 */
public class CalculatorButton {

    private final Button calculatorButton;

    /**
     * Constructs a button with the given name and font size.
     *
     * @param buttonName text displayed on the button
     * @param buttonFont font size of the button text
     */
    public CalculatorButton(String buttonName, double buttonFont) {
        this.calculatorButton = new Button(buttonName);

        this.calculatorButton.setFont(new Font(buttonFont));
    }

    /**
     * Returns the underlying JavaFX button component.
     *
     * @return the configured {@link Button} instance
     */
    public Button getCalculatorButton() {
        return calculatorButton;
    }
}
