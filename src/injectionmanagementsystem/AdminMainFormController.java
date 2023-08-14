package injectionmanagementsystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 p---------------------- in the editor.P?+''''''''''''''p
package hospitalmanagementsystem;*/
import injectionmanagementsystem.Data;
import injectionmanagementsystem.Database;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author WINDOWS 10
 */
public class AdminMainFormController implements Initializable {

    @FXML
    private Button addVaccine_addBtn;

    @FXML
    private TextField addVaccine_brand;

    @FXML
    private Button addVaccine_clearBtn;

    @FXML
    private TableColumn<vaccineData, String> addVaccine_col_brand;

    @FXML
    private TableColumn<vaccineData, String> addVaccine_col_date;

    @FXML
    private TableColumn<vaccineData, String> addVaccine_col_vaccineID;

    @FXML
    private TableColumn<vaccineData, String> addVaccine_col_price;

    @FXML
    private TableColumn<vaccineData, String> addVaccine_col_productName;

    @FXML
    private TableColumn<vaccineData, String> addVaccine_col_status;

    @FXML
    private TableColumn<vaccineData, String> addVaccine_col_type;

    @FXML
    private Button addVaccine_deleteBtn;

    @FXML
    private AnchorPane addVaccine_form;

    @FXML
    private ImageView addVaccine_imageView;

    @FXML
    private Button addVaccine_importBtn;

    @FXML
    private TextField addVaccine_vaccineID;

    @FXML
    private TextField addVaccine_price;

    @FXML
    private TextField addVaccine_productName;

    @FXML
    private TextField addVaccine_search;

    @FXML
    private ComboBox<?> addVaccine_status;

    @FXML
    private TableView<vaccineData> addVaccine_tableView;

    @FXML
    private ComboBox<?> addVaccine_type;

    @FXML
    private Button addVaccine_updateBtn;

    @FXML
    private Button vaccine_btn;

    // GIVE NAME OF ALL COMPONENTS
    @FXML
    private AnchorPane main_form;

    @FXML
    private Circle top_profile;

    @FXML
    private Label top_username;

    @FXML
    private Label date_time;

    @FXML
    private Label current_form;

    @FXML
    private Label nav_adminID;

    @FXML
    private Label nav_username;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Button doctors_btn;

    @FXML
    private Button patients_btn;

    @FXML
    private Button appointments_btn;

    @FXML
    private Button payment_btn;

    @FXML
    private Button profile_btn;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Label dashboard_AD;

    @FXML
    private Label dashboard_TP;

    @FXML
    private Label dashboard_AP;

    @FXML
    private Label dashboard_tA;

    @FXML
    private AreaChart<?, ?> dashboad_chart_PD;

    @FXML
    private BarChart<?, ?> dashboad_chart_DD;

    @FXML
    private TableView<DoctorData> dashboad_tableView;

    @FXML
    private TableColumn<DoctorData, String> dashboad_col_doctorID;

    @FXML
    private TableColumn<DoctorData, String> dashboad_col_name;

    @FXML
    private TableColumn<DoctorData, String> dashboad_col_specialized;

    @FXML
    private TableColumn<DoctorData, String> dashboad_col_status;

    @FXML
    private AnchorPane doctors_form;

    @FXML
    private TableView<DoctorData> doctors_tableView;

    @FXML
    private TableColumn<DoctorData, String> doctors_col_doctorID;

    @FXML
    private TableColumn<DoctorData, String> doctors_col_name;

    @FXML
    private TableColumn<DoctorData, String> doctors_col_gender;

    @FXML
    private TableColumn<DoctorData, String> doctors_col_contactNumber;

    @FXML
    private TableColumn<DoctorData, String> doctors_col_email;

    @FXML
    private TableColumn<DoctorData, String> doctors_col_specialization;

    @FXML
    private TableColumn<DoctorData, String> doctors_col_address;

    @FXML
    private TableColumn<DoctorData, String> doctors_col_status;

    @FXML
    private TableColumn<DoctorData, String> doctors_col_action;

    @FXML
    private TextField patients_patientID;

    @FXML
    private Button patients_addBtn;

    @FXML
    private TextArea patients_address;

    @FXML
    private ComboBox<?> patients_gender;

    @FXML
    private TextField patients_mobileNumber;

    @FXML
    private TextField patients_password;

    @FXML
    private TextField patients_patientName;

    @FXML
    private AnchorPane patients_form;

    @FXML
    private TableView<PatientsData> patients_tableView;

    @FXML
    private TableColumn<PatientsData, String> patients_col_patientID;

    @FXML
    private TableColumn<PatientsData, String> patients_col_name;

    @FXML
    private TableColumn<PatientsData, String> patients_col_gender;

    @FXML
    private TableColumn<PatientsData, String> patients_col_contactNumber;

    @FXML
    private TableColumn<PatientsData, String> patients_col_description;

    @FXML
    private TableColumn<PatientsData, String> patients_col_date;

    @FXML
    private TableColumn<PatientsData, String> patients_col_dateModify;

    @FXML
    private TableColumn<PatientsData, String> patients_col_dateDelete;

    @FXML
    private TableColumn<PatientsData, String> patients_col_status;

    @FXML
    private TableColumn<PatientsData, String> patients_col_action;

    @FXML
    private AnchorPane appointments_form;

    @FXML
    private TableView<AppointmentData> appointments_tableView;

    @FXML
    private TableColumn<AppointmentData, String> appointments_appointmentID;

    @FXML
    private TableColumn<AppointmentData, String> appointments_name;

    @FXML
    private TableColumn<AppointmentData, String> appointments_gender;

    @FXML
    private TableColumn<AppointmentData, String> appointments_contactNumber;

    @FXML
    private TableColumn<AppointmentData, String> appointments_description;

    @FXML
    private TableColumn<AppointmentData, String> appointments_date;

    @FXML
    private TableColumn<AppointmentData, String> appointments_dateModify;

    @FXML
    private TableColumn<AppointmentData, String> appointments_dateDelete;

    @FXML
    private TableColumn<AppointmentData, String> appointments_status;

    @FXML
    private TableColumn<AppointmentData, String> appointments_action;

    @FXML
    private AnchorPane profile_form;

    @FXML
    private Circle profile_circle;

