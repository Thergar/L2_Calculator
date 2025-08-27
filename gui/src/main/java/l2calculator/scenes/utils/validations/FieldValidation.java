package l2calculator.scenes.utils.validations;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.*;

import java.util.List;

/**
 * Utility class that provides input validation for JavaFX form components.
 *
 * <p>
 * Supports validation for town selection fields and algorithm selection radio buttons,
 * providing real-time feedback and visual error indicators.
 * </p>
 */
public class FieldValidation {

    /**
     * Attaches validation to a text field for town selection.
     *
     * <p>
     * When the field loses focus, the entered town name is validated
     * against the provided list of allowed town names. If invalid,
     * a red error message is displayed.
     * </p>
     *
     * @param textField the input field to validate
     * @param validationMessage the label to display the error message
     * @param validTowns the list of valid town names
     * @return a {@code BooleanProperty} reflecting whether the input is valid
     */
    public static BooleanProperty cityValidation(TextField textField, Label validationMessage, List<String> validTowns) {
        BooleanProperty valid = new SimpleBooleanProperty();

        textField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                valid.set(validateTextField(textField, validationMessage, validTowns));
            }
        });

        return valid;
    }

    /**
     * Attaches validation to a toggle group representing algorithm options.
     *
     * <p>
     * When the selection changes, the validator checks whether an algorithm
     * has been chosen. If not, an error message is shown.
     * </p>
     *
     * @param toggleGroup the toggle group to validate
     * @param validationMessage the label to display the error message
     * @return a {@code BooleanProperty} reflecting whether a selection is made
     */
    public static BooleanProperty algorithmValidation(ToggleGroup toggleGroup, Label validationMessage) {
        BooleanProperty valid = new SimpleBooleanProperty();

        toggleGroup.selectedToggleProperty().addListener((observable, oldToggle, newToggle) -> {
            valid.set(validateToggleGroup(toggleGroup, validationMessage));
        });

        return valid;
    }

    /**
     * Validates the input value of a town selection field.
     *
     * @param textField the input field to validate
     * @param validationMessage the label used to show validation feedback
     * @param validTowns the list of valid town names
     * @return {@code true} if the input is valid; {@code false} otherwise
     */
    private static boolean validateTextField(TextField textField, Label validationMessage, List<String> validTowns) {
        String value = textField.getText();

        if (value.isEmpty()) {
            validationMessageHelper(validationMessage, "City cannot be empty!");
            return false;

        } else if (!validTowns.contains(value)) {
            validationMessageHelper(validationMessage, "Selected city does not exists!");
            return false;

        } else {
            textField.setStyle(null);
            validationMessage.setVisible(false);
            return true;

        }
    }

    /**
     * Validates whether a toggle group has a selected option.
     *
     * @param toggleGroup the toggle group to check
     * @param validationMessage the label used to show validation feedback
     * @return {@code true} if an option is selected; {@code false} otherwise
     */
    private static boolean validateToggleGroup(ToggleGroup toggleGroup, Label validationMessage) {
        Toggle selectedToggle = toggleGroup.getSelectedToggle();

        if (selectedToggle == null) {
            validationMessageHelper(validationMessage, "Algorithm must be selected!");
            return false;
        } else {
            validationMessage.setVisible(false);
            return true;
        }
    }

    /**
     * Displays a validation error message in red.
     *
     * @param validationMessage the label used to show the message
     * @param text the error message to display
     */
    private static void validationMessageHelper(Label validationMessage, String text) {
        validationMessage.setText(text);
        validationMessage.setStyle("-fx-text-fill: red;");
        validationMessage.setVisible(true);

    }
}
