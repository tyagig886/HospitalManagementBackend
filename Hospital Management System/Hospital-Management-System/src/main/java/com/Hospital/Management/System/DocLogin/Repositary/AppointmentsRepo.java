package com.Hospital.Management.System.DocLogin.Repositary;

import com.Hospital.Management.System.DocLoginEntity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentsRepo extends JpaRepository<Appointment,Long> {
}