    @FXML
    private Button profile_importBtn;

    @FXML
    private Label profile_label_adminIO;

    @FXML
    private Label profile_label_name;

    @FXML
    private Label profile_label_email;

    @FXML
    private Label profile_label_dateCreated;

    @FXML
    private TextField profile_adminID;

    @FXML
    private TextField profile_username;

    @FXML
    private TextField profile_email;

    @FXML
    private ComboBox<String> profile_status;

    @FXML
    private Button profile_updateBtn;

    @FXML
    private AnchorPane payment_form;

    @FXML
    private TableView<AppointmentData> payment_tableView;

    @FXML
    private TableColumn<AppointmentData, String> payment_col_patientID;

    @FXML
    private TableColumn<AppointmentData, String> payment_col_name;

    @FXML
    private TableColumn<AppointmentData, String> payment_col_vaccine;

    @FXML
    private TableColumn<AppointmentData, String> payment_col_doctor;

    @FXML
    private TableColumn<AppointmentData, String> payment_col_date;

    @FXML
    private Circle payment_circle;

    @FXML
    private Button payment_checkoutBtn;

    @FXML
    private Label payment_patientID;

    @FXML
    private Label payment_name;

    @FXML
    private Label payment_doctor;

    @FXML
    private Label payment_date;

    @FXML
    private Button logout_btn;

    @FXML
    private CheckBox newDr_checkBox;

    @FXML
    private TextField newDr_doctorID;

    @FXML
    private TextField newDr_email;

    @FXML
    private TextField newDr_fullName;

    @FXML
    private PasswordField newDr_password;

    @FXML
    private TextField newDr_showPassword;

    @FXML
    private Button newDr_signupBtn;

//    DATABASE TOOLS
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    private AlertMessage alert = new AlertMessage();

