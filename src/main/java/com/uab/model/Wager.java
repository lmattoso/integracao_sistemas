package com.uab.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Wager {
    @NotBlank(message = "Número da conta obrigatório")
    private String creditAccountId;

    @NotBlank(message = "Chave obrigatória")
    private String key;

    private Integer amount;

    private String message;
}