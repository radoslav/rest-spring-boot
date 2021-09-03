package com.example.app.controllers;

import com.example.app.models.Appointment;
import com.example.app.models.AppointmentRepository;
import com.example.app.models.Hospital;
import com.example.app.models.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

// curl localhost:8080/appointments/new -d dateFrom=2021-09-03T19:15:30.480323304
// curl 'localhost:8080/appointments/'
// curl 'localhost:8080/appointments/now'

@Controller
@RequestMapping(path = "/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping(path = "/new")
    public @ResponseBody
    String create(@RequestParam String dateFrom) {
        Appointment appointment = new Appointment();
        appointment.setDateFrom(LocalDateTime.parse(dateFrom));
        appointmentRepository.save(appointment);
        return "Saved";
    }

    @GetMapping(path = "/")
    public @ResponseBody
    Iterable<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @GetMapping(path = "/now")
    public @ResponseBody
    Appointment get() {
        Appointment appointment = new Appointment();
        appointment.setDateFrom(LocalDateTime.now());
        return appointment;
    }
}
