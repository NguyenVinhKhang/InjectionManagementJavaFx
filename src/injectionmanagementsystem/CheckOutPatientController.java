package injectionmanagementsystem;

import injectionmanagementsystem.Data;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author WINDOWS 10
 */
public class CheckOutPatientController implements Initializable {

     @FXML
    private Label checkout_VaccineBrand;

    @FXML
    private Label checkout_VaccineId;

    @FXML
    private Label checkout_VaccineName;

    @FXML
    private Label checkout_VaccineType;
    
    @FXML
    private Label checkout_appID;

    @FXML
    private Button checkout_countBtn;

    @FXML
    private DatePicker checkout_date;

    @FXML
    private Label checkout_doctor;

    @FXML
    private Label checkout_name;

    @FXML
    private Label checkout_patientID;

    @FXML
    private Button checkout_payBtn;

    @FXML
    private TextField checkout_quantity;

    @FXML
    private Label checkout_totalPrice;


    private AlertMessage alert = new AlertMessage();

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    public void countBtn() {
        alert.successMessage("Count!");
    }

    public void payBtn() {
        alert.successMessage("Pay!");
    }

    public ObservableList<AppointmentData> getData() {
        checkout_appID.setText(Data.temp_appID);

        ObservableList<AppointmentData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM appointment WHERE appointment_id = '" + Data.temp_appID + "'";

        connect = Database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            AppointmentData appData;

            while (result.next()) {
                appData = new AppointmentData(result.getInt("id"), result.getInt("appointment_id"), result.getInt("patient_id"),
                        result.getString("name"), result.getString("gender"),
                        result.getString("description"), result.getInt("vaccine_id"),
                        result.getString("brand"), result.getString("productName"), result.getString("type"),
                        result.getString("doctor"), result.getString("specialized"),
                        result.getDate("date"), result.getDate("date_modify"),
                        result.getDate("date_delete"), result.getString("status"),
                        result.getDate("schedule"));
                // STORE ALL DATA
                listData.add(appData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public ObservableList<AppointmentData> appoinmentListData;

    public void displayFields() {
        appoinmentListData = getData();
        AppointmentData selectedAppointment = appoinmentListData.get(0); // Lấy bản ghi đầu tiên từ danh sách

        String sql = "SELECT full_name FROM doctor WHERE delete_date IS NULL AND doctor_id = '"
                + selectedAppointment.getDoctorID() + "'";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()) {
                    checkout_doctor.setText(result.getString("full_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        checkout_name.setText(selectedAppointment.getName());
        checkout_patientID.setText(String.valueOf(selectedAppointment.getPatientID()));
        checkout_VaccineName.setText(selectedAppointment.getProductName());
        checkout_VaccineBrand.setText(selectedAppointment.getBrand());
        checkout_VaccineId.setText(selectedAppointment.getVaccine_id().toString());
        checkout_VaccineType.setText(selectedAppointment.getType());
        Date scheduleDate = selectedAppointment.getSchedule();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(scheduleDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Tháng trong Calendar bắt đầu từ 0, nên cần +1
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        checkout_date.setValue(LocalDate.of(year, month, day));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayFields();
    }

}
