package Lineage2CalculatorGUI.Utils;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;

import java.util.List;

/**
 * The class provides autocomplete functionality
 * for a ComboBox based on a list of valid towns.
 */
public class CitySuggestion {

    /**
     * Attaches autocomplete functionality to a given ComboBox.
     */
    public void autosuggestion(ComboBox comboBox, List<String> validTowns) {
        comboBox.setEditable(true);
        comboBox.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
         List<String> filteredTowns = validTowns.stream()
                 .filter(town -> town.toLowerCase()
                         .contains(newValue.toLowerCase()))
                 .toList();

         comboBox.setItems(FXCollections.observableArrayList(filteredTowns));
         comboBox.show();
        });
    }
}
