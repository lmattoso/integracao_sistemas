package com.uab.service;

import com.uab.dto.credibank.CheckResponseDTO;
import com.uab.dto.euromil.EuroMilRegisterRequestDTO;
import com.uab.dto.euromil.EuroMilRegisterResponseDTO;
import com.uab.model.Wager;
import com.uab.repository.WagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WagerService {

    private final CreditBankService creditBankService;
    private final EuroMilService euroMilService;
    private final WagerRepository repository;

    public void register(Wager wager) {
        try {
            CheckResponseDTO checkResponseDTO = creditBankService.check(wager.getCreditAccountId(), wager.getAmount());

            EuroMilRegisterResponseDTO responseDTO = euroMilService.registerEuroMil(EuroMilRegisterRequestDTO.builder()
                    .checkid(checkResponseDTO.getCheckID())
                    .key(wager.getKey())
                    .build());

            wager.setMessage(responseDTO.getMessage());

            repository.save(wager);
        } catch (RuntimeException e) {
                wager.setMessage(e.getMessage());
            repository.save(wager);
        }
    }

    public List<Wager> getAll() {
        return repository.getAll();
    }
}
