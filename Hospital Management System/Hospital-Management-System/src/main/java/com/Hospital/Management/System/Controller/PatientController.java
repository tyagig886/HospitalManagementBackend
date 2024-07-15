package com.Hospital.Management.System.Controller;

import com.Hospital.Management.System.DocLoginEntity.Appointment;
import com.Hospital.Management.System.Entity.Patient;
import com.Hospital.Management.System.Repository.PatientRepositray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PatientController {


   private PatientRepositray patientRepositray;

    public PatientController(PatientRepositray patientRepositray) {
        this.patientRepositray = patientRepositray;
    }

    @PostMapping("/patients")
    public Patient createPatient(@RequestBody Patient patient){
     return    patientRepositray.save(patient);
    }
    @GetMapping("/patients")
    public List<Patient>getAllPatient(){
        return patientRepositray.findAll();
    }
    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient>getPatientById(@PathVariable long id) throws AttributeNotFoundException {
       Patient patient= patientRepositray.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient Not Found With Id"+id));
       return ResponseEntity.ok(patient);
    }
    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Map<String,Boolean>>deletePaitent(@PathVariable long id) throws AttributeNotFoundException {
        Patient patient= patientRepositray.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient Not Found With Id"+id));
        patientRepositray.delete(patient);
        Map<String,Boolean>response=new HashMap<String,Boolean>();
        response.put("Deletd",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<Patient>updatePatientById(@PathVariable long id,@RequestBody Patient patientDetails) throws AttributeNotFoundException {
        Patient patient= patientRepositray.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient Not Found With Id"+id));

        patient.setAge(patientDetails.getAge());
        patient.setName(patientDetails.getName());
        patient.setBlood(patientDetails.getBlood());
        patient.setDose(patientDetails.getDose());
        patient.setFees(patientDetails.getFees());
        patient.setPriscription(patientDetails.getPriscription());
        patient.setUrgency(patientDetails.getUrgency());
       Patient updatedPatient=patientRepositray.save(patient);
       return ResponseEntity.ok(updatedPatient);

    }
}
