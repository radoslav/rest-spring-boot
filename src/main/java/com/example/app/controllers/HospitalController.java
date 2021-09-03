package com.example.app.controllers;

import com.example.app.models.Hospital;
import com.example.app.models.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// curl localhost:8080/hospital/new -d name=Anna
// curl 'localhost:8080/hospital/all'

@Controller
@RequestMapping(path = "/hospital")
public class HospitalController {
    @Autowired
    private HospitalRepository hospitalRepository;

    @PostMapping(path = "/new")
    public @ResponseBody
    String newHospital(@RequestParam String name) {
        Hospital hospital = new Hospital();
        hospital.setName(name);
        hospitalRepository.save(hospital);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }
}
