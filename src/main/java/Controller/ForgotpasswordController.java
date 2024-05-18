package Controller;

import Bus.UserBus;
import DTO.UsersEntity;
import Utilz.Utilz;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

import static Utilz.Utilz.*;

public class ForgotpasswordController {

    private static Stage checkOTPStage;

    public static int OTP;

    public static UsersEntity FORGOTTEN_USER;

    @FXML
    private TextField emailoruserTF;

    @FXML
    private Button sendBT;

    @FXML
    void sendOTP(ActionEvent event) {
        String emailoruserTFText = emailoruserTF.getText();

        if (emailoruserTFText.isEmpty() || !emailoruserTFText.contains("@gmail.com")) {
            showErrorAlert("Error", "Please enter your email or username");
        } else {
            // Search for the email or username in the database
            // If found, send an email with the OTP
            UsersEntity users = new UserBus().getUserByUsernameOrEmail(emailoruserTFText);
            if (users != null) {

                FORGOTTEN_USER = users;

                Random random = new Random();
                OTP = random.nextInt(99999) + 10000;

                Utilz.sendEmail(users.getEmail(), EMAIL, "Password Reset OTP", "Your OTP is: " + OTP);


                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/checkOTP.fxml"));
                    Parent root = fxmlLoader.load();

                    // Get the controller and disable the button
                    CheckOTPController controller = fxmlLoader.getController();
                    controller.disableChangePasswordButton();

                    checkOTPStage = new Stage();
                    checkOTPStage.initModality(Modality.APPLICATION_MODAL);
                    checkOTPStage.setTitle("Check OTP");
                    checkOTPStage.setScene(new Scene(root));
                    checkOTPStage.setResizable(false);
                    checkOTPStage.getIcons().add(new Image(getClass().getResource("/music/img/logoVL.png").toString()));
                    checkOTPStage.show();

                    LoginController.closeForgotPassword();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                showErrorAlert("Error", "User not found");
            }

        }
    }

    public static void closeCheckOTPStage() {
        if (checkOTPStage != null) {
            checkOTPStage.close();
        }
    }


}
