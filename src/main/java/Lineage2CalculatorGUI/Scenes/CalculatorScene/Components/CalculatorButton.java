package Lineage2CalculatorGUI.Scenes.CalculatorScene.Components;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

/**
 * Class creates a styled calculator button.
 */
public class CalculatorButton {

    private final Button calculatorButton;


    /**
     * Creates a button with the given name and font size.
     *
     * @param buttonName text displayed on the button
     * @param buttonFont font size of the button text
     */
    public CalculatorButton(String buttonName, double buttonFont) {
        this.calculatorButton = new Button(buttonName);

        this.calculatorButton.setFont(new Font(buttonFont));
    }

    /**
     * Returns the calculator button.
     */
    public Button getCalculatorButton() {
        return calculatorButton;
    }
}
