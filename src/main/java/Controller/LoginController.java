package Controller;

import Bus.UserBus;
import DTO.UsersEntity;
import GUI.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static Controller.Dashboard_Controller.*;
import static Utilz.Utilz.*;

public class LoginController {

    public static UsersEntity LOGGED_USER = null;

    private static Stage forgotpasswordStage;

    @FXML
    private CheckBox checkbox;

    @FXML
    private Button loginnBT;

    @FXML
    private PasswordField passwordTF;

    @FXML
    private TextField usernameTF;

    @FXML
    void login(ActionEvent event) {
        String emailoruserTFText = usernameTF.getText();
        String password = passwordTF.getText();
        List<UsersEntity> users = new UserBus().usersEntityList();

        if (emailoruserTFText.isEmpty() || password.isEmpty()) {
            showErrorAlert("Login Failed", "Please fill in all fields.");
            return;
        }

        boolean userExists = false;

        for (UsersEntity user : users) {
            if (user.getEmail().equals(emailoruserTFText) || user.getUsername().equals(emailoruserTFText)) {
                if (user.getPasswordHash().equals(hashPassword(password))) {
                    LOGGED_USER = user;
                    userExists = true;
                    break;
                }
            }
        }
        if (userExists) {
            showAlert("Login Successful", "Welcome to the dashboard.");
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("dash-board.fxml"));
                Parent root = fxmlLoader.load();
                App.stage.setScene(new Scene(root));
                App.stage.setWidth(1200);
                App.stage.setHeight(800);
                App.stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            closeLogin();
        } else {
            showErrorAlert("Login Failed", "Invalid username/email or password.");
        }
    }


    @FXML
    void forgotpassword(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Dashboard_Controller.class.getResource("/GUI/forgotpassword.fxml"));
            Parent root = fxmlLoader.load();
            forgotpasswordStage = new Stage();
            forgotpasswordStage.initModality(javafx.stage.Modality.APPLICATION_MODAL);
            forgotpasswordStage.setTitle("Forgot Password");
            forgotpasswordStage.setScene(new Scene(root));
            forgotpasswordStage.show();

            closeLogin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {

        checkbox.setOnAction(event -> {

            if (checkbox.isSelected()) {
                passwordTF.setPromptText(passwordTF.getText());
                passwordTF.setText("");
                passwordTF.setDisable(true);
            } else {
                passwordTF.setText(passwordTF.getPromptText());
                passwordTF.setPromptText("Password");
                passwordTF.setDisable(false);
            }
        });
    }

    public static void closeForgotPassword() {
        if (forgotpasswordStage != null) {
            forgotpasswordStage.close();
        }
    }


}