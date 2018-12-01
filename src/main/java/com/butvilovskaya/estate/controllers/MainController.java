package com.butvilovskaya.estate.controllers;

import com.butvilovskaya.estate.interfaces.RealtorRepository;
import com.butvilovskaya.estate.models.Realtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private RealtorRepository realtorRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Realtor> realtors = realtorRepository.findAll();
        model.put("realtor", realtors);
        return "main";
    }


    @PostMapping("/main")
    public String add(@RequestParam String name, @RequestParam String agency, @RequestParam String contact, Map<String, Object> model) {
        Realtor realtor = new Realtor(name, agency, contact);
        realtorRepository.save(realtor);
        Iterable<Realtor> realtors = realtorRepository.findAll();
        model.put("realtor", realtors);
        return "main";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Realtor> realtors;
        if (filter != null && !filter.isEmpty()) {
            realtors = realtorRepository.findByName(filter);
        } else {
            realtors = realtorRepository.findAll();
        }
        model.put("realtor", realtors);
        return "main";
    }


}
