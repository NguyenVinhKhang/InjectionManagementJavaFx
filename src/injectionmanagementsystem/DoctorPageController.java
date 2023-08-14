/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package injectionmanagementsystem;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author WINDOWS 10
 */
public class DoctorPageController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private AnchorPane login_form;

    @FXML
    private TextField login_doctorID;

    @FXML
    private PasswordField login_password;

    @FXML
    private TextField login_showPassword;

    @FXML
    private CheckBox login_checkBox;

    @FXML
    private Button login_loginBtn;

    @FXML
    private ComboBox<?> login_user;

    // DATABASE TOOLS
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    private final AlertMessage alert = new AlertMessage();

    @FXML
    void loginAccount() {

        if (login_doctorID.getText().isEmpty()
                || login_password.getText().isEmpty()) {
            alert.errorMessage("Incorrect Doctor ID/Password");
        } else {

            String sql = "SELECT * FROM doctor WHERE doctor_id = ? AND password = ? AND delete_date IS NULL";
            connect = Database.connectDB();

            try {

                if (!login_showPassword.isVisible()) {
                    if (!login_showPassword.getText().equals(login_password.getText())) {
                        login_showPassword.setText(login_password.getText());
                    }
                } else {
                    if (!login_showPassword.getText().equals(login_password.getText())) {
                        login_password.setText(login_showPassword.getText());
                    }
                }

                // CHECK IF THE STATUS OF THE DOCTOR IS CONFIRM 
                String checkStatus = "SELECT status FROM doctor WHERE doctor_id = '"
                        + login_doctorID.getText() + "' AND password = '"
                        + login_password.getText() + "' AND status = 'Confirm'";

                prepare = connect.prepareStatement(checkStatus);
                result = prepare.executeQuery();

                if (result.next()) {

                    alert.errorMessage("Need the confimation of the Admin!");
                } else {
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, login_doctorID.getText());
                    prepare.setString(2, login_password.getText());

                    result = prepare.executeQuery();

                    if (result.next()) {
                        
                        Data.doctor_id = result.getString("doctor_id");
                        Data.doctor_name = result.getString("full_name");
                        
                        alert.successMessage("Login Successfully!");
                        
                        // LINK YOUR DOCTOR MAIN FORM
                        Parent root = FXMLLoader.load(getClass().getResource("DoctorMainForm.fxml"));
                        Stage stage = new Stage();
                        
                        stage.setTitle("Injection Management System | Doctor Main Form");
                        stage.setScene(new Scene(root));
                        stage.show();
                        
                        // TO HIDE YOUR DOCTOR PAGE
                        login_loginBtn.getScene().getWindow().hide();
                        
                    } else {
                        alert.errorMessage("Incorrect Doctor ID/Password");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    @FXML
    void loginShowPassword() {

        if (login_checkBox.isSelected()) {
            login_showPassword.setText(login_password.getText());
            login_password.setVisible(false);
            login_showPassword.setVisible(true);
        } else {
            login_password.setText(login_showPassword.getText());
            login_password.setVisible(true);
            login_showPassword.setVisible(false);
        }

    }



    public void userList() {

        List<String> listU = new ArrayList<>();

        for (String data : Users.user) {
            listU.add(data);
        }

        ObservableList listData = FXCollections.observableList(listU);
        login_user.setItems(listData);
    }

    public void switchPage() {

        if (login_user.getSelectionModel().getSelectedItem() == "Admin Portal") {

            try {

                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();

                stage.setTitle("Injection Management System");

                stage.setMinWidth(340);
                stage.setMinHeight(580);

                stage.setScene(new Scene(root));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (login_user.getSelectionModel().getSelectedItem() == "Doctor Portal") {

            try {

                Parent root = FXMLLoader.load(getClass().getResource("DoctorPage.fxml"));
                Stage stage = new Stage();

                stage.setTitle("Injection Management System");

                stage.setMinWidth(340);
                stage.setMinHeight(580);

                stage.setScene(new Scene(root));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (login_user.getSelectionModel().getSelectedItem() == "Patient Portal") {

            try {

                Parent root = FXMLLoader.load(getClass().getResource("PatientPage.fxml"));
                Stage stage = new Stage();

                stage.setTitle("Injection Management System");

                stage.setMinWidth(340);
                stage.setMinHeight(580);

                stage.setScene(new Scene(root));
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        login_user.getScene().getWindow().hide();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
login_form.setVisible(true);
        userList();
    }

}
