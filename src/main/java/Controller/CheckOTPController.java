package Controller;

import Bus.UserBus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static Controller.ForgotpasswordController.FORGOTTEN_USER;
import static Utilz.Utilz.hashPassword;
import static Utilz.Utilz.showErrorAlert;

public class CheckOTPController {

    @FXML
    private Button changepassBT;

    @FXML
    private TextField newpassTF;

    @FXML
    private TextField otpTF;

    @FXML
    private Button verifyBT;

    @FXML
    void changePassword(ActionEvent event) {
        String newpassTFText = newpassTF.getText();

        if (newpassTFText.isEmpty()) {
            showErrorAlert("Error", "Please enter the new password");
        } else {

            String hashedPassword = hashPassword(newpassTFText);
            FORGOTTEN_USER.setPasswordHash(hashedPassword);

            // Update the password in the database
            new UserBus().changePassword(FORGOTTEN_USER);

            ForgotpasswordController.closeCheckOTPStage();

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/login.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Login");
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }

    @FXML
    void checkOTP(ActionEvent event) {
        String otpTFText = otpTF.getText();

        if (otpTFText.isEmpty()) {
            showErrorAlert("Error", "Please enter the OTP");
        } else if (Integer.parseInt(otpTFText) == ForgotpasswordController.OTP) {
            changepassBT.setDisable(false);
            newpassTF.setDisable(false);
        } else {
            showErrorAlert("Error", "Invalid OTP");
        }
    }

    public void disableChangePasswordButton() {
        newpassTF.setDisable(true);
        changepassBT.setDisable(true);
    }

}
