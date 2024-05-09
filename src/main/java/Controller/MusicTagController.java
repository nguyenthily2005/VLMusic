package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MusicTagController implements Initializable {

    @FXML
    private GridPane musicTagPane; // GridPane để chứa các thẻ nhạc

    // Dữ liệu thẻ nhạc (có thể thay đổi thành dữ liệu thực từ cơ sở dữ liệu hoặc nguồn dữ liệu khác)
    private String[] musicTags = {"Pop", "Rock", "Jazz", "Classical", "Hip Hop", "Electronic"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Thêm các thẻ nhạc vào musicTagPane
        addMusicTags();
    }

    private void addMusicTags() {
        int row = 0;
        int col = 0;

        // Lặp qua mỗi thẻ nhạc trong mảng dữ liệu và thêm vào musicTagPane
        for (String tag : musicTags) {
            Pane musicTag = createMusicTag(tag);
            musicTagPane.add(musicTag, col, row);
            col++;

            // Nếu cột đạt đến giới hạn, chuyển sang hàng mới
            if (col == 3) {
                col = 0;
                row++;
            }
        }
    }

    private Pane createMusicTag(String tag) {
        Pane musicTag = new Pane();
        musicTag.getStyleClass().add("music-tag"); // Thêm CSS class cho pane

        Label tagNameLabel = new Label(tag);
        tagNameLabel.getStyleClass().add("tag-name"); // Thêm CSS class cho label
        musicTag.getChildren().add(tagNameLabel);

        // Thêm các xử lí sự kiện khi nhấp vào thẻ nhạc

        return musicTag;
    }
}
