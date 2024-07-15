package com.Hospital.Management.System.DocLogin.Repositary;

import com.Hospital.Management.System.DocLoginEntity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicinesRepo extends JpaRepository<Medicine,Long> {
}
