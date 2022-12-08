package com.example.patientapp_backend.dao;

import com.example.patientapp_backend.model.Patients;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientDao extends CrudRepository<Patients,Integer> {
    @Query(value = "SELECT `id`, `address`, `dname`, `doapp`, `mobileno`, `pid`, `pname` FROM `patients` WHERE `pid`=:pid" ,nativeQuery = true)
    List<Patients> Search(@Param("pid") String pid);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `patients` WHERE `id`=:id",nativeQuery = true)
    void delete(@Param("id") Integer id);
}
