package com.uab.controller;

import com.uab.dto.euromil.EuroMilRegisterRequestDTO;
import com.uab.dto.euromil.EuroMilRegisterResponseDTO;
import com.uab.service.EuroMilService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("euromil")
@Slf4j
@AllArgsConstructor
public class EuroMilController {

    private final EuroMilService euroMilService;

    @PostMapping(value = "register",
                 consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public EuroMilRegisterResponseDTO register(@RequestBody EuroMilRegisterRequestDTO request) {
        return this.euroMilService.registerEuroMil(request);
    }
}