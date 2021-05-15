package com.newsampath.driving.school.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String idNumber;
    @Column
    private String idType;
    @Column
    private String fullName;
    @Column
    private String address;
    @Column
    private String telephoneNo;
    @Column
    private String gender;
    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDay;
    @Column
    private String licenceType;

    @Column
    private long advance;

    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate advancedDate;

    @Column
    private String medicalId;

    @Column
    private String vehicaleClass;

    @Column
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(String licenceType) {
        this.licenceType = licenceType;
    }

    public long getAdvance() {
        return advance;
    }

    public void setAdvance(long advance) {
        this.advance = advance;
    }

    public LocalDate getAdvancedDate() {
        return advancedDate;
    }

    public void setAdvancedDate(LocalDate advancedDate) {
        this.advancedDate = advancedDate;
    }

    public String getMedicalId() {
        return medicalId;
    }

    public void setMedicalId(String medicalId) {
        this.medicalId = medicalId;
    }

    public String getVehicaleClass() {
        return vehicaleClass;
    }

    public void setVehicaleClass(String vehicaleClass) {
        this.vehicaleClass = vehicaleClass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}