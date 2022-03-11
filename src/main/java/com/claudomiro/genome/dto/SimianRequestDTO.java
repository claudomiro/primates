package com.claudomiro.genome.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimianRequestDTO {

    public static SimianRequestDTO fromStringArray(String[] dna) {

        final List<String> asList = Arrays.asList(dna);
        final SimianRequestDTO o = new SimianRequestDTO();
        o.setDna(Arrays.asList(dna));
        return o;
    }

    private List<String> dna = new ArrayList<>();

    public List<String> getDna() {
        return dna;
    }

    public void setDna(List<String> dna) {
        if(dna == null) {
            throw new NullPointerException("String list could not be null");
        }
        final int expectedLength = dna.get(0).length();
        for (String str : dna) {
            if(str.length() != expectedLength) {
                throw new IllegalArgumentException("Expecting matrix " +
                        expectedLength + "x" + expectedLength);
            }
        }

        for (String str : dna) {
            for (int i = 0 ; i < str.length(); i++) {
                char c = str.charAt(i);
                final String validChars = "ACGT";
                if(!validChars.contains(str.substring(i, i+1))) {
                    throw new IllegalArgumentException("I dont know how to process char '" + c + "' (Must be one of ACGT");
                }
            }
        }
        this.dna = dna;
    }

    @Override
    public String toString() {
        return "SimianRequestDTO{" +
                "dna=" + dna +
                '}';
    }

}
