package com.uab.controller;

import com.uab.model.euromil.RegisterRequestDTO;
import com.uab.model.euromil.RegisterResponseDTO;
import com.uab.service.EuroMilService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("euromil")
@Slf4j
public class EuroMilController {

    @Autowired
    private EuroMilService euroMilService;

    @PostMapping(value = "register",
                 consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponseDTO register(@RequestBody RegisterRequestDTO request) {
        return this.euroMilService.registerEuroMil(request);
    }
}