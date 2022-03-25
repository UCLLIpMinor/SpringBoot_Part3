package com.example.springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PatientController {

    @Autowired
    private AppService service;

    @GetMapping("/overview")
    public String overview (Model model) {
         model.addAttribute("patients", service.findAllPatients());
        return "overview-patient";
    }

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/add")
    public String add(Patient patient) {
        return "add-patient";
    }

    @PostMapping("/add")
    public String add(@Valid Patient patient, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-patient";
        }
        try {
            service.addPatient(patient);
        }
        catch (ServiceException exc) {
            model.addAttribute("error", exc.getMessage());
            return "add-patient";
        }
        return "redirect:/overview";
    }
}
