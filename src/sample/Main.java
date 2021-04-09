package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Quick Chemistry | My Chemistry Homework Helper");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}
