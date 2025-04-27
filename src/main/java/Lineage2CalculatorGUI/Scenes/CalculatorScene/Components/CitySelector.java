package Lineage2CalculatorGUI.Scenes.CalculatorScene.Components;

import Lineage2CalculatorGUI.API.TownApi;
import Lineage2CalculatorGUI.Utils.Validations.EmptyFieldChecker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.List;

/**
 * The {@code CitySelector} class provides a UI component for selecting a town from a dropdown list.
 *
 * <p>
 * It displays a label and a combo box filled with town names fetched from {@link TownApi}.
 * </p>
 */
public class CitySelector {

    private final VBox container;
    private final ComboBox<String> cityComboBox;

    private final EmptyFieldChecker emptyFieldChecker;
    /**
     * Constructs a city selector with a given label and fills the combo box with town names.
     *
     * @param label the text to display above the combo box
     */
    public CitySelector(String label) {

        List<String> validTowns = TownApi.fetchTowns();

        Label cityLabel = new Label(label);
        cityLabel.setFont(new Font(15));

        Label validationMessage = new Label();
        validationMessage.setVisible(false);

        this.emptyFieldChecker = new EmptyFieldChecker();

        this.cityComboBox = new ComboBox<>();
        this.cityComboBox.setPrefWidth(150);
        this.cityComboBox.setPromptText("Select town");
        this.cityComboBox.getItems().addAll(validTowns);
        this.cityComboBox.setEditable(true);

        this.cityComboBox.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                emptyFieldChecker.validateComboBox(cityComboBox, validationMessage, validTowns);
            }
        });

        this.container = new VBox(10, cityLabel, cityComboBox, validationMessage);
    }

    /**
     * Returns the combo box used for town selection.
     */
    public ComboBox<String> getCityComboBox() {
        return cityComboBox;
    }

    /**
     * Returns the container holding the label and combo box.
     *
     */
    public VBox getContainer() {
        return container;
    }
}
