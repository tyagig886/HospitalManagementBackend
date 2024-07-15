package com.Hospital.Management.System.Repository;

import com.Hospital.Management.System.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepositray extends JpaRepository<Patient,Long> {
}
