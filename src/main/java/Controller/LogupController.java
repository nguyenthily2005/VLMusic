package Controller;

import Bus.UserBus;
import DTO.UsersEntity;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static Utilz.Utilz.*;

public class LogupController {
    private UserBus userBus;
    @FXML
    private TextField usernameTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private TextField emailTF;

    @FXML
    protected void logup() {
        userBus = new UserBus();
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        String email = emailTF.getText();

        String passwordHash = hashPassword(password);

        UsersEntity user = new UsersEntity();
        user.setEmail(email);
        user.setUsername(username);
        user.setPasswordHash(passwordHash);

        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            showErrorAlert("Logup Failed", "Please fill in all fields.");
            return;
        }

        if (username.length() < 6 || password.length() < 6) {
            showErrorAlert("Logup Failed", "Username and password must be at least 6 characters long.");
            return;
        }

        if (!email.contains("@gmail.com")) {
            showErrorAlert("Logup Failed", "Invalid email address.");
            return;
        }

        if (userBus.userExists(username) || userBus.userExists(email)) {
            showErrorAlert("Registration Failed", "Username or email already exists.");
            return;
        }

        if (username.length() >= 6 && password.length() >= 6 && email.contains("@gmail.com")) {
            new UserBus().logup(user);
            showAlert("Logup Successful", "Please check log in to enjoy the app.");
            Dashboard_Controller.closeLogup();

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/login.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("Login");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    protected void changeToLogin() {
        Dashboard_Controller.closeLogup();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}