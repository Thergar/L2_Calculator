package Lineage2CalculatorGUI;
import Lineage2CalculatorGUI.Scenes.CalculatorScene.CalculatorScene;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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
        primaryStage.getIcons().add(new Image(getClass().getResource("/images/lineage2.png").toExternalForm()));
        primaryStage.setScene(calculatorScene.getCalculatorScene());

        primaryStage.show();
    }
}
