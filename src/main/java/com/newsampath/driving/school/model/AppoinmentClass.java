package com.newsampath.driving.school.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
public class AppoinmentClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate appoinmentDate;
    @Column
    @JsonFormat(pattern="HH:mm:ss")
    private LocalTime appoinmentTime;
    @Column
    private String username;
    @Column
    private int taken;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getAppoinmentDate() {
        return appoinmentDate;
    }

    public void setAppoinmentDate(LocalDate appoinmentDate) {
        this.appoinmentDate = appoinmentDate;
    }

    public LocalTime getAppoinmentTime() {
        return appoinmentTime;
    }

    public void setAppoinmentTime(LocalTime appoinmentTime) {
        this.appoinmentTime = appoinmentTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTaken() {
        return taken;
    }

    public void setTaken(int taken) {
        this.taken = taken;
    }
}
