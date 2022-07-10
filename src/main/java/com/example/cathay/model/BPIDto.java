package com.example.cathay.model;

import lombok.Data;

@Data
public class BPIDto {
    private String code;
    private String symbol;
    private String rate;
    private String description;
    private Float rate_float;
}
