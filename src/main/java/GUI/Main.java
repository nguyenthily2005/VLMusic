package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MusicTag.fxml"));
        Parent root = loader.load();

        // Create a new scene with the loaded root node
        Scene scene = new Scene(root, 600, 400);

        // Set the scene on the stage
        primaryStage.setScene(scene);

        primaryStage.setTitle("Music Tags");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}