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
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author WINDOWS 10
 */
public class EditAppointmentFormController implements Initializable {

    @FXML
    private TextField editApp_appointmentID;

    @FXML
    private Button editApp_cancelBtn;

    @FXML
    private TextArea editApp_description;

    @FXML
    private ComboBox<String> editApp_doctor;

    @FXML
    private ComboBox<String> editApp_name;

    @FXML
    private TextField editApp_patientId;

    @FXML
    private ComboBox<String> editApp_productName;

    @FXML
    private DatePicker editApp_schedule;

    @FXML
    private TextField editApp_specialized;

    @FXML
    private ComboBox<String> editApp_status;

    @FXML
    private Button editApp_updateBtn;

    @FXML
    private ComboBox<String> editApp_vaccineBrand;

    @FXML
    private ComboBox<Integer> editApp_vaccineID;

    @FXML
    private ComboBox<String> editApp_vaccineType;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    private AlertMessage alert = new AlertMessage();

    public ObservableList<AppointmentData> getData() {
        editApp_appointmentID.setText(Data.temp_appID);
        editApp_appointmentID.setDisable(true);

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
                editApp_doctor.getSelectionModel().select(result.getString("full_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        editApp_description.setText(selectedAppointment.getDescription());
        editApp_name.getSelectionModel().select(selectedAppointment.getName());
        editApp_patientId.setText(String.valueOf(selectedAppointment.getPatientID()));
        editApp_patientId.setDisable(true);
        editApp_productName.getSelectionModel().select(selectedAppointment.getProductName());
        editApp_specialized.setText(selectedAppointment.getSpecialized());
        editApp_specialized.setDisable(true);
        editApp_status.getSelectionModel().select(selectedAppointment.getStatus());
        editApp_vaccineBrand.getSelectionModel().select(selectedAppointment.getBrand());
        editApp_vaccineID.getSelectionModel().select(selectedAppointment.getVaccine_id());
        editApp_vaccineType.getSelectionModel().select(selectedAppointment.getType());
        Date scheduleDate = selectedAppointment.getSchedule();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(scheduleDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Tháng trong Calendar bắt đầu từ 0, nên cần +1
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        editApp_schedule.setValue(LocalDate.of(year, month, day));
    }

    public void appointmentType() {

        String sql = "SELECT type FROM vaccine WHERE status = 'Available'";

        connect = Database.connectDB();

        try {
            ObservableList listData = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                listData.add(result.getString("type"));
            }
            editApp_vaccineType.setItems(listData);

            appointmentVaccineId();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void appointmentVaccineId() {

        String sql = "SELECT * FROM vaccine WHERE type = '"
                + editApp_vaccineType.getSelectionModel().getSelectedItem() + "'";

        connect = Database.connectDB();

        try {
            ObservableList listData = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                listData.add(result.getInt("vaccine_id"));
            }
            editApp_vaccineID.setItems(listData);

            appointmentBrand();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void appointmentBrand() {

        String sql = "SELECT * FROM vaccine WHERE vaccine_id = '"
                + editApp_vaccineID.getSelectionModel().getSelectedItem() + "'";

        connect = Database.connectDB();

        try {
            ObservableList listData = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                listData.add(result.getString("brand"));
            }
            editApp_vaccineBrand.setItems(listData);

            appointmentProductName();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void appointmentProductName() {

        String sql = "SELECT * FROM vaccine WHERE brand = '"
                + editApp_vaccineBrand.getSelectionModel().getSelectedItem() + "'";

        connect = Database.connectDB();

        try {
            ObservableList listData = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                listData.add(result.getString("productName"));
            }
            editApp_productName.setItems(listData);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void doctorList() {
        String sql = "SELECT full_name FROM doctor WHERE delete_date IS NULL";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            ObservableList listData = FXCollections.observableArrayList();
            while (result.next()) {
                listData.add(result.getString("full_name"));
            }

            editApp_doctor.setItems(listData);
            editApp_doctor.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                setSpecialized();
                patientList();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSpecialized() {
        String sql = "SELECT specialized FROM doctor WHERE delete_date IS NULL AND full_name = '"
                + editApp_doctor.getSelectionModel().getSelectedItem() + "' AND status = 'Active'";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                editApp_specialized.setText(result.getString("specialized"));
                editApp_specialized.setDisable(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void patientList() {
        connect = Database.connectDB();

        String sql1 = "SELECT doctor_id FROM doctor WHERE full_name = '"
                + editApp_doctor.getSelectionModel().getSelectedItem() + "'";
        String drID = "";
        try {
            prepare = connect.prepareStatement(sql1);
            result = prepare.executeQuery();
            while (result.next()) {
                drID = result.getString("doctor_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = "SELECT full_name FROM patient WHERE doctor = '"
                + drID + "'";

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            ObservableList listData = FXCollections.observableArrayList();
            while (result.next()) {
                listData.add(result.getString("full_name"));
            }

            editApp_name.setItems(listData);
            editApp_name.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                setPatientId();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPatientId() {
        String sql = "SELECT patient_id FROM patient WHERE full_name='" + editApp_name.getSelectionModel().getSelectedItem() + "'";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            if (result.next()) {
                int patientId = result.getInt("patient_id");
                editApp_patientId.setText(String.valueOf(patientId));
                editApp_patientId.setDisable(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void statusList() {
        List<String> statusL = new ArrayList<>();

        for (String data : Data.status) {
            statusL.add(data);
        }

        ObservableList listData = FXCollections.observableList(statusL);
        editApp_status.setItems(listData);
    }

    public void cancelBtn() {
        getData();
        Stage stage = (Stage) editApp_cancelBtn.getScene().getWindow();
        stage.close();
    }

    public void UpdateBtn() {

        if (editApp_appointmentID.getText().isEmpty()
                || editApp_name.getSelectionModel().getSelectedItem() == null
                || editApp_patientId.getText().isEmpty()
                || editApp_description.getText().isEmpty()
                || editApp_status.getSelectionModel().getSelectedItem() == null
                || editApp_vaccineBrand.getSelectionModel().getSelectedItem() == null
                || editApp_vaccineID.getSelectionModel().getSelectedItem() == null
                || editApp_productName.getSelectionModel().getSelectedItem() == null
                || editApp_vaccineType.getSelectionModel().getSelectedItem() == null
                || editApp_schedule.getValue() == null) {
            alert.errorMessage("Please fill the blank fields");
        } else {
            // TO GET THE DATE TODAY
            java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());

            String updateData = "UPDATE appointment SET name = '"
                    + editApp_name.getSelectionModel().getSelectedItem() + "', patient_id = '"
                    + editApp_patientId.getText() + "', description = '"
                    + editApp_description.getText() + "', vaccine_id = '"
                    + editApp_vaccineID.getSelectionModel().getSelectedItem().toString() + "', brand = '"
                    + editApp_vaccineBrand.getSelectionModel().getSelectedItem() + "', productName = '"
                    + editApp_productName.getSelectionModel().getSelectedItem() + "', type = '"
                    + editApp_vaccineType.getSelectionModel().getSelectedItem() + "', status = '"
                    + editApp_status.getSelectionModel().getSelectedItem() + "', schedule = '"
                    + editApp_schedule.getValue() + "', date_modify = '"
                    + sqlDate + "' WHERE appointment_id = '"
                    + editApp_appointmentID.getText() + "'";

            connect = Database.connectDB();

            try {
                if (alert.confirmationMessage("Are you sure you want to UPDATE Appointment ID: "
                        + editApp_appointmentID.getText() + "?")) {
                    prepare = connect.prepareStatement(updateData);
                    prepare.executeUpdate();
                    doctorList();
                    statusList();
                    getData();
                    displayFields();
                    appointmentType();
                    patientList();
                    alert.successMessage("Successully Updated!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getData();
        displayFields();
        doctorList();
        statusList();
        appointmentType();
        patientList();
        setSpecialized();
    }

}
