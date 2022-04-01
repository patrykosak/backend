package com.lfsr.demo.entity;

import java.util.Arrays;

public class LFSRGenerator {
    public static final boolean _1 = true;
    public static final boolean _0 = false;

    public static Boolean[] generate(String polynomialString, String seedString, int keyLength) {


        Boolean[] polynomial = seedString.chars().mapToObj((c) -> (char)c == '1').toArray(Boolean[]::new);
        Boolean[] seed_init = seedString.chars().mapToObj((c) -> (char)c == '1').toArray(Boolean[]::new);

        Boolean[] seed = Arrays.copyOf(seed_init, seed_init.length);
        Boolean[] key = new Boolean[keyLength];
        boolean xor;
        for (int i = 0; i < keyLength; i++) {
            key[i] = seed[seed.length - 1];
            xor = LFSRGenerator.performXors(polynomial, seed);
            LFSRGenerator.shiftBits(seed);
            seed[0] = xor;
        }
        return key;
    }

    private static boolean performXors(Boolean[] polynomial, Boolean[] seed) {
        boolean result = false;
        for (int i = 0; i < polynomial.length; i++) {
            if (polynomial[i]) {
                result ^= seed[i];
            }
        }
        return result;
    }

    private static void shiftBits(Boolean[] seed) {
        for (int i = seed.length - 1; i > 0; i--) {
            seed[i] = seed[i-1];
        }
    }
}
