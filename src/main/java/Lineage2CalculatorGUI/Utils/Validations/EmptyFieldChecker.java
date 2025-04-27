package Lineage2CalculatorGUI.Utils.Validations;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;

import java.util.List;

public class EmptyFieldChecker {

    /**
     * Validates a ComboBox to ensure it has a selected value.
     *
     * <p>
     *     This method checks whether the provided ComboBox has a non-null selected value.
     *     If the value is null, applies a red border and shows the validation label.
     *     Otherwise, hide the validation state by removing the red border and hiding the validation label.
     * </p>
     *
     * @param comboBox the ComboBox to validate
     * @param validationMessage the Label to display the validation message
     * @return true if the ComboBox has a valid value, false otherwise
     */
    public boolean validateComboBox(ComboBox<String> comboBox, Label validationMessage, List<String> validTowns) {
        String value = comboBox.getValue();

        if (value.isEmpty()) {

            validationHelper(comboBox, validationMessage, "City cannot be empty.");
            return false;
        } else if (!validTowns.contains(value)) {

            validationHelper(comboBox, validationMessage, "Selected city does not exists.");
            return false;
        } else {
            comboBox.setStyle(null);
            validationMessage.setVisible(false);
            return true;
        }
    }

    /**
     * Validates a ToggleGroup to ensure one of RadioButtons is selected.
     *
     * <p>
     *     This method checks whether the provided ToggleGroup has a selected toggle.
     *     If no toggle is selected, shows the validation message.
     *     Otherwise, hides the validation message.
     * </p>
     *
     * @param toggleGroup the ToggleGroup to validate
     * @param validationMessage the Label to display the validation message
     * @return true if a RadioButton in the ToggleGroup is selected, false otherwise
     */
    public boolean validateToggleGroup(ToggleGroup toggleGroup, Label validationMessage) {
        if (toggleGroup.getSelectedToggle() == null) {

            validationMessage.setStyle("-fx-text-fill: red;");
            validationMessage.setVisible(true);
            return false;
        } else {
            validationMessage.setVisible(false);
            return true;
        }
    }

    private void validationHelper(ComboBox<String> comboBox, Label validationMessage, String text) {
        comboBox.setStyle("fx-border-color: red;");

        validationMessage.setText(text);
        validationMessage.setStyle("-fx-text-fill: red;");
        validationMessage.setVisible(true);

    }
}
