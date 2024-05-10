package Controller;import Bus.ArtistBus;import Bus.PlayListSongsBus;import Bus.SongBus;import DTO.ArtistsEntity;import DTO.PlaylistSongsEntity;import DTO.PlaylistsEntity;import DTO.SongsEntity;import javafx.animation.RotateTransition;import javafx.animation.Timeline;import javafx.application.Platform;import javafx.event.ActionEvent;import javafx.fxml.FXML;import javafx.fxml.FXMLLoader;import javafx.geometry.Insets;import javafx.geometry.Pos;import javafx.scene.Parent;import javafx.scene.Scene;import javafx.scene.control.Button;import javafx.scene.control.Label;import javafx.scene.control.ScrollPane;import javafx.scene.control.Slider;import javafx.scene.image.Image;import javafx.scene.image.ImageView;import javafx.scene.layout.*;import javafx.scene.media.Media;import javafx.scene.media.MediaPlayer;import javafx.scene.shape.Circle;import javafx.stage.Stage;import javafx.util.Duration;import java.io.IOException;import java.util.List;import java.util.concurrent.CompletableFuture;import static Controller.LoginController.LOGGED_USER;public class Dashboard_Controller   {    private static Stage loginStage;    private static Stage logupStage;    private BorderPane homePane;    private Pane favoritePane;    private Pane songsPane;    private Pane albumPane;    List<SongsEntity> songs = new SongBus().getAllSongs();    List<ArtistsEntity> artists = new ArtistBus().getAllArtists();    List<PlaylistSongsEntity> playlists = new PlayListSongsBus().getAllPlaylistSongs();    private GridPane musicTagsPane;    private MediaPlayer mediaPlayer;    private int totalDurationSeconds;    @FXML    private ImageView songIV;    @FXML    private Label artistLB;    @FXML    private BorderPane borderPane;    @FXML    private Slider durationSlider;    @FXML    private Button favoriteBT;    @FXML    private Label finishDur;    @FXML    private Button homeBT;    @FXML    private Button loginBT;    @FXML    private Button playBT;    @FXML    private ImageView playandpauseIV;    @FXML    private Button signupBT;    @FXML    private Label songTitleLB;    @FXML    private Slider soundSlider;    @FXML    private Label startDur;    @FXML    void login(ActionEvent event) {        if (LOGGED_USER != null) {        } else  {            try {                FXMLLoader fxmlLoader = new FXMLLoader(Dashboard_Controller.class.getResource("/GUI/login.fxml"));                Parent root = fxmlLoader.load();                loginStage = new Stage();                loginStage.initModality(javafx.stage.Modality.APPLICATION_MODAL);                loginStage.setTitle("Login");                loginStage.setScene(new Scene(root));                loginStage.setResizable(false);                loginStage.show();            } catch (IOException e) {                e.printStackTrace();            }        }    }    @FXML    void signup(ActionEvent event) {        if (LOGGED_USER != null) {        } else  {            try {                FXMLLoader fxmlLoader = new FXMLLoader(Dashboard_Controller.class.getResource("/GUI/logup.fxml"));                Parent root = fxmlLoader.load();                logupStage = new Stage();                logupStage.initModality(javafx.stage.Modality.APPLICATION_MODAL);                logupStage.setTitle("Sign Up");                logupStage.setScene(new Scene(root));                logupStage.setResizable(false);                logupStage.show();            } catch (IOException e) {                e.printStackTrace();            }        }    }    // Method to close the login window    public static void closeLogin() {        if (loginStage != null) {            loginStage.close();        }    }    // Method to close the logup window    public static void closeLogup() {        if (logupStage != null) {            logupStage.close();        }    }    @FXML    void showHomePane(ActionEvent event) {        CompletableFuture.supplyAsync(() -> {            return getHomePane();        }).thenAcceptAsync(pane -> {            Platform.runLater(() -> {                borderPane.setCenter(pane);            });        });    }    @FXML    void showFavoritePane(ActionEvent event) {        borderPane.setCenter(favoritePane = createFavoritePane());    }    @FXML    void showSongsPane(ActionEvent event) {        songsPane = createSongsPane();        borderPane.setCenter(songsPane);    }    @FXML    void showAlbumPane(ActionEvent event) throws IOException {        borderPane.setCenter(albumPane = createAlbumPane());    }    public BorderPane getHomePane(){        homePane = new BorderPane();        VBox vbox = new VBox();        Label trendingLabel = new Label("Trending Music");        trendingLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;-fx-text-fill:#fff;-fx-font-family:'Times New Roman';");        trendingLabel.setAlignment(Pos.CENTER);        VBox.setMargin(trendingLabel, new Insets(10, 0, 10, 0));        vbox.getChildren().addAll(trendingLabel, createMusicTagScrollPane());        homePane.setCenter(vbox);        return homePane;    }    private ScrollPane createMusicTagScrollPane() {        ScrollPane musicTagScrollPane = new ScrollPane();        musicTagScrollPane.setFitToWidth(true);        musicTagScrollPane.setFitToHeight(true);        musicTagScrollPane.prefWidthProperty().bind(homePane.widthProperty());        musicTagScrollPane.prefHeightProperty().bind(homePane.heightProperty());        musicTagsPane = new GridPane();        musicTagsPane.setHgap(10);        musicTagsPane.setVgap(10);        addMusicTags();        musicTagScrollPane.setContent(musicTagsPane);        musicTagScrollPane.setStyle("-fx-background-color: #181818;-fx-font-style: Times New Roman;");        musicTagsPane.setStyle("-fx-background-color: #181818;");        return musicTagScrollPane;    }    private Pane createFavoritePane() {        Pane pane = new Pane();        Button button = new Button("Favorite Pane");        button.setOnAction(event -> {            System.out.println("Favorite Pane");        });        pane.getChildren().add(button);        pane.setStyle("-fx-background-color: lightgreen;");        pane.setPrefSize(100, 300);        return pane;    }    private Pane createSongsPane() {        Pane pane = new Pane();        Button button = new Button("Songs Pane");        button.setOnAction(event -> {            System.out.println("Songs Pane");        });        pane.getChildren().add(button);        pane.setStyle("-fx-background-color: lightcoral;");        pane.setPrefSize(400, 300);        return pane;    }    private Pane createAlbumPane() throws IOException {        return new Pane();    }    private void addMusicTags() {        // Add music tags to the music tags list        int row = 0;        int col = 0;        for (SongsEntity song : songs) {            for (ArtistsEntity artist : artists) {                if (song.getArtistId() == artist.getArtistId()) {                    Pane musicTag = createMusicTag(song.getTitle(), artist.getName(), song.getSongUrl(), song.getImgUrl());                    musicTagsPane.add(musicTag, col, row);                    if (col == 4) {                        col = 0;                        row++;                    } else {                        col++;                    }                }            }        }    }    private Pane createMusicTag(String title, String artist, String songUrl, String imgUrl) {        StackPane musicTag = new StackPane();        // Create a VBox to hold the ImageView and Label        VBox container = new VBox();        container.setAlignment(Pos.CENTER); // Make the VBox center-aligned        ImageView imageView = new ImageView(new Image(imgUrl));        imageView.setFitWidth(100);        imageView.setFitHeight(100);       // Create a label to display the song title and artist        String s = title + " - " + artist;        Label tagNameLabel = new Label(s);        tagNameLabel.getStyleClass().add("tag-name");        container.getChildren().addAll(imageView, tagNameLabel);        musicTag.getChildren().add(container);        musicTag.setOnMouseClicked(event -> {            playSong(songUrl);            playandpauseIV.setImage(new Image(getClass().getResource("/music/img/pause.png").toString()));            songIV.setImage(new Image(imgUrl));            songTitleLB.setText(title);            artistLB.setText(artist);        });        return musicTag;    }    @FXML    void playSong(String songUrl) {        System.out.println("Playing song: " + songUrl);        Media media = new Media(songUrl);        songIV.setClip(new Circle(songIV.getFitWidth() / 2, songIV.getFitHeight() / 2, songIV.getFitWidth() / 2));        try {            if (mediaPlayer != null) {                mediaPlayer.stop(); // Dừng media player hiện tại trước khi phát media mới                mediaPlayer.dispose(); // Giải phóng các tài nguyên của media player            }            mediaPlayer = new MediaPlayer(media);            mediaPlayer.setVolume(soundSlider.getValue() / 100);            mediaPlayer.setOnPlaying(() -> {                updateDurationLabel(); // Cập nhật nhãn thời gian chờ                updateTimeSlider(); // Cập nhật thanh trượt thời gian                updateCurrentTimeLabel(); // Cập nhật nhãn thời gian hiện tại                totalDurationSeconds = (int) mediaPlayer.getTotalDuration().toSeconds();                rotateImage();            });            // Cập nhật thời gian hiện tại liên tục            mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> {                updateCurrentTimeLabel();                updateTimeSlider();            });            soundSlider.valueProperty().addListener((observable, oldValue, newValue) -> {                if (mediaPlayer != null) {                    mediaPlayer.setVolume(newValue.doubleValue() / 100.0);                }            });            // Update the media player's time when the slider is moved            durationSlider.valueProperty().addListener((observable, oldValue, newValue) -> {                if (durationSlider.isValueChanging()) {                    mediaPlayer.seek(Duration.seconds(newValue.doubleValue()));                }            });            mediaPlayer.play(); // Bắt đầu phát media mới        } catch (Exception e) {            e.printStackTrace();        }    }    private void updateTimeSlider() {        // Đặt giá trị tối đa của thanh trượt thành thời lượng của media        durationSlider.setMax(mediaPlayer.getTotalDuration().toSeconds());        // Đặt giá trị của thanh trượt thành thời gian hiện tại của media        durationSlider.setValue(mediaPlayer.getCurrentTime().toSeconds());    }    private void updateDurationLabel() {        // Lấy thời lượng của media        int durationSeconds = (int) mediaPlayer.getTotalDuration().toSeconds();        // Chuyển đổi sang định dạng mm:ss        int minutes = durationSeconds / 60;        int seconds = durationSeconds % 60;        // Hiển thị thời lượng trên nhãn        finishDur.setText(String.format("%02d:%02d", minutes, seconds));    }    private void updateCurrentTimeLabel() {        // Lấy thời gian hiện tại của media        int currentTimeSeconds = (int) mediaPlayer.getCurrentTime().toSeconds();        // Chuyển đổi sang định dạng mm:ss        int minutes = currentTimeSeconds / 60;        int seconds = currentTimeSeconds % 60;        // Hiển thị thời gian hiện tại trên nhãn        startDur.setText(String.format("%02d:%02d", minutes, seconds));    }    @FXML    void pause() {        if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {            playandpauseIV.setImage(new Image(getClass().getResource("/music/img/ic_play (1).png").toString()));            mediaPlayer.pause();            playBT.setOnAction(event -> resume());        }    }    void resume() {        if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED) {            playandpauseIV.setImage(new Image(getClass().getResource("/music/img/pause.png").toString()));            mediaPlayer.play();            playBT.setOnAction(event -> pause());        }    }    private void rotateImage() {        RotateTransition rotateTransition = new RotateTransition( Duration.seconds(totalDurationSeconds), songIV);        rotateTransition.setByAngle(360);        rotateTransition.setCycleCount(Timeline.INDEFINITE);        rotateTransition.setDuration(Duration.seconds(10));        rotateTransition.play();    }}