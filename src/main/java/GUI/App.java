package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.persistence.criteria.Root;
import java.io.IOException;
import java.util.Stack;

public class App extends Application {
    public static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("dash-board.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);
        stage.setTitle("VibeLab");
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResource("/music/img/logoVL.png").toString()));
        stage.show();
        this.stage = stage;
    }

    public static void main(String[] args) {
        launch();
    }
}