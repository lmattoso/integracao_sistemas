package com.uab.controller;

import com.uab.dto.credibank.CheckResponseDTO;
import com.uab.service.CreditBankService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("credbank")
@Slf4j
@AllArgsConstructor
public class CrediBankController {

    private final CreditBankService creditBankService;

    @GetMapping(value = "check/{credit_account_id}/amount/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CheckResponseDTO getCheck(@PathVariable(name = "credit_account_id") String creditAccountId,
                                     @PathVariable(name = "value") Integer value) {
        return this.creditBankService.check(creditAccountId, value);
    }
}