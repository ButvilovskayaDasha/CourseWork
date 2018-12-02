package com.butvilovskaya.estate.controllers;

import com.butvilovskaya.estate.interfaces.RealtorRepository;
import com.butvilovskaya.estate.models.Realtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {
    @Autowired
    private RealtorRepository realtorRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Realtor> realtors = realtorRepository.findAll();
        if (filter != null && !filter.isEmpty()) {
            realtors = realtorRepository.findByName(filter);
        } else {
            realtors = realtorRepository.findAll();
        }
        model.addAttribute("realtor", realtors);
        model.addAttribute("filter", filter);
        return "main";
    }


    @PostMapping("/main")
    public String add(@RequestParam String name,
                      @RequestParam String agency,
                      @RequestParam String contact,
                      Map<String, Object> model,
                      @RequestParam("file") MultipartFile file) throws IOException {
        Realtor realtor = new Realtor(name, agency, contact);
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." +file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFilename));
            realtor.setFilename(resultFilename);
        }
        realtorRepository.save(realtor);
        Iterable<Realtor> realtors = realtorRepository.findAll();
        model.put("realtor", realtors);
        return "main";
    }
}
