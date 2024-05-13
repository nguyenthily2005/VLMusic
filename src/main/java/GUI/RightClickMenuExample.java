package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RightClickMenuExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a pane
        Pane pane = new Pane();
        pane.setPrefSize(300, 200);

        // Create a context menu
        ContextMenu contextMenu = new ContextMenu();

        // Create menu items
        MenuItem menuItem1 = new MenuItem("Function 1");
        MenuItem menuItem2 = new MenuItem("Function 2");

        // Add menu items to context menu
        contextMenu.getItems().addAll(menuItem1, menuItem2);

        // Set action for each menu item
        menuItem1.setOnAction(event -> {
            System.out.println("Function 1 selected");
            // Add your functionality here
        });

        menuItem2.setOnAction(event -> {
            System.out.println("Function 2 selected");
            // Add your functionality here
        });

        // Set context menu to the pane
        pane.setOnContextMenuRequested(event -> contextMenu.show(pane, event.getScreenX(), event.getScreenY()));

        // Create scene and set it to the stage
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Right Click Menu Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
