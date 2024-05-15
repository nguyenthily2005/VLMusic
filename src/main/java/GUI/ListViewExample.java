package GUI;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        ListView<String> listView = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList(
                "Item 1", "Item 2", "Item 3"
        );
        listView.setItems(items);

        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                int index = listView.getSelectionModel().getSelectedIndex();

                // Kiểm tra xem các subitem đã tồn tại hay chưa
                if (index + 1 < listView.getItems().size() && listView.getItems().get(index + 1).startsWith("SubItem")) {
                    return;
                }

                // Xóa các item con hiện tại nếu có
                while (index + 1 < listView.getItems().size() && listView.getItems().get(index + 1).startsWith("SubItem")) {
                    listView.getItems().remove(index + 1);
                }

                // Thêm các subitem mới
                listView.getItems().add(index + 1, "SubItem 1 of " + newValue);
                listView.getItems().add(index + 2, "SubItem 2 of " + newValue);
                listView.getItems().add(index + 3, "SubItem 3 of " + newValue);
            }
        });

        VBox vBox = new VBox(listView);
        Scene scene = new Scene(vBox, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX ListView Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
