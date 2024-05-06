package GUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");

        // Đặt sự kiện cho nút 1
        button1.setOnAction(event -> {
            button1.setVisible(false); // Ẩn nút 1
            button2.setVisible(true); // Hiện nút 2
        });

        // Đặt sự kiện cho nút 2
        button2.setOnAction(event -> {
            button2.setVisible(false); // Ẩn nút 2
            button1.setVisible(true); // Hiện nút 1
        });

        // Ban đầu chỉ hiển thị nút 1
        button2.setVisible(false);

        StackPane root = new StackPane();
        root.getChildren().addAll(button1, button2);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Toggle Buttons");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
