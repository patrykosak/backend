package com.lfsr.demo.controller;

import com.lfsr.demo.DTO.Cipher;
import com.lfsr.demo.DTO.LFSR;
import com.lfsr.demo.entity.LFSRCipher;
import com.lfsr.demo.entity.LFSRGenerator;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "")
@RestController
public class LFSRController {

    @PostMapping("/generator/random")
    public Boolean[] getPseudoGeneratedArray(@RequestBody LFSR lfsr){
        return LFSRGenerator.generate(lfsr.getPolynomial(), lfsr.getSeed(), lfsr.getKeyLength());
    }

    @PostMapping("/encode")
    public Boolean[] encodeText(@RequestBody Cipher cipher){
        return LFSRCipher.encode(cipher.getText(),cipher.getPolynomial(),cipher.getSeed());
    }

    @PostMapping("/decode")
    public String decodeText(@RequestBody Cipher cipher){
        return LFSRCipher.decode(cipher.getText(),cipher.getPolynomial(),cipher.getSeed());
    }

}
