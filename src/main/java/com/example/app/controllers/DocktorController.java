package com.example.app.controllers;

import com.example.app.models.Docktor;
import com.example.app.models.DocktorRepository;
import com.example.app.models.Hospital;
import com.example.app.models.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// curl localhost:8080/docktors/new -d name=Anna
// curl 'localhost:8080/docktors/'

@Controller
@RequestMapping(path = "/docktors")
public class DocktorController {
    @Autowired
    private DocktorRepository docktorRepository;

    @PostMapping(path = "/new")
    public @ResponseBody
    String create(@RequestParam String name) {
        Docktor docktor = new Docktor();
        docktor.setName(name);
        docktorRepository.save(docktor);
        return "Saved";
    }

    @GetMapping(path = "/")
    public @ResponseBody
    Iterable<Docktor> getAll() {
        return docktorRepository.findAll();
    }
}
