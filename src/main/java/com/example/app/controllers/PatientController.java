package com.example.app.controllers;

import com.example.app.models.Patient;
import com.example.app.models.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// curl localhost:8080/patients/new -d name=Anna
// curl 'localhost:8080/patients/'

@Controller
@RequestMapping(path = "/patients")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping(path = "/new")
    public @ResponseBody
    String create(@RequestParam String name) {
        Patient patient = new Patient();
        patient.setName(name);
        patientRepository.save(patient);
        return "Saved";
    }

    @GetMapping(path = "/")
    public @ResponseBody
    Iterable<Patient> getAllHospitals() {
        return patientRepository.findAll();
    }
}
