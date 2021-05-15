package com.newsampath.driving.school.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.tomcat.jni.Local;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class AppoinmentClssDto {
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate appoinmentDate;
    @JsonFormat(pattern="HH:mm:ss")
    private LocalTime appoinmentTime;
    private String username;
    private int taken;

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
