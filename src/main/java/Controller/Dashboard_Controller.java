package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static Controller.LoginController.LOGGED_USER;

public class Dashboard_Controller {

    private static Stage loginStage;
    private static Stage logupStage;

    @FXML
    private Button logBT;

    @FXML
    private Button signupBT;

    @FXML
    void login(ActionEvent event) {

        if (LOGGED_USER != null) {


        } else  {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Dashboard_Controller.class.getResource("/GUI/login.fxml"));
                Parent root = fxmlLoader.load();
                loginStage = new Stage();
                loginStage.initModality(javafx.stage.Modality.APPLICATION_MODAL);
                loginStage.setTitle("Login");
                loginStage.setScene(new Scene(root));
                loginStage.setResizable(false);
                loginStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void signup(ActionEvent event) {

        if (LOGGED_USER != null) {


        } else  {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Dashboard_Controller.class.getResource("/GUI/logup.fxml"));
                Parent root = fxmlLoader.load();
                logupStage = new Stage();
                logupStage.initModality(javafx.stage.Modality.APPLICATION_MODAL);
                logupStage.setTitle("Sign Up");
                logupStage.setScene(new Scene(root));
                logupStage.setResizable(false);
                logupStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to close the login window
    public static void closeLogin() {
        if (loginStage != null) {
            loginStage.close();
        }
    }


    // Method to close the logup window
    public static void closeLogup() {
        if (logupStage != null) {
            logupStage.close();
        }
    }

}
