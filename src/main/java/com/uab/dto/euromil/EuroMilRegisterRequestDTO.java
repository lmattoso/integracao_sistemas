package com.uab.dto.euromil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EuroMilRegisterRequestDTO {
    private String key;
    private String checkid;
}