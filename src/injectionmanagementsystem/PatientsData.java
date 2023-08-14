/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package injectionmanagementsystem;

import java.sql.Date;

/**
 *
 * @author WINDOWS 10
 */
public class PatientsData {

    private Integer id;
    private Integer patientID;
    private String password;
    private String fullName;
    private Long mobileNumber;
    private String address;
    private String image;
    private String doctor;
    private String specialized;
    private String description;
    private String gender;

    private Date date;
    private Date dateModify;
    private Date dateDelete;
    private String status;

    public PatientsData(Integer id, Integer patientID, String password, String fullName, Long mobileNumber,
             String gender, String address, String image, String description,
             String doctor, String specialized, Date date, Date dateModify,
             Date dateDelete, String status) {
        this.id = id;
        this.patientID = patientID;
        this.password = password;
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.address = address;
        this.image = image;
        this.doctor = doctor;
        this.specialized = specialized;
        this.description = description;
        this.date = date;
        this.dateModify = dateModify;
        this.dateDelete = dateDelete;
        this.status = status;
    }

    public PatientsData(Integer id, Integer patientID, String fullName, String gender,
            Long mobileNumber, String address, String status, Date date,
             Date dateModify, Date dateDelete) {
        this.id = id;
        this.patientID = patientID;
        this.fullName = fullName;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.status = status;
        this.date = date;
        this.dateModify = dateModify;
        this.dateDelete = dateDelete;
    }

    public PatientsData(Integer id, Integer patientID, String fullName, String gender,
             String description, String doctor, String image, Date date) {
        this.id = id;
        this.patientID = patientID;
        this.fullName = fullName;
        this.description = description;
        this.gender = gender;
        this.doctor = doctor;
        this.image = image;
        this.date = date;
    }

    public PatientsData(Integer id, Integer patientID, String description,
             Date date) {
        this.id = id;
        this.patientID = patientID;
        this.date = date;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getImage() {
        return image;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getSpecialized() {
        return specialized;
    }

    public Date getDate() {
        return date;
    }

    public Date getDateModify() {
        return dateModify;
    }

    public Date getDateDelete() {
        return dateDelete;
    }

    public String getStatus() {
        return status;
    }
}
