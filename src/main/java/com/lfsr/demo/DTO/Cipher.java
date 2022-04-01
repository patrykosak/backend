package com.lfsr.demo.DTO;

import lombok.Data;

@Data
public class Cipher {
    String polynomial;
    String seed;
    String text;
}
