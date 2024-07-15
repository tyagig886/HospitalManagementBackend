package com.Hospital.Management.System.DocLogin.controller;

import com.Hospital.Management.System.DocLogin.Repositary.AppointmentsRepo;
import com.Hospital.Management.System.DocLogin.Repositary.MedicinesRepo;
import com.Hospital.Management.System.DocLoginEntity.Appointment;
import com.Hospital.Management.System.Entity.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class AppointmentController {

    private AppointmentsRepo appointmentsRepo;

    public AppointmentController(AppointmentsRepo appointmentsRepo) {
        this.appointmentsRepo = appointmentsRepo;
    }

    @PostMapping("/appointments")
    public Appointment createAppointment(@RequestBody Appointment appointment){

        return appointmentsRepo.save(appointment);
    }
    @GetMapping("/appointments")
    public List<Appointment> getAllAppontsments(){
        return appointmentsRepo.findAll();
    }
    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Map<String,Boolean>>deleteAppointment(@PathVariable long id) throws AttributeNotFoundException {
      Appointment appointment= appointmentsRepo.findById(id).orElseThrow(()->new AttributeNotFoundException("Appointment Not Found With Id"+id));

      appointmentsRepo.delete(appointment);
        Map<String,Boolean>response=new HashMap<String,Boolean>();
        response.put("Deletd",Boolean.TRUE);
       return ResponseEntity.ok(response);

    }
}
