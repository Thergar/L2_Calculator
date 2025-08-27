package l2calculator.scenes.calculatorscene.components;

import l2calculator.api.TownApi;
import l2calculator.scenes.utils.validations.FieldValidation;
import javafx.beans.property.BooleanProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.util.List;


/**
 * Represents a UI component that allows users to select or enter a town name.
 *
 * <p>
 * The component consists of a label, a text field with auto-completion, and a validation message.
 * Town names are fetched from the backend via {@link TownApi}, and suggestions are provided as the user types.
 * Validation ensures the entered town is part of the available list.
 * </p>
 */
public class CitySelector {

    private final VBox container;
    private final TextField cityFieldText;

    private final BooleanProperty valid;

    private final Label validationMessage;

    /**
     * Constructs a city selector with a given label and fills the combo box with town names.
     *
     * @param label the text to display above the combo box
     */
    public CitySelector(String label) {

        List<String> validTowns = TownApi.fetchTowns();

        Label cityLabel = new Label(label);
        cityLabel.setFont(new Font(15));

        this.validationMessage = new Label();
        this.validationMessage.setVisible(false);

        this.cityFieldText = new TextField();
        this.cityFieldText.setMaxWidth(150);
        this.cityFieldText.setPromptText("Select town");

        AutoCompletionBinding<String> autoSuggestionBinding = TextFields.bindAutoCompletion(cityFieldText, validTowns);
        autoSuggestionBinding.setVisibleRowCount(5);

        this.valid = FieldValidation.cityValidation(cityFieldText, validationMessage, validTowns);

        this.container = new VBox(10, cityLabel, cityFieldText, validationMessage);
    }

    /**
     * Returns the text field used for entering or selecting a town name.
     *
     */
    public TextField getTextField() {
        return cityFieldText;
    }

    /**
     * Returns the container holding the label and combo box.
     *
     */
    public VBox getContainer() {
        return container;
    }

    /**
     * Indicates whether the currently selected town is valid.
     *
     */
    public BooleanProperty isValid() {return valid;
    }

    /**
     * Returns the label used to display validation error messages.
     *
     */
    public Label getValidationMessage() {
        return validationMessage;}
}
