package l2calculator;

import l2calculator.scenes.calculatorscene.CalculatorScene;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class MainFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setMinWidth(900);
        primaryStage.setMinHeight(700);
        primaryStage.setMaxWidth(1000);
        primaryStage.setMaxHeight(800);

        CalculatorScene calculatorScene = new CalculatorScene(primaryStage);

        primaryStage.setTitle("L2 Calculator");
        primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/Lineage2.png"))));
        primaryStage.setScene(calculatorScene.getCalculatorScene());

        primaryStage.show();
    }
}
