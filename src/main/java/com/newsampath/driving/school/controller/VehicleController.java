package com.newsampath.driving.school.controller;

import com.newsampath.driving.school.model.Vehicle;
import com.newsampath.driving.school.repository.VehicleRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class VehicleController {
    @Autowired
    private VehicleRepositary vehicleRepositary;

    //get all vehicle
    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleRepositary.findAll();
    }

    //Create vehicle REST API
    @PostMapping("/vehicles")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleRepositary.save(vehicle);
    }

    //get vehicle by ID
    @GetMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Vehicle vehicle = vehicleRepositary.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Employee not exist with id :" + id));
        return ResponseEntity.ok(vehicle);
    }

    //update vehicle rest api
    @PutMapping("/vehicles/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicleDetails) {
        Vehicle vehicle = vehicleRepositary.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Employee not exist with id :" + id));

        vehicle.setPlateNo(vehicleDetails.getPlateNo());
        vehicle.setNoOfSeat(vehicleDetails.getNoOfSeat());
        vehicle.setVehicaleClass(vehicleDetails.getVehicaleClass());

        Vehicle updatedVehicle = vehicleRepositary.save(vehicle);
        return ResponseEntity.ok(updatedVehicle);
    }

    //delete vehicle rest api
    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteVehicle(@PathVariable Long id){
        Vehicle vehicle = vehicleRepositary.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Vehicle not exist with id :" +id));
        vehicleRepositary.delete(vehicle);
        Map<String,Boolean> response =new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
