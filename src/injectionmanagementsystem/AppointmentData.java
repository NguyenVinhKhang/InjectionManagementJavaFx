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
public class AppointmentData {

    private Integer id;
    private Integer appointmentID;
    private Integer patientID;
    private String name;
    private String gender;
    private String description;
    private Integer vaccine_id;
    private String brand;
    private String productName;
    private String type;
    private Date date;
    private Date dateModify;
    private Date dateDelete;
    private String status;
    private String doctorID;
    private String specialized;
    private Date schedule;

    public AppointmentData(Integer id, Integer appointmentID,Integer patientID, String name, String gender,
            String description,Integer vaccine_id, String brand, String productName, String type,
            String doctorID, String specialized,
            Date date, Date dateModify, Date dateDelete, String status, Date schedule) {
        this.id = id;
        this.appointmentID = appointmentID;
        this.patientID=patientID;
        this.name = name;
        this.gender = gender;
        this.description = description;
        this.vaccine_id = vaccine_id;
        this.brand = brand;
        this.productName = productName;
        this.type = type;
        this.doctorID = doctorID;
        this.specialized = specialized;
        this.date = date;
        this.dateModify = dateModify;
        this.dateDelete = dateDelete;
        this.status = status;
        this.schedule = schedule;

    }

    public AppointmentData(Integer appointmentID, String name, String gender,
             String description,Integer vaccine_id, String brand, String productName, String type,
            Date date, Date dateModify, Date dateDelete, String status, Date schedule) {

        this.appointmentID = appointmentID;
        this.name = name;
        this.gender = gender;
        this.description = description;
        this.vaccine_id = vaccine_id;
        this.brand = brand;
        this.productName = productName;
        this.type = type;
        this.date = date;
        this.dateModify = dateModify;
        this.dateDelete = dateDelete;
        this.status = status;
        this.schedule = schedule;

    }

    public AppointmentData(Integer appointmentID, String name,
            String description, Date date, String status) {
        this.appointmentID = appointmentID;
        this.name = name;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    public AppointmentData(Integer appointmentID, String description,Integer vaccine_id, String brand, String productName, String type,
             String doctorID, Date schedule) {
        this.appointmentID = appointmentID;
        this.description = description;
        this.vaccine_id = vaccine_id;
        this.brand = brand;
        this.productName = productName;
        this.type = type;
        this.doctorID = doctorID;
        this.schedule = schedule;
    }
    
    public Integer getPatientID() {
        return patientID;
    }

    public Integer getVaccine_id() {
        return vaccine_id;
    }

    public String getBrand() {
        return brand;
    }

    public String getProductName() {
        return productName;
    }

    public String getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAppointmentID() {
        return appointmentID;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDescription() {
        return description;
    }

    public String getDoctorID() {
        return doctorID;
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

    public Date getSchedule() {
        return schedule;
    }

}
