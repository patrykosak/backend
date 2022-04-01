package com.lfsr.demo.DTO;

import lombok.Data;

@Data
public class LFSR {
    String polynomial;
    String seed;
    int keyLength;
}