    private Image image;


////ADD VACCINES
    public void addVaccinesAdd() {

        String sql = "INSERT INTO vaccine (vaccine_id, brand, productName, type, status, price, image, date) "
                + "VALUES(?,?,?,?,?,?,?,?)";

        connect = Database.connectDB();

        try {

            Alert alert;

            if (addVaccine_vaccineID.getText().isEmpty()
                    || addVaccine_brand.getText().isEmpty()
                    || addVaccine_productName.getText().isEmpty()
                    || addVaccine_type.getSelectionModel().getSelectedItem() == null
                    || addVaccine_status.getSelectionModel().getSelectedItem() == null
                    || addVaccine_price.getText().isEmpty()
                    || getData.path == null || getData.path == "") {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                // CHECK IF THE Vaccine ID YOU WANT TO INSERT EXIST
                String checkData = "SELECT vaccine_id FROM Vaccine WHERE `vaccine`.`id` = '"
                        + addVaccine_vaccineID.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Vaccine ID: " + addVaccine_vaccineID.getText() + " was already exist!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, addVaccine_vaccineID.getText());
                    prepare.setString(2, addVaccine_brand.getText());
                    prepare.setString(3, addVaccine_productName.getText());
                    prepare.setString(4, (String) addVaccine_type.getSelectionModel().getSelectedItem());
                    prepare.setString(5, (String) addVaccine_status.getSelectionModel().getSelectedItem());
                    prepare.setString(6, addVaccine_price.getText());

                    String uri = getData.path;
                    uri = uri.replace("\\", "\\\\");

                    prepare.setString(7, uri);

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    prepare.setString(8, String.valueOf(sqlDate));

                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                    addVaccineShowListData();
                    addVaccineReset();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addVaccineUpdate() {

        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");

        String sql = "UPDATE Vaccine SET brand = '"
                + addVaccine_brand.getText() + "', productName = '"
                + addVaccine_productName.getText() + "', type = '"
                + addVaccine_type.getSelectionModel().getSelectedItem() + "', status = '"
                + addVaccine_status.getSelectionModel().getSelectedItem() + "', price = '"
                + addVaccine_price.getText() + "', image = '" + uri + "' WHERE vaccine_id = '"
                + addVaccine_vaccineID.getText() + "'";

        connect = Database.connectDB();

        try {
            Alert alert;

            if (addVaccine_vaccineID.getText().isEmpty()
                    || addVaccine_brand.getText().isEmpty()
                    || addVaccine_productName.getText().isEmpty()
                    || addVaccine_type.getSelectionModel().getSelectedItem() == null
                    || addVaccine_status.getSelectionModel().getSelectedItem() == null
                    || addVaccine_price.getText().isEmpty()
                    || getData.path == null || getData.path == "") {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Vaccine ID:" + addVaccine_vaccineID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    addVaccineShowListData();
                    addVaccineReset();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addVaccineDelete() {

        String sql = "DELETE FROM Vaccine WHERE vaccine_id = '" + addVaccine_vaccineID.getText() + "'";

        connect = Database.connectDB();

        try {
            Alert alert;

            if (addVaccine_vaccineID.getText().isEmpty()
                    || addVaccine_brand.getText().isEmpty()
                    || addVaccine_productName.getText().isEmpty()
                    || addVaccine_type.getSelectionModel().getSelectedItem() == null
                    || addVaccine_status.getSelectionModel().getSelectedItem() == null
                    || addVaccine_price.getText().isEmpty() //                    || getData.path == null || getData.path == ""
                    ) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Vaccine ID:" + addVaccine_vaccineID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(sql);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    addVaccineShowListData();
                    addVaccineReset();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addVaccineReset() {
        addVaccine_vaccineID.setText("");
        addVaccine_brand.setText("");
        addVaccine_productName.setText("");
        addVaccine_price.setText("");
        addVaccine_type.getSelectionModel().clearSelection();
        addVaccine_status.getSelectionModel().clearSelection();

        addVaccine_imageView.setImage(null);

        getData.path = "";

    }

    private String[] addVaccineListT = {"Type1", "Type2", "Type3", "Type4", "Type5"};

    public void addVaccineListType() {
        List<String> listT = new ArrayList<>();

        for (String data : addVaccineListT) {
            listT.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listT);
        addVaccine_type.setItems(listData);

    }

    private String[] addVaccineStatus = {"Available", "Not Available"};

    public void addVaccineListStatus() {
        List<String> listS = new ArrayList<>();

        for (String data : addVaccineStatus) {
            listS.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listS);
        addVaccine_status.setItems(listData);
    }

    public void addVaccineImportImage() {

        FileChooser open = new FileChooser();
        open.setTitle("Import Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image File", "*jpg", "*png"));

        File file = open.showOpenDialog(main_form.getScene().getWindow());

        if (file != null) {
            image = new Image(file.toURI().toString(), 118, 147, false, true);

            addVaccine_imageView.setImage(image);

            getData.path = file.getAbsolutePath();
        }

    }

    public ObservableList<vaccineData> addVaccinesListData() {

        String sql = "SELECT * FROM vaccine";

        ObservableList<vaccineData> listData = FXCollections.observableArrayList();

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            vaccineData medData;

            while (result.next()) {
                medData = new vaccineData(result.getInt("vaccine_id"), result.getString("brand"),
                         result.getString("productName"), result.getString("type"),
                         result.getString("status"), result.getDouble("price"),
                         result.getString("image"), result.getDate("date"));

                listData.add(medData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<vaccineData> addVaccineList;

    public void addVaccineShowListData() {
        addVaccineList = addVaccinesListData();

        addVaccine_col_vaccineID.setCellValueFactory(new PropertyValueFactory<>("vaccineId"));
        addVaccine_col_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        addVaccine_col_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        addVaccine_col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        addVaccine_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        addVaccine_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        addVaccine_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        addVaccine_tableView.setItems(addVaccineList);

    }

    public void addVaccineSearch() {

        FilteredList<vaccineData> filter = new FilteredList<>(addVaccineList, e -> true);

        addVaccine_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateVaccineData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateVaccineData.getVaccineId().toString().contains(searchKey)) {
                    return true;
                } else if (predicateVaccineData.getBrand().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateVaccineData.getProductName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateVaccineData.getType().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateVaccineData.getStatus().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateVaccineData.getPrice().toString().contains(searchKey)) {
                    return true;
                } else if (predicateVaccineData.getDate().toString().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<vaccineData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(addVaccine_tableView.comparatorProperty());
        addVaccine_tableView.setItems(sortList);

    }

    public void addVaccineSelect() {
        vaccineData medData = (vaccineData) addVaccine_tableView.getSelectionModel().getSelectedItem();
        int num = addVaccine_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < - 1) {
            return;
        }

        addVaccine_vaccineID.setText(String.valueOf(medData.getVaccineId()));
        addVaccine_brand.setText(medData.getBrand());
        addVaccine_productName.setText(medData.getProductName());
        addVaccine_price.setText(String.valueOf(medData.getPrice()));

        String uri = "file:" + medData.getImage();

        image = new Image(uri, 118, 147, false, true);
        addVaccine_imageView.setImage(image);

        getData.path = medData.getImage();

    }
    
    ////ADD PATIENT

    public void patientAddBtn() {

        // CHECK IF SOME OR ALL FIELDS ARE EMPTY
        if (patients_patientID.getText().isEmpty()
                || patients_patientName.getText().isEmpty()
                || patients_gender.getSelectionModel().getSelectedItem() == null
                || patients_mobileNumber.getText().isEmpty()
                || patients_password.getText().isEmpty()
                || patients_address.getText().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            Database.connectDB();
            try {
                // CHECK IF THE PATIENT ID THAT THE DOCTORS WANT TO INSERT/ADD IS EXISTING ALREADY
                String checkPatientID = "SELECT * FROM patient WHERE patient_id = '"
                        + patients_patientID.getText() + "'";
                statement = connect.createStatement();
                result = statement.executeQuery(checkPatientID);
                if (result.next()) {
                    alert.errorMessage(patients_patientID.getText() + " is already exist");
                } else {
                    String insertData = "INSERT INTO patient (patient_id, password, full_name,gender, mobile_number, "
                            + "address, doctor, specialized, date, "
                            + "status) "
                            + "VALUES(?,?,?,?,?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, patients_patientID.getText());
                    prepare.setString(2, patients_password.getText());
                    prepare.setString(3, patients_patientName.getText());
                    prepare.setString(4, patients_patientName.getText());
                    prepare.setString(5, patients_mobileNumber.getText());
                    prepare.setString(6, patients_address.getText());
                    prepare.setString(7, "");
                    prepare.setString(8, "");
                    prepare.setString(9, "" + sqlDate);
                    prepare.setString(10, "Acitve");

                    prepare.executeUpdate();

                    alert.successMessage("Added successfully!");
                    // TO CLEAR ALL FIELDS AND SOME LABELS
                    patientClearFields();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void patientClearFields() {
        patients_patientID.clear();
        patients_patientName.clear();
        patients_gender.getSelectionModel().clearSelection();
        patients_mobileNumber.clear();
        patients_password.clear();
        patients_address.clear();
    }

    private void patientGenderList() {

        List<String> listG = new ArrayList<>();

        for (String data : Data.gender) {
            listG.add(data);
        }
        ObservableList listData = FXCollections.observableList(listG);

        patients_gender.setItems(listData);
    }

    public ObservableList<PatientsData> patientGetData() {

        ObservableList<PatientsData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM patient";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            PatientsData pData;

            while (result.next()) {
//                PatientsData(Integer id, Integer patientID, String password, String fullName, Long mobileNumber
//            , String address, String image, String description
//            , String doctor, String specialized, Date date, Date dateModify
//            , Date dateDelete, String status)
                pData = new PatientsData(result.getInt("id"), result.getInt("patient_id"),
                        result.getString("password"), result.getString("full_name"),
                        result.getLong("mobile_number"), result.getString("gender"),
                        result.getString("address"),
                        result.getString("image"), result.getString("description"),
                        result.getString("doctor"),
                        result.getString("specialized"), result.getDate("date"),
                        result.getDate("date_modify"), result.getDate("date_delete"),
                        result.getString("status"));

                listData.add(pData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public ObservableList<PatientsData> patientListData;

    public void patientDisplayData() {
        patientListData = patientGetData();

        patients_col_patientID.setCellValueFactory(new PropertyValueFactory<>("patientID"));
        patients_col_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        patients_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        patients_col_contactNumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        patients_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        patients_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        patients_col_dateModify.setCellValueFactory(new PropertyValueFactory<>("dateModify"));
        patients_col_dateDelete.setCellValueFactory(new PropertyValueFactory<>("dateDelete"));
        patients_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        patients_tableView.setItems(patientListData);
    }

    public void patientActionButton() {

        connect = Database.connectDB();
        patientListData = patientGetData();

        Callback<TableColumn<PatientsData, String>, TableCell<PatientsData, String>> cellFactory = (TableColumn<PatientsData, String> param) -> {
            final TableCell<PatientsData, String> cell = new TableCell<PatientsData, String>() {
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        Button editButton = new Button("Edit");
                        Button removeButton = new Button("Delete");

                        editButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #188ba7, #306090);\n"
                                + "    -fx-cursor: hand;\n"
                                + "    -fx-text-fill: #fff;\n"
                                + "    -fx-font-size: 14px;\n"
                                + "    -fx-font-family: Arial;");

                        removeButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #188ba7, #306090);\n"
                                + "    -fx-cursor: hand;\n"
                                + "    -fx-text-fill: #fff;\n"
                                + "    -fx-font-size: 14px;\n"
                                + "    -fx-font-family: Arial;");

                        editButton.setOnAction((ActionEvent event) -> {
                            try {

                                PatientsData pData = patients_tableView.getSelectionModel().getSelectedItem();
                                int num = patients_tableView.getSelectionModel().getSelectedIndex();

                                if ((num - 1) < -1) {
                                    alert.errorMessage("Please select item first");
                                    return;
                                }

                                Data.temp_PatientID = pData.getPatientID();
                                Data.temp_address = pData.getAddress();
                                Data.temp_name = pData.getFullName();
                                Data.temp_gender = pData.getGender();
                                Data.temp_number = pData.getMobileNumber();
                                Data.temp_status = pData.getStatus();

                                // NOW LETS CREATE FXML FOR EDIT PATIENT FORM
                                Parent root = FXMLLoader.load(getClass().getResource("EditPatientForm.fxml"));
                                Stage stage = new Stage();

                                stage.setScene(new Scene(root));
                                stage.show();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });

                        removeButton.setOnAction((ActionEvent event) -> {
                            PatientsData pData = patients_tableView.getSelectionModel().getSelectedItem();
                            int num = patients_tableView.getSelectionModel().getSelectedIndex();

                            if ((num - 1) < -1) {
                                alert.errorMessage("Please select item first");
                                return;
                            }

                            String deleteData = "UPDATE patient SET date_delete = ? WHERE patient_id = '"
                                    + pData.getPatientID() + "'";

                            try {
                                if (alert.confirmationMessage("Are you sure you want to delete Patient ID: " + pData.getPatientID() + "?")) {
                                    prepare = connect.prepareStatement(deleteData);
                                    Date date = new Date();
                                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                                    prepare.setString(1, String.valueOf(sqlDate));
                                    prepare.executeUpdate();

                                    doctorGetData();
                                    alert.successMessage("Deleted Successfully!");

                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });

                        HBox manageBtn = new HBox(editButton, removeButton);
                        manageBtn.setAlignment(Pos.CENTER);
                        manageBtn.setSpacing(5);
                        setGraphic(manageBtn);
                        setText(null);
                    }
                }
            };
            doctorDisplayData();
            return cell;
        };

        patients_col_action.setCellFactory(cellFactory);
        patients_tableView.setItems(patientListData);

    }

    

    public void dashboardAD() {

        String sql = "SELECT COUNT(id) FROM doctor WHERE status = 'Active' AND delete_date IS NULL";

        connect = Database.connectDB();

        int tempAD = 0;
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                tempAD = result.getInt("COUNT(id)");
            }
            dashboard_AD.setText(String.valueOf(tempAD));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dashboardTP() {

        String sql = "SELECT COUNT(id) FROM patient WHERE date_delete IS NULL";

        connect = Database.connectDB();

        int tempTP = 0;
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                tempTP = result.getInt("COUNT(id)");
            }
            dashboard_TP.setText(String.valueOf(tempTP));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dashboardAP() {

        String sql = "SELECT COUNT(id) FROM patient WHERE date_delete IS NULL AND status = 'Active'";

        connect = Database.connectDB();

        int tempAP = 0;
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                tempAP = result.getInt("COUNT(id)");
            }
            dashboard_AP.setText(String.valueOf(tempAP));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dashboardTA() {

        String sql = "SELECT COUNT(id) FROM appointment WHERE date_delete IS NULL";

        connect = Database.connectDB();

        int tempTA = 0;
        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                tempTA = result.getInt("COUNT(id)");
            }
            dashboard_AP.setText(String.valueOf(tempTA));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ObservableList<DoctorData> dashboardGetDoctorData() {

        ObservableList<DoctorData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM doctor WHERE delete_date IS NULL";

        connect = Database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            DoctorData dData;

            while (result.next()) {
//                DoctorData(String doctorID, String fullName, String specialized, String status)
                dData = new DoctorData(result.getString("doctor_id"),
                        result.getString("full_name"), result.getString("specialized"),
                        result.getString("status"));

                listData.add(dData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public ObservableList<DoctorData> dashboardGetDoctorListData;

    public void dashboardGetDoctorDisplayData() {
        dashboardGetDoctorListData = dashboardGetDoctorData();

        dashboad_col_doctorID.setCellValueFactory(new PropertyValueFactory<>("doctorID"));
        dashboad_col_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        dashboad_col_specialized.setCellValueFactory(new PropertyValueFactory<>("specialized"));
        dashboad_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        dashboad_tableView.setItems(dashboardGetDoctorListData);

    }

    public void dashboardPatientDataChart() {
        dashboad_chart_PD.getData().clear();

        String selectData = "SELECT date, COUNT(id) FROM patient WHERE date_delete IS NULL GROUP BY TIMESTAMP(datE) ASC LIMIT 8";

        connect = Database.connectDB();
        XYChart.Series chart = new XYChart.Series<>();

        try {
            prepare = connect.prepareStatement(selectData);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
            }

            dashboad_chart_PD.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void dashboardDoctorDataChart() {
        dashboad_chart_DD.getData().clear();

        String selectData = "SELECT date, COUNT(id) FROM doctor WHERE delete_date IS NULL GROUP BY TIMESTAMP(date) ASC LIMIT 6";

        connect = Database.connectDB();
        XYChart.Series chart = new XYChart.Series<>();

        try {
            prepare = connect.prepareStatement(selectData);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
            }

            dashboad_chart_DD.getData().add(chart);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    ////DOCTOR MANAGE

    public ObservableList<DoctorData> doctorGetData() {
        ObservableList<DoctorData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM doctor";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            DoctorData dData;
            while (result.next()) {
//                DoctorData(Integer id, String doctorID, String password, String fullName,
//            String email, String gender, Long mobileNumber, String specialized, String address,
//            String image, Date date, Date dateModify, Date dateDelete, String status)
                dData = new DoctorData(result.getInt("id"), result.getString("doctor_id"),
                        result.getString("password"), result.getString("full_name"),
                        result.getString("email"), result.getString("gender"),
                        result.getLong("mobile_number"), result.getString("specialized"),
                        result.getString("address"), result.getString("image"),
                        result.getDate("date"), result.getDate("modify_date"),
                        result.getDate("delete_date"), result.getString("status"));

                listData.add(dData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<DoctorData> doctorListData;

    public void doctorDisplayData() {
        doctorListData = doctorGetData();

        doctors_col_doctorID.setCellValueFactory(new PropertyValueFactory<>("doctorID"));
        doctors_col_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        doctors_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        doctors_col_contactNumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        doctors_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        doctors_col_specialization.setCellValueFactory(new PropertyValueFactory<>("specialized"));
        doctors_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        doctors_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        doctors_tableView.setItems(doctorListData);

    }

    public void doctorActionButton() {

        connect = Database.connectDB();
        doctorListData = doctorGetData();

        Callback<TableColumn<DoctorData, String>, TableCell<DoctorData, String>> cellFactory = (TableColumn<DoctorData, String> param) -> {
            final TableCell<DoctorData, String> cell = new TableCell<DoctorData, String>() {
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        Button editButton = new Button("Edit");
                        Button removeButton = new Button("Delete");

                        editButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #188ba7, #306090);\n"
                                + "    -fx-cursor: hand;\n"
                                + "    -fx-text-fill: #fff;\n"
                                + "    -fx-font-size: 14px;\n"
                                + "    -fx-font-family: Arial;");

                        removeButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #188ba7, #306090);\n"
                                + "    -fx-cursor: hand;\n"
                                + "    -fx-text-fill: #fff;\n"
                                + "    -fx-font-size: 14px;\n"
                                + "    -fx-font-family: Arial;");

                        editButton.setOnAction((ActionEvent event) -> {
                            try {

                                DoctorData pData = doctors_tableView.getSelectionModel().getSelectedItem();
                                int num = doctors_tableView.getSelectionModel().getSelectedIndex();

                                if ((num - 1) < -1) {
                                    alert.errorMessage("Please select item first");
                                    return;
                                }

                                Data.temp_doctorID = pData.getDoctorID();
                                Data.temp_doctorName = pData.getFullName();
                                Data.temp_doctorEmail = pData.getEmail();
                                Data.temp_doctorPassword = pData.getPassword();
                                Data.temp_doctorSpecialized = pData.getSpecialized();
                                Data.temp_doctorGender = pData.getGender();
                                Data.temp_doctorMobileNumber = String.valueOf(pData.getMobileNumber());
                                Data.temp_doctorAddress = pData.getAddress();
                                Data.temp_doctorStatus = pData.getStatus();
                                Data.temp_doctorImagePath = pData.getImage();

                                // NOW LETS CREATE FXML FOR EDIT PATIENT FORM
                                Parent root = FXMLLoader.load(getClass().getResource("EditDoctorForm.fxml"));
                                Stage stage = new Stage();

                                stage.setScene(new Scene(root));
                                stage.show();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });

                        removeButton.setOnAction((ActionEvent event) -> {
                            DoctorData pData = doctors_tableView.getSelectionModel().getSelectedItem();
                            int num = doctors_tableView.getSelectionModel().getSelectedIndex();

                            if ((num - 1) < -1) {
                                alert.errorMessage("Please select item first");
                                return;
                            }

                            String deleteData = "UPDATE doctor SET delete_date = ? WHERE doctor_id = '"
                                    + pData.getDoctorID() + "'";

                            try {
                                if (alert.confirmationMessage("Are you sure you want to delete Doctor ID: " + pData.getDoctorID() + "?")) {
                                    prepare = connect.prepareStatement(deleteData);
                                    Date date = new Date();
                                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                                    prepare.setString(1, String.valueOf(sqlDate));
                                    prepare.executeUpdate();

                                    doctorGetData();
                                    alert.successMessage("Deleted Successfully!");

                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });

                        HBox manageBtn = new HBox(editButton, removeButton);
                        manageBtn.setAlignment(Pos.CENTER);
                        manageBtn.setSpacing(5);
                        setGraphic(manageBtn);
                        setText(null);
                    }
                }
            };
            doctorDisplayData();
            return cell;
        };

        doctors_col_action.setCellFactory(cellFactory);
        doctors_tableView.setItems(doctorListData);

    }
    
    @FXML
    void registerAccount() {

        if (newDr_fullName.getText().isEmpty()
                || newDr_email.getText().isEmpty()
                || newDr_doctorID.getText().isEmpty()
                || newDr_password.getText().isEmpty()) {
            alert.errorMessage("Please fill all blank fields");
        } else {

            String checkDoctorID = "SELECT * FROM doctor WHERE doctor_id = '"
                    + newDr_doctorID.getText() + "'"; // LETS CREATE OUR TABLE FOR DOCTOR FIRST

            connect = Database.connectDB();

            try {

                if (!newDr_showPassword.isVisible()) {
                    if (!newDr_showPassword.getText().equals(newDr_password.getText())) {
                        newDr_showPassword.setText(newDr_password.getText());
                    }
                } else {
                    if (!newDr_showPassword.getText().equals(newDr_password.getText())) {
                        newDr_password.setText(newDr_showPassword.getText());
                    }
                }

                prepare = connect.prepareStatement(checkDoctorID);
                result = prepare.executeQuery();

                if (result.next()) {
                    alert.errorMessage(newDr_doctorID.getText() + " is already taken");
                } else if (newDr_password.getText().length() < 8) {
                    alert.errorMessage("Invalid password, at least 8 characters needed");
                } else {

                    String insertData = "INSERT INTO doctor (full_name, email, doctor_id, password, date, status) "
                            + "VALUES(?,?,?,?,?,?)";

                    prepare = connect.prepareStatement(insertData);

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    prepare.setString(1, newDr_fullName.getText());
                    prepare.setString(2, newDr_email.getText());
                    prepare.setString(3, newDr_doctorID.getText());
                    prepare.setString(4, newDr_password.getText());
                    prepare.setString(5, String.valueOf(sqlDate));
                    prepare.setString(6, "Confirm");

                    prepare.executeUpdate();

                    alert.successMessage("Created new doctor Succesfully!");

                    doctorDisplayData();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    @FXML
    void registerShowPassword() {

        if (newDr_checkBox.isSelected()) {
            newDr_showPassword.setText(newDr_password.getText());
            newDr_showPassword.setVisible(true);
            newDr_password.setVisible(false);
        } else {
            newDr_password.setText(newDr_showPassword.getText());
            newDr_showPassword.setVisible(false);
            newDr_password.setVisible(true);
        }

    }

    public void registerDoctorID() {
        String doctorID = "DID-";
        int tempID = 0;
        String sql = "SELECT MAX(id) FROM doctor";

        connect = Database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                tempID = result.getInt("MAX(id)");
            }

            if (tempID == 0) {
                tempID += 1;
                doctorID += tempID;
            } else {
                doctorID += (tempID + 1);
            }

            newDr_doctorID.setText(doctorID);
            newDr_doctorID.setDisable(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ObservableList<AppointmentData> appointmentGetData() {

        ObservableList<AppointmentData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM appointment";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            AppointmentData aData;
            while (result.next()) {
//            AppointmentData(Integer id, Integer appointmentID, String name, String gender,
//            String description,
//            Date date, Date dateModify, Date dateDelete, String status, Date schedule)
                aData = new AppointmentData(result.getInt("id"), result.getInt("appointment_id"),result.getInt("patient_id"),
                        result.getString("name"), result.getString("gender"),
                        result.getString("description"), result.getInt("vaccine_id"),
                        result.getString("brand"), result.getString("productName"), result.getString("type"),
                        result.getString("doctor"), result.getString("specialized"),
                        result.getDate("date"), result.getDate("date_modify"),
                        result.getDate("date_delete"), result.getString("status"),
                        result.getDate("schedule"));
                listData.add(aData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<AppointmentData> appointmentListData;

    public void appointmentDisplayData() {
        appointmentListData = appointmentGetData();

        appointments_appointmentID.setCellValueFactory(new PropertyValueFactory<>("appointmentID"));
        appointments_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        appointments_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        appointments_contactNumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        appointments_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        appointments_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        appointments_dateModify.setCellValueFactory(new PropertyValueFactory<>("dateModify"));
        appointments_dateDelete.setCellValueFactory(new PropertyValueFactory<>("dateDelete"));
        appointments_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        appointments_tableView.setItems(appointmentListData);

    }

    public void appointmentActionButton() {

        connect = Database.connectDB();
        appointmentListData = appointmentGetData();

        Callback<TableColumn<AppointmentData, String>, TableCell<AppointmentData, String>> cellFactory = (TableColumn<AppointmentData, String> param) -> {
            final TableCell<AppointmentData, String> cell = new TableCell<AppointmentData, String>() {
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        Button editButton = new Button("Edit");
                        Button removeButton = new Button("Delete");

                        editButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #188ba7, #306090);\n"
                                + "    -fx-cursor: hand;\n"
                                + "    -fx-text-fill: #fff;\n"
                                + "    -fx-font-size: 14px;\n"
                                + "    -fx-font-family: Arial;");

                        removeButton.setStyle("-fx-background-color: linear-gradient(to bottom right, #188ba7, #306090);\n"
                                + "    -fx-cursor: hand;\n"
                                + "    -fx-text-fill: #fff;\n"
                                + "    -fx-font-size: 14px;\n"
                                + "    -fx-font-family: Arial;");

                        editButton.setOnAction((ActionEvent event) -> {
                            try {

                                AppointmentData aData = appointments_tableView.getSelectionModel().getSelectedItem();
                                int num = appointments_tableView.getSelectionModel().getSelectedIndex();

                                if ((num - 1) < -1) {
                                    alert.errorMessage("Please select item first");
                                    return;
                                }

                                Data.temp_appID = String.valueOf(aData.getAppointmentID());
                                Data.temp_appName = aData.getName();
                                Data.temp_appGender = aData.getGender();
                                Data.temp_appDescription = aData.getDescription();
                                Data.temp_appDoctor = aData.getDoctorID();
                                Data.temp_appSpecialized = aData.getSpecialized();
                                Data.temp_appStatus = aData.getStatus();

                                // NOW LETS CREATE FXML FOR EDIT APPOINTMENT FORM
                                Parent root = FXMLLoader.load(getClass().getResource("EditAppointmentForm.fxml"));
                                Stage stage = new Stage();

                                stage.setScene(new Scene(root));
                                stage.show();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });

                        removeButton.setOnAction((ActionEvent event) -> {
                            AppointmentData aData = appointments_tableView.getSelectionModel().getSelectedItem();
                            int num = appointments_tableView.getSelectionModel().getSelectedIndex();

                            if ((num - 1) < -1) {
                                alert.errorMessage("Please select item first");
                                return;
                            }

                            String deleteData = "UPDATE appointment SET date_delete = ? WHERE appointment_id = '"
                                    + aData.getAppointmentID() + "'";

                            try {
                                if (alert.confirmationMessage("Are you sure you want to delete Appointment ID: " + aData.getAppointmentID() + "?")) {
                                    prepare = connect.prepareStatement(deleteData);
                                    Date date = new Date();
                                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                                    prepare.setString(1, String.valueOf(sqlDate));
                                    prepare.executeUpdate();

                                    doctorGetData();
                                    alert.successMessage("Deleted Successfully!");

                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });

                        HBox manageBtn = new HBox(editButton, removeButton);
                        manageBtn.setAlignment(Pos.CENTER);
                        manageBtn.setSpacing(5);
                        setGraphic(manageBtn);
                        setText(null);
                    }
                }
            };
            doctorDisplayData();
            return cell;
        };

        appointments_action.setCellFactory(cellFactory);
        appointments_tableView.setItems(appointmentListData);

    }

    ////PAYMENT MANAGE
    public ObservableList<AppointmentData> paymentGetData() {

ObservableList<AppointmentData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM appointment";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            AppointmentData aData;
            while (result.next()) {
//            AppointmentData(Integer id, Integer appointmentID, String name, String gender,
//            String description,
//            Date date, Date dateModify, Date dateDelete, String status, Date schedule)
                aData = new AppointmentData(result.getInt("id"), result.getInt("appointment_id"),result.getInt("patient_id"),
                        result.getString("name"), result.getString("gender"),
                        result.getString("description"), result.getInt("vaccine_id"),
                        result.getString("brand"), result.getString("productName"), result.getString("type"),
                        result.getString("doctor"), result.getString("specialized"),
                        result.getDate("date"), result.getDate("date_modify"),
                        result.getDate("date_delete"), result.getString("status"),
                        result.getDate("schedule"));
                listData.add(aData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public ObservableList<AppointmentData> paymentListData;

    public void paymentDisplayData() {
        paymentListData = paymentGetData();

        payment_col_patientID.setCellValueFactory(new PropertyValueFactory<>("patientID"));
        payment_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        payment_col_vaccine.setCellValueFactory(new PropertyValueFactory<>("productName"));
        payment_col_doctor.setCellValueFactory(new PropertyValueFactory<>("doctor"));
        payment_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        payment_tableView.setItems(paymentListData);

    }

    public void paymentSelectItems() {

        AppointmentData pData = payment_tableView.getSelectionModel().getSelectedItem();
        int num = payment_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
//        if (pData.getImage() != null) {
//            String path = "File:" + pData.getImage();
//            image = new Image(path, 144, 105, false, true);
//            payment_circle.setFill(new ImagePattern(image));
//
//            Data.temp_path = pData.getImage();
//        }

        Data.temp_appID = String.valueOf(pData.getAppointmentID());

        payment_patientID.setText(String.valueOf(pData.getPatientID()));
        payment_name.setText(pData.getName());
        payment_doctor.setText(pData.getDoctorID());
        payment_date.setText(String.valueOf(pData.getDate()));

    }

    public void paymentCheckOutBtn() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("CheckOutPatient.fxml"));
            Stage stage = new Stage();

            stage.setTitle("Injection Management System | Check-Out");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
    ////PROFILE
    public void profileUpdateBtn() {
        connect = Database.connectDB();
        if (profile_adminID.getText().isEmpty()
                || profile_username.getText().isEmpty()
                || profile_email.getText().isEmpty()
                || profile_status.getSelectionModel().getSelectedItem() == null) {
            alert.errorMessage("Please fill all blank fields");
        } else {
            if (Data.path == null || "".equals(Data.path)) {
                String updateData = "UPDATE admin SET username = ?, email = ?, gender = ? "
                        + "WHERE admin_id = " + Data.admin_id;

                try {
                    prepare = connect.prepareStatement(updateData);
                    prepare.setString(1, profile_username.getText());
                    prepare.setString(2, profile_email.getText());
                    prepare.setString(3, profile_status.getSelectionModel().getSelectedItem());

                    prepare.executeUpdate();

                    profileDisplayInfo();

                    alert.successMessage("Updated Successfully");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                String updateData = "UPDATE admin SET username = ?, email = ?, image = ?, gender = ? "
                        + "WHERE admin_id = " + Data.admin_id;
                try {
                    prepare = connect.prepareStatement(updateData);
                    prepare.setString(1, profile_username.getText());
                    prepare.setString(2, profile_email.getText());

                    String path = Data.path;
                    path = path.replace("\\", "\\\\");
                    Path transfer = Paths.get(path);

                    Path copy = Paths.get("C:\\Users\\WINDOWS 10\\Documents\\NetBeansProjects\\HospitalManagementSystem\\src\\Admin_Directory\\"
                            + Data.admin_id + ".jpg");

                    Files.copy(transfer, copy, StandardCopyOption.REPLACE_EXISTING);
                    prepare.setString(3, copy.toAbsolutePath().toString());
                    prepare.setString(4, profile_status.getSelectionModel().getSelectedItem());

                    prepare.executeUpdate();
                    profileDisplayInfo();
                    profileDisplayImages();
                    alert.successMessage("Updated Successfully!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void profileDisplayImages() {

        String selectData = "SELECT * FROM admin WHERE admin_id = " + Data.admin_id;
        connect = Database.connectDB();

        String tempPath1 = "";
        String tempPath2 = "";
        try {
            prepare = connect.prepareStatement(selectData);
            result = prepare.executeQuery();

            if (result.next()) {
                tempPath1 = "File:" + result.getString("image");
                tempPath2 = "File:" + result.getString("image");

                if (result.getString("image") != null) {
                    image = new Image(tempPath1, 1012, 22, false, true);
                    top_profile.setFill(new ImagePattern(image));

                    image = new Image(tempPath2, 137, 95, false, true);
                    profile_circle.setFill(new ImagePattern(image));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void profileInsertImage() {

        FileChooser open = new FileChooser();
        open.getExtensionFilters().add(new ExtensionFilter("Open Image", "*jpg", "*jpeg", "*png"));

        File file = open.showOpenDialog(profile_importBtn.getScene().getWindow());

        if (file != null) {
            Data.path = file.getAbsolutePath();

            image = new Image(file.toURI().toString(), 137, 95, false, true);
            profile_circle.setFill(new ImagePattern(image));
        }

    }

    public void profileDisplayInfo() {

        String sql = "SELECT * FROM admin WHERE admin_id = " + Data.admin_id;
        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                profile_adminID.setText(result.getString("admin_id"));
                profile_username.setText(result.getString("username"));
                profile_email.setText(result.getString("email"));
                profile_status.getSelectionModel().select(result.getString("gender"));

                profile_label_adminIO.setText(result.getString("admin_id"));
                profile_label_name.setText(result.getString("username"));
                profile_label_email.setText(result.getString("email"));
                profile_label_dateCreated.setText(result.getString("date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void profileStatusList() {
        List<String> listS = new ArrayList<>();

        for (String data : Data.gender) {
            listS.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listS);
        profile_status.setItems(listData);
    }

    // MAKE SURE THAT THE ID OF EVERY COMPONENTS TO THE OTHER IS DIFFERENT
    public void switchForm(ActionEvent event) {

        if (event.getSource() == dashboard_btn) {
            dashboard_form.setVisible(true);
            doctors_form.setVisible(false);
            patients_form.setVisible(false);
            appointments_form.setVisible(false);
            payment_form.setVisible(false);
            profile_form.setVisible(false);
            addVaccine_form.setVisible(false);

            dashboardAD();
            dashboardTP();
            dashboardAP();
            dashboardTA();
            dashboardGetDoctorDisplayData();

            current_form.setText("Dashboard Form");
        } else if (event.getSource() == doctors_btn) {
            dashboard_form.setVisible(false);
            doctors_form.setVisible(true);
            patients_form.setVisible(false);
            appointments_form.setVisible(false);
            payment_form.setVisible(false);
            profile_form.setVisible(false);
            addVaccine_form.setVisible(false);

            // TO DISPLAY IMMEDIATELY THE DATA OF DOCTORS IN TABLEVIEW
            doctorDisplayData();
            doctorActionButton();

            current_form.setText("Doctor's Form");
        } else if (event.getSource() == patients_btn) {
            dashboard_form.setVisible(false);
            doctors_form.setVisible(false);
            patients_form.setVisible(true);
            appointments_form.setVisible(false);
            payment_form.setVisible(false);
            profile_form.setVisible(false);
            addVaccine_form.setVisible(false);

            patientDisplayData();
            patientActionButton();

            // TO DISPLAY IMMEDIATELY THE DATA OF PATIENTS IN TABLEVIEW
            current_form.setText("Patient's Form");
        } else if (event.getSource() == vaccine_btn) {
            dashboard_form.setVisible(false);
            doctors_form.setVisible(false);
            patients_form.setVisible(false);
            appointments_form.setVisible(false);
            payment_form.setVisible(false);
            profile_form.setVisible(false);
            addVaccine_form.setVisible(true);

            // TO DISPLAY IMMEDIATELY THE DATA OF VACCINES IN TABLEVIEW
            addVaccineShowListData();
            addVaccineListStatus();
            addVaccineListType();
            addVaccineSearch();

            current_form.setText("Doctor's Form");
        } else if (event.getSource() == appointments_btn) {
            dashboard_form.setVisible(false);
            doctors_form.setVisible(false);
            patients_form.setVisible(false);
            appointments_form.setVisible(true);
            payment_form.setVisible(false);
            profile_form.setVisible(false);
            addVaccine_form.setVisible(false);

            // TO DISPLAY IMMEDIATELY THE DATA OF APPOINTMENTS IN TABLEVIEW
            appointmentDisplayData();

            current_form.setText("Appointment's Form");
        } else if (event.getSource() == payment_btn) {
            dashboard_form.setVisible(false);
            doctors_form.setVisible(false);
            patients_form.setVisible(false);
            appointments_form.setVisible(false);
            payment_form.setVisible(true);
            profile_form.setVisible(false);
            addVaccine_form.setVisible(false);

            paymentDisplayData();

            current_form.setText("Payment Form");
        } else if (event.getSource() == profile_btn) {
            dashboard_form.setVisible(false);
            doctors_form.setVisible(false);
            patients_form.setVisible(false);
            appointments_form.setVisible(false);
            payment_form.setVisible(false);
            profile_form.setVisible(true);
            addVaccine_form.setVisible(false);

            profileStatusList();
            profileDisplayInfo();
            profileDisplayImages();

            current_form.setText("Profile Form");
        }

    }

    public void displayAdminIDUsername() {

        String sql = "SELECT * FROM admin WHERE username = '"
                + Data.admin_username + "'";

        connect = Database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                nav_adminID.setText(result.getString("admin_id"));
                String tempUsername = result.getString("username");
                tempUsername = tempUsername.substring(0, 1).toUpperCase() + tempUsername.substring(1); // TO SET THE FIRST LETTER TO UPPER CASE
                nav_username.setText(tempUsername);
                top_username.setText(tempUsername);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void logoutBtn() {

        try {
            if (alert.confirmationMessage("Are you sure you want to logout?")) {
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();

                stage.setScene(new Scene(root));
                stage.show();

                // TO HIDE YOUR MAIN FORM
                logout_btn.getScene().getWindow().hide();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void runTime() {

        new Thread() {

            public void run() {
                SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
                while (true) {
                    try {

                        Thread.sleep(1000); // 1000 ms = 1s

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Platform.runLater(() -> {
                        date_time.setText(format.format(new Date()));
                    });
                }
            }
        }.start();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        runTime();
        displayAdminIDUsername();

//        DASHBOARD
        dashboardAD();
        dashboardTP();
        dashboardAP();
        dashboardTA();
        dashboardGetDoctorDisplayData();
        dashboardPatientDataChart();
        dashboardDoctorDataChart();

        // TO DISPLAY IMMEDIATELY THE DATA OF DOCTORS IN TABLEVIEW
        doctorDisplayData();
        doctorActionButton();
        registerDoctorID();

        // TO DISPLAY IMMEDIATELY THE DATA OF PATIENTS IN TABLEVIEW
        patientGenderList();
        patientDisplayData();
        patientActionButton();

        addVaccineShowListData();
        addVaccineListStatus();
        addVaccineListType();

        // TO DISPLAY IMMEDIATELY THE DATA OF APPOINTMENTS IN TABLEVIEW
        appointmentDisplayData();
        appointmentActionButton();

        // TO DISPLAY IMMEDIATELY THE DATA OF PAYMENT IN TABLEVIEW
        paymentDisplayData();

        profileStatusList();
        profileDisplayInfo();
        profileDisplayImages();
    }

}

// THATS IT FOR THESE VIDEOS, THANKS FOR WATCHING
// SUBSCRIBE OUR CHANNEL FOR THE SUPPORT
// THANK YOU!! :)))))))
