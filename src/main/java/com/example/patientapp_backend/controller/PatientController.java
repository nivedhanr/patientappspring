package com.example.patientapp_backend.controller;

import com.example.patientapp_backend.dao.PatientDao;
import com.example.patientapp_backend.model.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PatientController {
    @Autowired
    private PatientDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public Map<String,String> PatientAdd(@RequestBody Patients p)
    {
        System.out.println(p.getPid().toString());
        System.out.println(p.getPname().toString());
        System.out.println(p.getAddress().toString());
        System.out.println(p.getMobileno().toString());
        System.out.println(p.getDoapp().toString());
        System.out.println(p.getDname().toString());
        dao.save(p);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    private List<Patients> PatientView(){

        return (List<Patients>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Patients> Search(@RequestBody Patients p) {
        String pid = p.getPid();
        System.out.println(pid);
        return (List<Patients>) dao.Search(p.getPid());

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> Delete(@RequestBody Patients p)
    {
        String id=String.valueOf(p.getId());
        System.out.println(id);
        dao.delete(p.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

}