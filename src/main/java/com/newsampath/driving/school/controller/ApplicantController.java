package com.newsampath.driving.school.controller;

import com.newsampath.driving.school.model.Applicant;
import com.newsampath.driving.school.repository.ApplicantReposiary;
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

public class ApplicantController {
    @Autowired
    private ApplicantReposiary applicantReposiary;

    //get all applicants
    @GetMapping("/applicants")
    public List<Applicant> getAllApplicants()
    {
        return applicantReposiary.findAll();
    }

    //Create applicant REST API
    @PostMapping("/applicants")
    public Applicant createApplicant (@RequestBody Applicant applicant)
    {
        return applicantReposiary.save(applicant);
    }

    //get appliants by ID
    @GetMapping("/applicants/{id}")
    public ResponseEntity<Applicant> getApplicantById(@PathVariable Long id)
    {
        Applicant applicant = applicantReposiary.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Applicant not exist with id :" +id));
        return ResponseEntity.ok(applicant);
    }

    //update applicant rest api
    @PutMapping("/applicants/{id}")
    public ResponseEntity<Applicant> updateApplicant(@PathVariable Long id,@RequestBody Applicant applicantDetails)
    {
        Applicant applicant = applicantReposiary.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Applicant not exist with id :" +id));

        applicant.setIdNumber(applicantDetails.getIdNumber());
        applicant.setIdType(applicantDetails.getIdType());
        applicant.setFullName(applicantDetails.getFullName());
        applicant.setAddress(applicantDetails.getAddress());
        applicant.setTelephoneNo(applicantDetails.getTelephoneNo());
        applicant.setGender(applicantDetails.getGender());
        applicant.setBirthDay((Date) applicantDetails.getBirthDay());
        applicant.setLicenceType(applicantDetails.getLicenceType());
        applicant.setAdvance(applicantDetails.getAdvance());
        applicant.setAdvancedDate(applicantDetails.getAdvancedDate());
        applicant.setMedicalId(applicantDetails.getMedicalId());
        applicant.setVehicaleClass(applicantDetails.getVehicaleClass());
        applicant.setDescription(applicantDetails.getDescription());

        Applicant updatedApplicant = applicantReposiary.save(applicant);
        return ResponseEntity.ok(updatedApplicant);
    }

    //delete employee rest api
    @DeleteMapping("/applicants/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteApplicant(@PathVariable Long id){
        Applicant applicant = applicantReposiary.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Applicant not exist with id :" +id));
        applicantReposiary.delete(applicant);
        Map<String,Boolean> response =new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
