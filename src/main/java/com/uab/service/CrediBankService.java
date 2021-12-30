package com.uab.service;

import com.uab.model.credibank.CheckResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "creditbank", url = "http://ken.utad.pt:8181")
public interface CrediBankService {

    @GetMapping(value = "check/{credit_account_id}/amount/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    CheckResponseDTO check(@PathVariable(name = "credit_account_id") String creditAccountId,
                           @PathVariable(name = "value") Integer value);
}