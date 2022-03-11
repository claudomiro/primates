package com.claudomiro.genome.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimianRequestDTOTests {

    @Test
    public void nullSafe() {
        assertThrows(NullPointerException.class, () -> {
            final SimianRequestDTO dto = new SimianRequestDTO();
            dto.setDna(null);
        });
    }

    @Test
    public void notSquared() {
        assertThrows(IllegalArgumentException.class, () -> {
            final SimianRequestDTO dto = SimianRequestDTO.fromStringArray(new String[]{"a", "ab", "cde"});
        });
    }

    @Test
    void mustBeValidBase() {
        assertThrows(IllegalArgumentException.class, () -> {
            SimianRequestDTO.fromStringArray(new String[]{"claudomiro"});
        });
    }






}
