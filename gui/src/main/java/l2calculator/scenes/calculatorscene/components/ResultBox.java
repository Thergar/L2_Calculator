package l2calculator.scenes.calculatorscene.components;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

/**
 * The {@code ResultBox} class provides a non-editable {@link TextArea}
 * for displaying the calculated teleport result.
 *
 * <p>
 * The text area is centered in a {@code GridPane} layout and is customized.
 * </p>
 */
public class ResultBox {

    private final TextArea resultText;

    /**
     * Constructs a customized result area.
     * The text area is read-only and supports text wrapping.
     */
    public ResultBox() {
        this.resultText = new TextArea();

        this.resultText.setEditable(false);
        this.resultText.setWrapText(true);

        GridPane.setColumnSpan(this.resultText, 2);
        GridPane.setRowIndex(this.resultText, 2);
        GridPane.setHalignment(this.resultText, HPos.CENTER);
        GridPane.setValignment(this.resultText, VPos.CENTER);
        GridPane.setMargin(this.resultText, new Insets(50, 100, 30, 100));
    }

    /**
     * Returns the text area used for displaying the result.
     */
    public TextArea getResultText() {
        return resultText;
    }
}
