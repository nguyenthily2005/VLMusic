module music.spotify {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens music.spotify to javafx.fxml;
    exports music.spotify;
}