package com.Hospital.Management.System.DocLogin.controller;

import com.Hospital.Management.System.DocLogin.Repositary.MedicinesRepo;
import com.Hospital.Management.System.DocLoginEntity.Appointment;
import com.Hospital.Management.System.DocLoginEntity.Medicine;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v3")
public class MedicineController {

    private MedicinesRepo medicinesRepo;

    public MedicineController(MedicinesRepo medicinesRepo) {
        this.medicinesRepo = medicinesRepo;
    }

    @PostMapping("/medicines")
    public Medicine createMedicine(@RequestBody Medicine medicine){
        return medicinesRepo.save(medicine);
    }
    @GetMapping("/medicines")
    public List<Medicine> getAllMedicines(){
        return medicinesRepo.findAll();
    }

    @GetMapping("/medicines/{id}")
    public ResponseEntity<Medicine>getMedicineById(@PathVariable long id) throws AttributeNotFoundException {
        Medicine medicine=medicinesRepo.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine Not Found With Id"+id));
       return ResponseEntity.ok(medicine);
    }

    @PutMapping("/medicines/{id}")
    public ResponseEntity<Medicine>updateMedicine(@PathVariable long id,@RequestBody Medicine medicineDetails) throws AttributeNotFoundException {
        Medicine medicine=medicinesRepo.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine Not Found With Id"+id));

        medicine.setDrugName(medicineDetails.getDrugName());
        medicine.setStock(medicineDetails.getStock());

        medicinesRepo.save(medicine);
        return ResponseEntity.ok(medicine);
    }
    @DeleteMapping("/medicines/{id}")
    public ResponseEntity<Map<String,Boolean>>delete(@PathVariable long id) throws AttributeNotFoundException {
        Medicine medicine=medicinesRepo.findById(id).orElseThrow(()->new AttributeNotFoundException("Medicine Not Found With Id"+id));

        medicinesRepo.delete(medicine);
        Map<String,Boolean> response=new HashMap<>();
        response.put("Delete",Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
