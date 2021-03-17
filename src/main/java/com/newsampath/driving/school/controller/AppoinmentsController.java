package com.newsampath.driving.school.controller;

import com.newsampath.driving.school.model.Appoinments;
import com.newsampath.driving.school.repository.AppoinmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")

public class AppoinmentsController {
    @Autowired
    private AppoinmentsRepository appoinmentsRepository;

    //get all appoinments
    @GetMapping("/appoinments")
    public List<Appoinments> getAllApplicants()
    {
        return appoinmentsRepository.findAll();
    }

    //Create appoinments REST API
    @PostMapping("/appoinments")
    public Appoinments createApplicant (@RequestBody Appoinments appoinments)
    {
        return appoinmentsRepository.save(appoinments);
    }
    //get appoinments by ID
    @GetMapping("/appoinments/{id}")
    public ResponseEntity<Appoinments> getApplicantById(@PathVariable Long id)
    {
        Appoinments appoinments = appoinmentsRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Appoinments not exist with id :" +id));
        return ResponseEntity.ok(appoinments);
    }

    //update appoinments rest api
    @PutMapping("/appoinments/{id}")
    public ResponseEntity<Appoinments> updateAppoinments(@PathVariable Long id,@RequestBody Appoinments appoinmentsDetails)
    {
        Appoinments appoinments = appoinmentsRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Applicant not exist with id :" +id));

        appoinments.setAppoinmentDate(appoinmentsDetails.getAppoinmentDate());
        appoinments.setAppoinmentTime(appoinmentsDetails.getAppoinmentTime());
        appoinments.setUsername(appoinmentsDetails.getUsername());

        Appoinments updatedApplicant = appoinmentsRepository.save(appoinments);
        return ResponseEntity.ok(updatedApplicant);
    }

    //delete appoinments rest api
    @DeleteMapping("/appoinments/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteAppoinment(@PathVariable Long id){
        Appoinments appoinments = appoinmentsRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Appoinments not exist with id :" +id));
        appoinmentsRepository.delete(appoinments);
        Map<String,Boolean> response =new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
