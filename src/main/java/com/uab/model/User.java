package com.uab.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class User {
    private long id;
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    private String email;
}